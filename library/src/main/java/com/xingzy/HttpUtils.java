package com.xingzy;

/**
 * @author roy.xing
 * @date 2019/3/12
 */
public class HttpUtils {

    public static <T, P> void sendRequest(T requestdata, String method, String url, Class<P> responseclass, JsonCallbackListener jsonCallbackListener) {
        CallbackListenerImpl callbackListener = new CallbackListenerImpl(responseclass, jsonCallbackListener);
        HttpRequestImpl httpRequest = new HttpRequestImpl();
        HttpTask httpTask = new HttpTask(requestdata, method, url, httpRequest, callbackListener);
        ThreadPoolManger.getInstance().addTask(httpTask);
    }
}
