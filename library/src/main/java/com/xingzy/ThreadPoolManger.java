package com.xingzy;

import android.util.Log;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author roy.xing
 * @date 2019/3/12
 */
public class ThreadPoolManger {

    private static volatile ThreadPoolManger instance;
    private ThreadPoolExecutor threadPoolExecutor;
    private LinkedBlockingDeque mQueue;
    private DelayQueue<HttpTask> delayQueue;

    private ThreadPoolManger() {
        mQueue = new LinkedBlockingDeque();
        delayQueue = new DelayQueue<>();
        threadPoolExecutor = new ThreadPoolExecutor(3, 10, 15, TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(4), new RejectedExecutionHandler() {
            @Override
            public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
                addTask(r);
            }
        });

        Runnable coreRunnable = new Runnable() {
            @Override
            public void run() {
                Runnable runnable = null;
                while (true) {
                    try {
                        runnable = (Runnable) mQueue.take();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    threadPoolExecutor.execute(runnable);
                }
            }
        };

        Runnable delayRunnable = new Runnable() {
            @Override
            public void run() {
                HttpTask httpTask = null;
                while (true) {
                    try {
                        httpTask = delayQueue.take();
                        if (httpTask.getRetryCount() < 3) {
                            threadPoolExecutor.execute(httpTask);
                            httpTask.setRetryCount(httpTask.getRetryCount() + 1);
                            Log.e("===>roy", "重试" + httpTask.getRetryCount() + "次");
                        } else {
                            Log.e("===>roy", "重试失败");
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            }
        };
        threadPoolExecutor.execute(coreRunnable);
        threadPoolExecutor.execute(delayRunnable);
    }

    public static ThreadPoolManger getInstance() {
        if (instance == null) {
            instance = new ThreadPoolManger();
        }
        return instance;
    }

    public void addTask(Runnable runnable) {
        if (runnable != null) {
            try {
                mQueue.put(runnable);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void addDelayTask(HttpTask httpTask) {
        if (httpTask != null) {
            httpTask.setDelayTime(3000);
            delayQueue.offer(httpTask);
        }
    }
}
