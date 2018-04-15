package com.example.app.icd_10;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ProgressBar;

public class Splash_screen extends AppCompatActivity {

    ProgressBar progressBar;
    int status = 0;
    int proses = 0;
    Handler handle = new Handler();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        progressBar = (ProgressBar) findViewById(R.id.tunggu);
        new Thread(new Runnable() {
            @Override
            public void run() {
                while(status<100){
                    status = loading();
                    handle.post(new Runnable() {
                        @Override
                        public void run() {
                            progressBar.setProgress(status);

                        }
                    });
                }
                handle.post(new Runnable() {
                    @Override
                    public void run() {
                        Intent pindah = new Intent(Splash_screen.this,Home.class);
                        startActivity(pindah);
                        finish();
                    }
                });
            }

            private int loading() {
                try{
                    Thread.sleep(30);
                }
                catch(InterruptedException ie){
                    ie.printStackTrace();
                }
                return ++proses;
            }
        }).start();
    }
}