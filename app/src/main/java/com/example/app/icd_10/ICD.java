package com.example.app.icd_10;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

public class ICD extends AppCompatActivity implements View.OnClickListener {

    Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_icd);
        Button tombolicd = (Button) findViewById(R.id.materiicd);
        tombolicd.setOnClickListener(this);

        spinner = (Spinner) findViewById(R.id.showschapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){


            //fungsi spinnernya jika di klik
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int i, long l) {

                if (i == 1) {
                    TextView muncul = (TextView) findViewById(R.id.muncultext);
                    muncul.setText(R.string.chap1);}

                if (i == 2) {
                    TextView muncul = (TextView) findViewById(R.id.muncultext);
                    muncul.setText(R.string.chap2);}

                if (i == 3) {
                    TextView muncul = (TextView) findViewById(R.id.muncultext);
                    muncul.setText(R.string.chap3);}

                if (i == 4) {
                    TextView muncul = (TextView) findViewById(R.id.muncultext);
                    muncul.setText(R.string.chap4);}

                if (i == 5) {
                    TextView muncul = (TextView) findViewById(R.id.muncultext);
                    muncul.setText(R.string.chap5);}

                if (i == 6) {
                    TextView muncul = (TextView) findViewById(R.id.muncultext);
                    muncul.setText(R.string.chap6);}

                if (i == 7) {
                    TextView muncul = (TextView) findViewById(R.id.muncultext);
                    muncul.setText(R.string.chap7);}

                if (i == 8) {
                    TextView muncul = (TextView) findViewById(R.id.muncultext);
                    muncul.setText(R.string.chap8);}

                if (i == 9) {
                    TextView muncul = (TextView) findViewById(R.id.muncultext);
                    muncul.setText(R.string.chap9);}

                if (i == 10) {
                    TextView muncul = (TextView) findViewById(R.id.muncultext);
                    muncul.setText(R.string.chap10);}

                if (i == 11) {
                    TextView muncul = (TextView) findViewById(R.id.muncultext);
                    muncul.setText(R.string.chap11);}

                if (i == 12) {
                    TextView muncul = (TextView) findViewById(R.id.muncultext);
                    muncul.setText(R.string.chap12);}

                if (i == 13) {
                    TextView muncul = (TextView) findViewById(R.id.muncultext);
                    muncul.setText(R.string.chap13);}

                if (i == 14) {
                    TextView muncul = (TextView) findViewById(R.id.muncultext);
                    muncul.setText(R.string.chap14);}

                if (i == 15) {
                    TextView muncul = (TextView) findViewById(R.id.muncultext);
                    muncul.setText(R.string.chap15);}

                if (i == 16) {
                    TextView muncul = (TextView) findViewById(R.id.muncultext);
                    muncul.setText(R.string.chap16);}

                if (i == 17) {
                    TextView muncul = (TextView) findViewById(R.id.muncultext);
                    muncul.setText(R.string.chap17);}

                if (i == 18) {
                    TextView muncul = (TextView) findViewById(R.id.muncultext);
                    muncul.setText(R.string.chap18);}

                if (i == 19) {
                    TextView muncul = (TextView) findViewById(R.id.muncultext);
                    muncul.setText(R.string.chap19);}

                if (i == 20) {
                    TextView muncul = (TextView) findViewById(R.id.muncultext);
                    muncul.setText(R.string.chap20);}

                if (i == 21) {
                    TextView muncul = (TextView) findViewById(R.id.muncultext);
                    muncul.setText(R.string.chap21);}

                if (i == 22) {
                    TextView muncul = (TextView) findViewById(R.id.muncultext);
                    muncul.setText(R.string.chap22);}

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }

        });
    }

    //fungsi tombol icd
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.materiicd:
                TextView muncul = (TextView) findViewById(R.id.muncultext);
                muncul.setText(R.string.icd_about);
                break;
            case R.id.showschapter:
        }
    }
}
