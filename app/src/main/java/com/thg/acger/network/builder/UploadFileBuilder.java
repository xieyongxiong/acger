package com.thg.acger.network.builder;

import java.io.File;
import java.util.Map;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;

/**
 * Created by xieyongxiong on 2017/9/21.
 */

public class UploadFileBuilder extends HttpBuilder<UploadFileBuilder> implements HasParamsable {

    private MultipartBody.Builder builder;

    public UploadFileBuilder(OkHttpClient okHttpClient) {
        super(okHttpClient);
    }

    public UploadFileBuilder setFile(String key, String fileName, File file) {
        RequestBody fileBody = RequestBody.create(MediaType.parse("application/octet-stream"), file);
        builder = new MultipartBody.Builder()
                .setType(MultipartBody.FORM)
                .addFormDataPart(key, fileName, fileBody);
        return this;

    }

    @Override
    public UploadFileBuilder addParams(String key, String val) {
        builder.addFormDataPart(key, val);
        return this;
    }

    @Override
    public UploadFileBuilder params(Map<String, String> params) {
        return this;
    }

    @Override
    public void execute(Callback callback) {
        RequestBody requestBody = builder.build();
        Request request = new Request.Builder()
                .url(url)
                .post(requestBody)
                .build();
        Call call = okHttpClient.newCall(request);
        call.enqueue(callback);
    }
}
