package com.issac.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * author:  ywy
 * date:  2018-09-11
 * desc:
 */
public class JsonUtil {
    public static String toJson(Object object) {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setPrettyPrinting();
        Gson gson = gsonBuilder.create();
        return gson.toJson(object);
    }
}