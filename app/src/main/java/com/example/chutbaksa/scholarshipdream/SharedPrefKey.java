package com.example.chutbaksa.scholarshipdream;

/**
 * Created by chutbaksa on 2015. 5. 26..
 */

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;

public class SharedPrefKey {


    private final String PREF_NAME = "User_Info";

    public final static String PREF_SCHOOL = "PREF_SCHOOL";
    public final static String PREF_LOCAL = "PREF_LOCAL";
    public final static String PREF_YEAR = "PREF_YEAR";
    public final static String PREF_MALE = "PREF_MALE";
    public final static String PREF_FEMALE = "PREF_FEMALE";
    public final static String PREF_ALLMARK= "PREF_ALLMARK";
    public final static String PREF_POINTFIVE1 = "PREF_POINTFIVE1";
    public final static String PREF_POINTTHREE1 = "PREF_POINTTHREE1";
    public final static String PREF_NOWMARK= "PREF_NOWMARK";
    public final static String PREF_POINTFIVE2 = "PREF_POINTFIVE2";
    public final static String PREF_POINTTHREE2 = "PREF_POINTTHREE2";
    public final static String PREF_INCOMERANK= "PREF_INCOMERANK";
    public final static String PREF_MERITYES = "PREF_MERITYES";
    public final static String PREF_MERITNO= "PREF_MERITNO";

    static Context mContext;
    public Integer flag=0;

    public SharedPrefKey(Context c) {
        mContext = c;
    }

    public void put(String key, String value) {
        SharedPreferences pref = mContext.getSharedPreferences(PREF_NAME,
                Activity.MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();

        editor.putString(key, value);
        editor.commit();
    }

    public void put(String key, boolean value) {
        SharedPreferences pref = mContext.getSharedPreferences(PREF_NAME,
                Activity.MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();

        editor.putBoolean(key, value);
        editor.commit();
    }

    public void put(String key, int value) {
        SharedPreferences pref = mContext.getSharedPreferences(PREF_NAME,
                Activity.MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();

        editor.putInt(key, value);
        editor.commit();
    }

    public String getValue(String key, String dftValue) {
        SharedPreferences pref = mContext.getSharedPreferences(PREF_NAME,
                Activity.MODE_PRIVATE);

        try {
            String s = pref.getString(key, dftValue);
            System.out.println(s+"This is the Shared Pref String");
            if ( s!= dftValue ) { flag = 1;
                System.out.println("flag is changed in String"); }
            return s;
        } catch (Exception e) {
            return dftValue;
        }

    }

    public int getValue(String key, int dftValue) {
        SharedPreferences pref = mContext.getSharedPreferences(PREF_NAME,
                Activity.MODE_PRIVATE);

        try {
            return pref.getInt(key, dftValue);
        } catch (Exception e) {
            return dftValue;
        }

    }

    public boolean getValue(String key, boolean dftValue) {
        SharedPreferences pref = mContext.getSharedPreferences(PREF_NAME,
                Activity.MODE_PRIVATE);

        try {
            Boolean b = pref.getBoolean(key, dftValue);
            if (b==true) { flag = 1;
                System.out.println("flag is changed in Bool");}
            System.out.println(b.toString()+"This is the Shared Pref Boolean");
            return pref.getBoolean(key, dftValue);
        } catch (Exception e) {
            return dftValue;
        }
    }

}
