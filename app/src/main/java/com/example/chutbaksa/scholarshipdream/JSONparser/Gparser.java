package com.example.chutbaksa.scholarshipdream.JSONparser;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.HttpConnectionParams;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by kimeunji on 15. 5. 22..
 */
public class Gparser {

    private HttpClient client;
    static InputStream is = null;
    static JSONObject jObj = null;
    static String json = "";
    ArrayList<JanghakObject> janghakList;

    public InputStream getContentFromUrl(String url) {

        client = new DefaultHttpClient();
        HttpConnectionParams.setConnectionTimeout(client.getParams(), 10000);
        HttpResponse response;

        // make HTTP request
        try {
            HttpGet get = new HttpGet(url);
            response = client.execute(get);
            is = response.getEntity().getContent();

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return is;
    }

    public ArrayList<JanghakObject> getJanghakObjectArray(InputStream is){

        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(is, "utf-8"));
            Type collectionType = new TypeToken<ArrayList<JanghakObject>>() {}.getType();
            janghakList = (ArrayList<JanghakObject>) new Gson().fromJson(reader, collectionType);
        } catch (Exception e){
            e.printStackTrace();
        }
        return janghakList;
    }

}