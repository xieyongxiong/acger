package com.thg.acger.network;

import com.thg.acger.network.builder.GetBuilder;
import com.thg.acger.network.builder.PostBuilder;
import com.thg.acger.network.builder.UploadFileBuilder;

import okhttp3.OkHttpClient;

/**
 * Created by xieyongxiong on 2017/9/12.
 */

public class NetworkUtil {
    public static volatile NetworkUtil instance;
    private static OkHttpClient okHttpClient;

    public static NetworkUtil getInstance() {
        if (instance == null) {
            synchronized (NetworkUtil.class) {
                if (instance == null) {
                    okHttpClient = new OkHttpClient();
                    instance = new NetworkUtil();
                }
            }
        }
        return instance;
    }

    public GetBuilder getMethod() {
        GetBuilder builder = new GetBuilder(okHttpClient);
        return builder;
    }

    public PostBuilder postMethod() {
        PostBuilder builder = new PostBuilder(okHttpClient);
        return builder;
    }

    public UploadFileBuilder uploadFileMethod() {
        UploadFileBuilder builder = new UploadFileBuilder(okHttpClient);
        return builder;
    }

    public static GetBuilder get() {
        return getInstance().getMethod();
    }

    public static PostBuilder post() {
        return getInstance().postMethod();
    }

    public static UploadFileBuilder uploadFile() {
        return getInstance().uploadFileMethod();
    }


}
