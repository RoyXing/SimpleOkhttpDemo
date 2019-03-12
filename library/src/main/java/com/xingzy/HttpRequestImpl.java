package com.xingzy;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * @author roy.xing
 * @date 2019/3/12
 */
public class HttpRequestImpl implements HttpRequest {

    private String method;
    private String address;
    private byte[] bytes;
    private CallbackListener callbackListener;
    private HttpURLConnection urlConnection;

    @Override
    public void setMethod(String method) {
        this.method = method;
    }

    @Override
    public void setUrl(String url) {
        this.address = url;
    }

    @Override
    public void setData(byte[] bytes) {
        this.bytes = bytes;
    }

    @Override
    public void setListener(CallbackListener callbackListener) {
        this.callbackListener = callbackListener;
    }

    @Override
    public void execute() {
        URL url;
        try {
            url = new URL(address);
            urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setConnectTimeout(6000);//连接超时时间
            urlConnection.setUseCaches(false);//不使用缓存
            urlConnection.setInstanceFollowRedirects(true);//成员函数，仅作用于当前函数，设置这个连接是否可以被重定向
            urlConnection.setReadTimeout(3000);//响应的超时时间
            urlConnection.setDoInput(true);//设置这个连接是否可以写入数据
            urlConnection.setDoOutput(true);//设置这个连接是否可以输出数据
            urlConnection.setRequestMethod(method);
            urlConnection.setRequestProperty("Content-type", "application/json;charset=UTF-8");//设置消息类型
            urlConnection.connect();

            OutputStream out = urlConnection.getOutputStream();
            BufferedOutputStream bos = new BufferedOutputStream(out);
            bos.write(bytes);
            bos.flush();
            out.close();
            bos.close();

            if (urlConnection.getResponseCode() == HttpURLConnection.HTTP_OK) {
                InputStream inputStream = urlConnection.getInputStream();
                callbackListener.success(inputStream);
            } else {
                callbackListener.failure();
                throw new RuntimeException("错误返回码:" + urlConnection.getResponseCode());
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            urlConnection.disconnect();
        }
    }
}
