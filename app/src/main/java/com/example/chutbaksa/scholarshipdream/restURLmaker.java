package com.example.chutbaksa.scholarshipdream;

import android.content.Context;

/**
 * Created by chutbaksa on 2015. 5. 26..
 */
public class restURLmaker {

    String serverUrl = "http://52.68.98.173:8080/JanghakDream/janghak/select/";
    String informedUrl;
    Integer flags;
    public String makeUrl(Context ct){

        SharedPrefKey pref = new SharedPrefKey(ct);
        System.out.println(pref.flag.toString()+"Before Pref method is working");
        String school = pref.getValue(pref.PREF_SCHOOL, "");
        Integer local = pref.getValue(pref.PREF_LOCAL, 0);
        Integer year = pref.getValue(pref.PREF_YEAR, 0);
        Boolean male = pref.getValue(pref.PREF_MALE, false);
        Boolean female = pref.getValue(pref.PREF_FEMALE, false);
        String grade1 = pref.getValue(pref.PREF_ALLMARK, "");
        Boolean pfive1 = pref.getValue(pref.PREF_POINTFIVE1, false);
        Boolean pthree1 = pref.getValue(pref.PREF_POINTTHREE1, false);
        String grade2 = pref.getValue(pref.PREF_NOWMARK, "");
        Boolean pfive2 = pref.getValue(pref.PREF_POINTFIVE2, false);
        Boolean pthree2 = pref.getValue(pref.PREF_POINTTHREE2, false);
        Integer incomerank = pref.getValue(pref.PREF_INCOMERANK, 0);
        Boolean merityes = pref.getValue(pref.PREF_MERITYES, false);
        Boolean meritno = pref.getValue(pref.PREF_MERITNO, false);
        System.out.println(pref.flag.toString()+"After Pref method is working");

        if (pref.flag == 1){

            informedUrl = serverUrl + "school/"+handleString(school);
            informedUrl += "/year/"+year.toString();
            informedUrl += "/local/"+local.toString();
            informedUrl += "/sex/"+handleBoolean(male,female).toString();
            informedUrl += "/allmark/"+handleString(grade1);
            informedUrl += "/scoretype1/"+handleBoolean(pfive1, pthree1).toString();
            informedUrl += "/nowmark/"+handleString(grade2);
            informedUrl += "/scoretype2/"+handleBoolean(pfive2, pthree2).toString();
            informedUrl += "/incomerank/"+ incomerank.toString();
            informedUrl += "/meritman/"+handleBoolean(merityes, meritno).toString();
        }
        else { informedUrl = serverUrl + "all"; }

        return informedUrl;
    }

    public String handleString(String st){
        if ( st==""){
            st = "inputNone";
        }
        return st;
    }
    public Integer handleBoolean(Boolean m, Boolean f){
        // followed by the ISO Rule
        // According to sex type, not known = 0, male = 1, female =2
        // For Other types, both false = 0 , first one true = 1, second one true = 2
        if ( m == false && f == false ){ return 0; }
        else if (m == true) { return 1; }
        else { return 2; }
    }
}
