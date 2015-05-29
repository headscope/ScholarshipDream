package com.example.chutbaksa.scholarshipdream;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Environment;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import com.example.chutbaksa.scholarshipdream.JSONparser.Gparser;
import com.example.chutbaksa.scholarshipdream.JSONparser.JanghakObject;

import org.w3c.dom.Text;

import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;


public class DetailJanghak extends Activity {

    TextView tv_janghakname;
    TextView tv_daterange;
    TextView tv_weblink;
    TextView click_download;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_janghak);

        tv_janghakname = (TextView) findViewById(R.id.tv_janghakname);
        tv_daterange = (TextView) findViewById(R.id.tv_daterange);
        tv_weblink = (TextView) findViewById(R.id.tv_weblink);
        click_download = (TextView) findViewById(R.id.click_download);


        String janghakname = getIntent().getStringExtra("janghakname");
        String weblink = getIntent().getStringExtra("weblink");
        final String downloadlink = getIntent().getStringExtra("downloadlink");
        String startdate = getIntent().getStringExtra("startdate");
        String enddate = getIntent().getStringExtra("enddate");

        tv_janghakname.setText(janghakname);
        tv_daterange.setText(startdate + "  ~  " + enddate);
        tv_weblink.setText(weblink);


        if (downloadlink.length() == 0) {

            click_download.setVisibility(click_download.GONE);
            System.out.println("To verify the function");
        }
        click_download.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                new DetailInfo().execute(downloadlink);

            }
        });

    }

    private class DetailInfo extends AsyncTask<String, String, String> {


        /**
         * Before starting background thread Show Progress Bar Dialog
         */
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        /**
         * Downloading file in background thread
         */
        @Override
        protected String doInBackground(String... downloadlink) {
            int count;
            try {
                URL url = new URL(downloadlink[0]);
                URLConnection conection = url.openConnection();
                conection.connect();

                // this will be useful so that you can show a tipical 0-100%
                // progress bar
                int lenghtOfFile = conection.getContentLength();

                // download the file
                InputStream input = new BufferedInputStream(url.openStream(),
                        8192);

                // Output stream
                OutputStream output = new FileOutputStream(Environment
                        .getExternalStorageDirectory().toString());
                byte data[] = new byte[1024];

                long total = 0;

                while ((count = input.read(data)) != -1) {
                    total += count;
                    // publishing the progress....
                    // After this onProgressUpdate will be called
                    publishProgress("" + (int) ((total * 100) / lenghtOfFile));

                    // writing data to file
                    output.write(data, 0, count);
                }

                // flushing output
                output.flush();

                // closing streams
                output.close();
                input.close();

            } catch (Exception e) {
                Log.e("Error: ", e.getMessage());
            }

            return null;
        }

        /**
         * Updating progress bar
         */
        protected void onProgressUpdate(String... progress) {
            // setting progress percentage
            // pDialog.setProgress(Integer.parseInt(progress[0]));
            // we don't use progress bar
        }

        /**
         * After completing background task Dismiss the progress dialog
         * *
         */
        @Override
        protected void onPostExecute(String file_url) {
            // dismiss the dialog after the file was downloaded
            // dismissDialog(progress_bar_type);
            // we don't use progress bar

        }

    }
}