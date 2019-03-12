package com.xingzy;

import com.alibaba.fastjson.JSON;

import java.io.UnsupportedEncodingException;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 * @author roy.xing
 * @date 2019/3/12
 */
public class HttpTask<T> implements Delayed, Runnable {

    private HttpRequest httpRequest;
    private int retryCount;
    private long delayTime;

    public HttpTask(T requestData, String method, String url, HttpRequestImpl httpRequest, CallbackListenerImpl callbackListener) {
        this.httpRequest = httpRequest;
        httpRequest.setMethod(method);
        httpRequest.setUrl(url);
        httpRequest.setListener(callbackListener);

        String content = JSON.toJSONString(requestData);
        try {
            httpRequest.setData(content.getBytes("UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        try {
            httpRequest.execute();
        } catch (Exception e) {
            ThreadPoolManger.getInstance().addDelayTask(this);
        }
    }

    @Override
    public long getDelay(TimeUnit unit) {
        return unit.convert(delayTime - System.currentTimeMillis(), TimeUnit.MILLISECONDS);
    }

    @Override
    public int compareTo(Delayed o) {
        return 0;
    }

    public int getRetryCount() {
        return retryCount;
    }

    public void setRetryCount(int retryCount) {
        this.retryCount = retryCount;
    }

    public long getDelayTime() {
        return delayTime;
    }

    public void setDelayTime(long delayTime) {
        this.delayTime = delayTime + System.currentTimeMillis();
    }
}
