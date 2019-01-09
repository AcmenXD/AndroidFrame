package com.acmenxd.frame.utils;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author AcmenXD
 * @version v1.0
 * @github https://github.com/AcmenXD
 * @date 2019/1/9 14:28
 * @detail Gson工具类
 */
public class GsonUtils {
    /**
     * 直接解析数组结构的json
     * // [{"type": "123","value": 123},{"type": "234","value": 234}]
     *
     * @return List<Data> bean = jsonToList(json, Data[].class)
     */
    public static <T> List<T> jsonToList(String json, Class<T[]> pClass) {
        Gson gson = new Gson();
        T[] array = gson.fromJson(json, pClass);
        return Arrays.asList(array);
    }

    /**
     * 直接解析数组结构的json
     * // [{"type": "123","value": 123},{"type": "234","value": 234}]
     *
     * @return ArrayList<Data> bean = jsonToArrayList(json, Data.class);
     */
    public static <T> ArrayList<T> jsonToArrayList(String json, Class<T> pClass) {
        Type type = new TypeToken<ArrayList<JsonObject>>() {
        }.getType();
        ArrayList<JsonObject> jsonObjects = new Gson().fromJson(json, type);
        ArrayList<T> arrayList = new ArrayList<>();
        for (JsonObject jsonObject : jsonObjects) {
            arrayList.add(new Gson().fromJson(jsonObject, pClass));
        }
        return arrayList;
    }
}
