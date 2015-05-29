package com.example.chutbaksa.scholarshipdream;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.chutbaksa.scholarshipdream.JSONparser.Gparser;
import com.example.chutbaksa.scholarshipdream.JSONparser.JanghakObject;




import java.io.InputStream;
import java.util.ArrayList;


public class scinfoall extends Fragment {

    private ListView mListView = null;
    private JanghakInfoAdapter mAdapter = null;
    private String informedUrl;
    ArrayList<JanghakObject> janghakList;
    View view;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.activity_scall, container, false);

        informedUrl = "http://52.68.98.173:8080/JanghakDream/janghak/select/all";
        System.out.println(informedUrl);

        GetJanghakJson gjson = new GetJanghakJson();
        gjson.execute();

        return view;
    }

    private class GetJanghakJson extends AsyncTask<String, String, ArrayList<JanghakObject>> {

        @Override
        protected void onPreExecute() {}

        @Override
        protected ArrayList<JanghakObject> doInBackground(String... arg0) {

            try {
                Gparser jparser = new Gparser();
                InputStream is = jparser
                        .getContentFromUrl(informedUrl);
                janghakList = jparser.getJanghakObjectArray(is);
                return janghakList;

            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(ArrayList<JanghakObject> jarr) {
            mListView = (ListView) view.findViewById(R.id.listView2);
            mAdapter = new JanghakInfoAdapter(view.getContext(), jarr);
            mListView.setAdapter(mAdapter);
            /*
            try {

                for (int i = 0; i < jarr.size(); i++) {

                    mAdapter.addItem(jarr.get(i).getFoundation(), jarr.get(i).getPayamount(), jarr.get(i).getDday());
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
            */

        }


    }
}

