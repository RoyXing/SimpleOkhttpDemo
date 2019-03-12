package com.xingzy;

import android.os.Handler;
import android.os.Looper;

import com.alibaba.fastjson.JSON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * @author roy.xing
 * @date 2019/3/12
 */
public class CallbackListenerImpl<T> implements CallbackListener {

    private Class<T> responseClass;
    private JsonCallbackListener callbackListener;
    private Handler handler;

    public CallbackListenerImpl(Class<T> responseClass, JsonCallbackListener callbackListener) {
        this.responseClass = responseClass;
        this.callbackListener = callbackListener;
        handler = new Handler(Looper.getMainLooper());
    }

    @Override
    public void success(InputStream inputStream) {
        try {
            String content = getContent(inputStream);
            final T parseObject = JSON.parseObject(content, responseClass);
            handler.post(new Runnable() {
                @Override
                public void run() {
                    callbackListener.success(parseObject);
                }
            });

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String getContent(InputStream inputStream) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        StringBuilder sb = new StringBuilder();
        String line = null;
        while ((line = reader.readLine()) != null) {
            sb.append(line + "\n");
        }
        return sb.toString();
    }

    @Override
    public void failure() {
        handler.post(new Runnable() {
            @Override
            public void run() {
                callbackListener.failure();
            }
        });
    }
}
