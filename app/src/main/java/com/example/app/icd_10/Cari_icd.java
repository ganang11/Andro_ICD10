package com.example.app.icd_10;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;


public class Cari_icd extends AppCompatActivity {

    public Button tcari;
    public EditText kode;
    public EditText sub_kategori;
    public TextView KodeIcd,SubKategori,BlockID,ChapterID,EnglishNM,IndoNM;
    public static String Index_kode,subKategori ;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cari_icd);

        kode =  findViewById(R.id.kode);
        tcari = findViewById(R.id.tcari);
        KodeIcd = findViewById(R.id.tv_KodeIcd);
        SubKategori = findViewById(R.id.tv_SubKategori);
        BlockID = findViewById(R.id.tv_BlockId);
        ChapterID = findViewById(R.id.tv_ChapterID);
        EnglishNM = findViewById(R.id.tv_EnglishName);
        IndoNM = findViewById(R.id.tv_IndonesiaName);



        tcari.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Index_kode = kode.getText().toString();

                getSqlDetails();
            }
        });

    }

    private void getSqlDetails() {
        String encodedUrl = null;
        try {
            encodedUrl = URLEncoder.encode(Index_kode, "utf-8");
            String url= Server.URL + "getlist.php?Index_kode="+encodedUrl;
            Log.v("coba2",url);
            StringRequest stringRequest = new StringRequest(Request.Method.GET,
                    url,
                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            try {
                                Log.v("cobaan", response);

                                JSONArray jsonarray = new JSONArray(response);


                                for(int i=0; i < jsonarray.length(); i++) {

                                    JSONObject jsonobject = jsonarray.getJSONObject(i);


                                    String kodeICD = jsonobject.getString("Kode").trim();
                                    String Sub_Kategori = jsonobject.getString("Sub_kategori").trim();
                                    String Block_id = jsonobject.getString("Block_id").trim();
                                    String Chapter_id = jsonobject.getString("Chapter_id").trim();
                                    String English_name = jsonobject.getString("English_nm").trim();
                                    String Indonesia_name = jsonobject.getString("Indo_nm").trim();

                                    KodeIcd.setText(kodeICD);
                                    SubKategori.setText(Sub_Kategori);
                                    BlockID.setText(Block_id);
                                    ChapterID.setText(Chapter_id);
                                    EnglishNM.setText(English_name);
                                    IndoNM.setText(Indonesia_name);

                                }
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                    },
                    new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            if(error != null){
                                Toast.makeText(getApplicationContext(), "Something went wrong.", Toast.LENGTH_LONG).show();
                            }
                        }
                    }
            );

            MySingleton.getInstance(getApplicationContext()).addToRequestQueue(stringRequest);

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }}

    }