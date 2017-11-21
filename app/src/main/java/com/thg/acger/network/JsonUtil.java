package com.thg.acger.network;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

/**
 * Created by xieyongxiong on 2017/9/12.
 */

public class JsonUtil {
    private static volatile JsonUtil instance;
    private static Gson gson;

    public static JsonUtil getInstance() {
        if (instance == null) {
            synchronized (NetworkUtil.class) {
                if (instance == null) {
                    instance = new JsonUtil();
                    gson = new Gson();

                }
            }
        }
        return instance;
    }

    public Object decodeJsonObject(String json, Class c) {
        Object o = new Object();
        Log.i("wuni","json"+json);
        try {
            o = gson.fromJson(json, c);
        } catch (JsonSyntaxException ex) {
            Log.i("thg", "exception");
            return null;
        }
        return o;
    }
}
