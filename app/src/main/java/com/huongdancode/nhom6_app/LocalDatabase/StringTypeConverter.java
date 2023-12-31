package com.huongdancode.nhom6_app.LocalDatabase;

import androidx.room.TypeConverter;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class StringTypeConverter {
    private static Gson gson = new Gson();
    @TypeConverter
    public static List<String> stringToSomeObjectList(String data) {
        if (data == null) {
            return Collections.emptyList();
        }
        Type listType = new TypeToken<ArrayList<String>>() {}.getType();
        return gson.fromJson(data, listType);
    }

    @TypeConverter
    public static String someObjectListToString(List<String> someObjects) {
        return gson.toJson(someObjects);
    }


}
