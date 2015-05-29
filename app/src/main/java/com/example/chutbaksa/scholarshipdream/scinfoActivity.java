package com.example.chutbaksa.scholarshipdream;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.internal.widget.AdapterViewCompat;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.GregorianCalendar;


/**
 * Created by chutbaksa on 2015. 5. 21..
 */
public class scinfoActivity extends FragmentActivity implements View.OnClickListener {

    int mCurrentFragmentIndex;
    public final static int FRAGMENT_ONE = 0;
    public final static int FRAGMENT_TWO = 1;

    final String TAG = "ListJanghak";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scinfo);

        ImageView backbtn = (ImageView) findViewById(R.id.btn_back);
        backbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


        ImageView infobtn = (ImageView) findViewById(R.id.btn_info);
        infobtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), myinfoActivity.class);
                startActivity(intent);
            }
        });

        Button bt_oneFragment = (Button) findViewById(R.id.bt_oneFragment);
        bt_oneFragment.setOnClickListener(this);
        Button bt_twoFragment = (Button) findViewById(R.id.bt_twoFragment);
        bt_twoFragment.setOnClickListener(this);

        mCurrentFragmentIndex = FRAGMENT_ONE;

        fragmentReplace(mCurrentFragmentIndex);
    }

    public void fragmentReplace(int reqNewFragmentIndex) {

        Fragment newFragment = null;

        Log.d(TAG, "fragmentReplace " + reqNewFragmentIndex);

        newFragment = getFragment(reqNewFragmentIndex);

        // replace fragment
        final FragmentTransaction transaction = getSupportFragmentManager()
                .beginTransaction();

        transaction.replace(R.id.ll_fragment, newFragment);

        // Commit the transaction
        transaction.commit();

    }

    private Fragment getFragment(int idx) {
        Fragment newFragment = null;

        switch (idx) {
            case FRAGMENT_ONE:
                newFragment = new scinfoall();
                break;
            case FRAGMENT_TWO:
                newFragment = new scinfocustom();
                break;

            default:
                Log.d(TAG, "Unhandle case");
                break;
        }

        return newFragment;
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.bt_oneFragment:
                mCurrentFragmentIndex = FRAGMENT_ONE;
                fragmentReplace(mCurrentFragmentIndex);
                break;
            case R.id.bt_twoFragment:
                mCurrentFragmentIndex = FRAGMENT_TWO;
                fragmentReplace(mCurrentFragmentIndex);
                break;

        }

    }



}



