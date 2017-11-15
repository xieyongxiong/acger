package com.thg.acger.network.builder;

import java.util.LinkedHashMap;
import java.util.Map;

import okhttp3.Callback;
import okhttp3.OkHttpClient;

/**
 * Created by xieyongxiong on 2017/9/12.
 */

public abstract class HttpBuilder<T extends HttpBuilder> {
    protected String url;
    protected Object tag;
    protected Map<String, String> headers;
    protected Map<String, String> params;
    protected int id;
    protected OkHttpClient okHttpClient;

    public HttpBuilder(OkHttpClient okHttpClient) {
        this.okHttpClient = okHttpClient;
    }

    public T id(int id) {
        this.id = id;
        return (T) this;
    }

    public T setUrl(String url) {
        this.url = url;
        return (T) this;
    }


    public T tag(Object tag) {
        this.tag = tag;
        return (T) this;
    }

    public T headers(Map<String, String> headers) {
        this.headers = headers;
        return (T) this;
    }

    public T addHeader(String key, String val) {
        if (this.headers == null) {
            headers = new LinkedHashMap<>();
        }
        headers.put(key, val);
        return (T) this;
    }

    public abstract void execute(Callback callback);
}
