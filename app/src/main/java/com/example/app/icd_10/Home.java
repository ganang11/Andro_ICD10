package com.example.app.icd_10;

import android.content.Intent;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class Home extends AppCompatActivity implements  View.OnClickListener {
    boolean doubleBackToExitPressedOnce = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ImageView tombolma = (ImageView) findViewById(R.id.t_materi);
        ImageView tombolicd = (ImageView) findViewById(R.id.t_kodeicd);
        ImageView tombolhelp = (ImageView) findViewById(R.id.tombolabout);

        tombolma.setOnClickListener(this);
        tombolicd.setOnClickListener(this);
        tombolhelp.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.t_materi:
                Intent move = new Intent(this, ICD.class);
                startActivity(move);
                break;

            case R.id.t_kodeicd:
                Intent moveicd = new Intent(this, Cari_icd.class);
                startActivity(moveicd);
                break;

            case R.id.tombolabout:
                Intent movehelp = new Intent(this, Help.class);
                startActivity(movehelp);
                break;}
    }

    @Override
    public void onBackPressed(){
        if (doubleBackToExitPressedOnce){
            super.onBackPressed();
            return;
        }
        this.doubleBackToExitPressedOnce = true;
        Toast.makeText(this,"Tekan tombol kembali lagi untuk keluar",Toast.LENGTH_SHORT).show();
        new Handler().postDelayed(new Runnable(){
            @Override
            public void run(){
                doubleBackToExitPressedOnce = false;
            }
        },2000);
    }
}
