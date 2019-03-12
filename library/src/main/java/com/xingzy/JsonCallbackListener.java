package com.xingzy;

/**
 * @author roy.xing
 * @date 2019/3/12
 */
public interface JsonCallbackListener<T> {

    void success(T t);

    void failure();
}
