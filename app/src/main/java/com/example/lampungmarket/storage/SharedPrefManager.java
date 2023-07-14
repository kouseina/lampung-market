package com.example.lampungmarket.storage;


import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.example.lampungmarket.models.UserItem;

public class SharedPrefManager {

    private static SharedPreferences getSharedPreference(Context context){
        return PreferenceManager.getDefaultSharedPreferences(context);
    }

    public static void setUser(Context context, UserItem userItem){
        SharedPreferences.Editor editor = getSharedPreference(context).edit();
        editor.putString("id", userItem.id);
        editor.putString("fullname", userItem.fullname);
        editor.putString("email", userItem.email);
        editor.putString("phone", userItem.phone);
        editor.apply();
    }

    public static UserItem getUser(Context context){
        return new UserItem(
                getSharedPreference(context).getString("id",""),
                getSharedPreference(context).getString("fullname",""),
                getSharedPreference(context).getString("email",""),
                getSharedPreference(context).getString("phone","")
        );
    }

    public static boolean getLoggedInStatus(Context context){
        return getSharedPreference(context).getString("id","") != "";
    }


    public static void clearAll (Context context){
        SharedPreferences.Editor editor = getSharedPreference(context).edit();
        editor.clear();
        editor.apply();
    }
}