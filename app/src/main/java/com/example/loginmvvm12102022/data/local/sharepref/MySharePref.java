package com.example.loginmvvm12102022.data.local.sharepref;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.stream.IntStream;

import kotlin.Triple;

public class MySharePref {
    private static MySharePref instance = null;
    private final SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;

    private MySharePref(Context context) {
        sharedPreferences = context.getSharedPreferences( "My_cache", Context.MODE_PRIVATE);

    }

    public static MySharePref getInstance(Context context) {
        if (instance == null){
            instance = new MySharePref(context);
        }
        return instance;
    }

    public void saveAccount(Triple<String, String, Boolean> triple) {
        editor = sharedPreferences.edit();
        editor.putString("password", triple.getFirst());
        editor.putString("account", triple.getSecond());
        editor.putString("isRemember", String.valueOf((triple.getThird())));
        editor.commit();

    }

    public Triple<String, String, Boolean> getAccount() {
        String account = sharedPreferences.getString("account", "");
        String password = sharedPreferences.getString("password", "");
        Boolean isRemember = Boolean.valueOf(sharedPreferences.getString("isRemember", "false"));
        return null;
    }

}
