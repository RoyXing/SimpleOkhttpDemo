package com.xingzy;

/**
 * @author roy.xing
 * @date 2019/3/12
 */
public interface HttpRequest {

    void setMethod(String method);

    void setUrl(String url);

    void setData(byte[] bytes);

    void setListener(CallbackListener callbackListener);

    void execute();
}
