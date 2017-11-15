package com.thg.acger.network.builder;

import java.util.Map;

/**
 * Created by xieyongxiong on 2017/9/11.
 */

public interface HasParamsable {
    HttpBuilder addParams(String key, String val);

    HttpBuilder params(Map<String, String> params);
}
