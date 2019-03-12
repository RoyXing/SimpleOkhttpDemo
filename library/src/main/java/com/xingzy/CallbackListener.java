package com.xingzy;

import java.io.InputStream;

/**
 * @author roy.xing
 * @date 2019/3/12
 */
public interface CallbackListener {

    void success(InputStream inputStream);

    void failure();
}
