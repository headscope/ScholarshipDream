package com.example.chutbaksa.scholarshipdream;


import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;


/**
 * Created by chutbaksa on 2015. 5. 21..
 */
public class myinfoActivity extends MainActivity {

    EditText etSchool;
    Spinner spinnerLocal;
    Spinner spinnerYear;
    RadioButton radioMale;
    RadioButton radioFemale;
    EditText etMyAllMark;
    RadioButton radio4_5_1;
    RadioButton radio4_3_1;
    EditText etNowMark;
    RadioButton radio4_5_2;
    RadioButton radio4_3_2;
    Spinner spinnerIncome;
    RadioButton radioYes;
    RadioButton radioNo;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_myinfo);

        ImageView backbtn = (ImageView) findViewById(R.id.btn_back);
        backbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        etSchool = (EditText) findViewById(R.id.et_school);
        spinnerYear = (Spinner) findViewById(R.id.spinner_year);
        ArrayAdapter yearAdapter = ArrayAdapter.createFromResource(
                this, R.array.year, android.R.layout.simple_spinner_item);
        yearAdapter.setDropDownViewResource(
                android.R.layout.simple_spinner_dropdown_item);
        spinnerYear.setAdapter(yearAdapter);
        spinnerLocal = (Spinner) findViewById(R.id.spinner_local);
        ArrayAdapter localAdapter = ArrayAdapter.createFromResource(
                this, R.array.local, android.R.layout.simple_spinner_item);
        yearAdapter.setDropDownViewResource(
                android.R.layout.simple_spinner_dropdown_item);
        spinnerLocal.setAdapter(localAdapter);
        radioMale = (RadioButton) findViewById(R.id.radio_male);
        radioFemale = (RadioButton) findViewById(R.id.radio_female);
        etMyAllMark = (EditText) findViewById(R.id.et_myAllMark);
        radio4_5_1 = (RadioButton) findViewById(R.id.radio_4_5_1);
        radio4_3_1 = (RadioButton) findViewById(R.id.radio_4_3_1);
        etNowMark = (EditText) findViewById(R.id.et_myNowMark);
        radio4_5_2 = (RadioButton) findViewById(R.id.radio_4_5_2);
        radio4_3_2 = (RadioButton) findViewById(R.id.radio_4_3_2);
        spinnerIncome = (Spinner) findViewById(R.id.spinner_income);
        ArrayAdapter incomeAdapter = ArrayAdapter.createFromResource(
                this, R.array.income, android.R.layout.simple_spinner_item);
        yearAdapter.setDropDownViewResource(
                android.R.layout.simple_spinner_dropdown_item);
        spinnerIncome.setAdapter(incomeAdapter);
        radioYes = (RadioButton) findViewById(R.id.radio_yes);
        radioNo = (RadioButton) findViewById(R.id.radio_no);

        this.GetPreference();

    }

    public void GetPreference() {
        SharedPrefKey pref = new SharedPrefKey(this);
        etSchool.setText(pref.getValue(pref.PREF_SCHOOL, ""));
        spinnerLocal.setSelection(pref.getValue(pref.PREF_LOCAL, 0));
        spinnerYear.setSelection(pref.getValue(pref.PREF_YEAR, 0));
        radioMale.setChecked(pref.getValue(pref.PREF_MALE, false));
        radioFemale.setChecked(pref.getValue(pref.PREF_FEMALE, false));
        etMyAllMark.setText(pref.getValue(pref.PREF_ALLMARK, ""));
        radio4_5_1.setChecked(pref.getValue(pref.PREF_POINTFIVE1, false));
        radio4_3_1.setChecked(pref.getValue(pref.PREF_POINTTHREE1, false));
        etNowMark.setText(pref.getValue(pref.PREF_NOWMARK, ""));
        radio4_5_2.setChecked(pref.getValue(pref.PREF_POINTFIVE2, false));
        radio4_3_2.setChecked(pref.getValue(pref.PREF_POINTTHREE2, false));
        spinnerIncome.setSelection(pref.getValue(pref.PREF_YEAR, 0));
        radioYes.setChecked(pref.getValue(pref.PREF_MERITYES, false));
        radioNo.setChecked(pref.getValue(pref.PREF_MERITNO, false));
        Log.d("onGet", "GetPref is working");

    }

    public void SavePreference(){
        SharedPrefKey pref = new SharedPrefKey(this);
        pref.put(pref.PREF_SCHOOL, etSchool.getText().toString());
        pref.put(pref.PREF_LOCAL, spinnerLocal.getSelectedItemPosition());
        pref.put(pref.PREF_YEAR, spinnerYear.getSelectedItemPosition());
        pref.put(pref.PREF_MALE, radioMale.isChecked());
        pref.put(pref.PREF_FEMALE, radioFemale.isChecked());
        pref.put(pref.PREF_ALLMARK, etMyAllMark.getText().toString());
        pref.put(pref.PREF_POINTFIVE1, radio4_5_1.isChecked());
        pref.put(pref.PREF_POINTTHREE1, radio4_3_1.isChecked());
        pref.put(pref.PREF_NOWMARK, etNowMark.getText().toString());
        pref.put(pref.PREF_POINTFIVE2, radio4_5_2.isChecked());
        pref.put(pref.PREF_POINTTHREE2, radio4_3_2.isChecked());
        pref.put(pref.PREF_INCOMERANK, spinnerIncome.getSelectedItemPosition());
        pref.put(pref.PREF_MERITYES, radioYes.isChecked());
        pref.put(pref.PREF_MERITNO, radioNo.isChecked());
        Log.d("onSave", "SavingPref is working");
    }

    public void submit(View v){
        try {
            int ID = v.getId();
            if (R.id.btn_submit == ID){
                this.SavePreference();
            }
            if (R.id.btn_reset == ID){
                //editable
            }
            Toast.makeText(this, "저장되었습니다", Toast.LENGTH_SHORT).show();
        } catch (Exception e){
            Toast.makeText(this, "실패하였습니다", Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    protected void onStop() {
        super.onStop();
        this.SavePreference();
        Log.d("onStop", "Save before stop");
    }



}
