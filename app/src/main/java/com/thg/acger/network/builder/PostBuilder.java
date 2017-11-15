package com.thg.acger.network.builder;

import java.util.Map;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;

/**
 * Created by xieyongxiong on 2017/9/12.
 */

public class PostBuilder extends HttpBuilder<PostBuilder> implements HasParamsable {

    private FormBody.Builder formBuilder;

    public PostBuilder(OkHttpClient okHttpClient) {
        super(okHttpClient);
        formBuilder = new FormBody.Builder();

    }

    @Override
    public PostBuilder addParams(String key, String val) {
        formBuilder.add(key, val);
        return this;
    }

    @Override
    public PostBuilder params(Map<String, String> params) {
        this.params = params;
        return this;
    }

    @Override
    public void execute(Callback callback) {
        RequestBody formBody = formBuilder.build();
        Request request = new Request.Builder()
                .url(this.url)
                .post(formBody)
                .build();
        Call call = okHttpClient.newCall(request);
        call.enqueue(callback);

    }
}
