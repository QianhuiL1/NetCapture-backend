package com.ruoyi.common.utils.idfs;

import com.google.gson.*;

public class JsonUtil {

    public static <T> void jsonStringToObject(String jsonString, Class<T> classOfT){
        Gson g = new Gson();
        g.fromJson(jsonString,classOfT);
    }

    public static <T> String objectToJsonString(Class<T> classOfT){
        Gson g = new Gson();
        return g.toJson(classOfT);
    }

    public static void main(String args[]){

    }
}
