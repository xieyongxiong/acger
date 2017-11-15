package com.thg.acger.network.builder;

import android.net.Uri;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;

/**
 * Created by xieyongxiong on 2017/9/12.
 */

public class GetBuilder extends HttpBuilder<GetBuilder> implements HasParamsable {


    public GetBuilder(OkHttpClient okHttpClient) {
        super(okHttpClient);
    }

    @Override
    public void execute(Callback callback) {
        if (params != null) {
            url = appendParams(url, params);
        }
        final Request request = new Request.Builder()
                .url(this.url)
                .build();
        Call call = okHttpClient.newCall(request);
        call.enqueue(callback);
    }

    protected String appendParams(String url, Map<String, String> params) {
        if (url == null || params == null || params.isEmpty()) {
            return url;
        }
        Uri.Builder builder = Uri.parse(url).buildUpon();
        Set<String> keys = params.keySet();
        Iterator<String> iterator = keys.iterator();
        while (iterator.hasNext()) {
            String key = iterator.next();
            builder.appendQueryParameter(key, params.get(key));
        }
        return builder.build().toString();
    }

    @Override
    public GetBuilder addParams(String key, String val) {
        if (this.params == null) {
            params = new LinkedHashMap<>();
        }
        params.put(key, val);
        return this;
    }

    @Override
    public GetBuilder params(Map<String, String> params) {
        this.params = params;
        return this;
    }

    public HttpBuilder decodeJson(Class c) {
        return this;
    }


}
