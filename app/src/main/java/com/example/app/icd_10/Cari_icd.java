package com.example.app.icd_10;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


public class Cari_icd extends AppCompatActivity implements View.OnClickListener {

    public Button tcari;
    public EditText kode;
    public EditText sub_kategori;
    public static String JSON_URL ;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cari_icd);

        kode = (EditText) findViewById(R.id.kode);
        sub_kategori = (EditText) findViewById(R.id.sub_kategori);
        tcari = (Button) findViewById(R.id.tcari);

        tcari.setOnClickListener(this);

    }

    private void sendRequest(){

        StringRequest stringRequest = new StringRequest(JSON_URL,
                    new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        showJSON(response);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(Cari_icd.this,error.toString(),Toast.LENGTH_LONG).show();
                    }
                });

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);

    }

    public void showJSON(String json){
        String kodeTampil="";
        String catagori="";
        String blockId="";
        String chapterId="";
        String name="";
        String indoName="";

        try {
            JSONObject jsonObject = new JSONObject(json);

            JSONArray result = jsonObject.getJSONArray("result");

            if (result.length() < 1){
                Toast.makeText(Cari_icd.this, "Kode tidak ditemukan", Toast.LENGTH_SHORT).show();
            }

            JSONObject Data = result.getJSONObject(0);

            kodeTampil = Data.getString("Kode");
            catagori = Data.getString("Sub_kategori");
            blockId = Data.getString("Block_id");
            chapterId = Data.getString("Chapter_id");
            name = Data.getString("English_nm");
            indoName = Data.getString("Indo_nm");

            Intent halamanIcd = new Intent(Cari_icd.this, Tampil_ICD.class);


            halamanIcd.putExtra("kodeTampil",kodeTampil);
            halamanIcd.putExtra("catagori", catagori);
            halamanIcd.putExtra("blockId", blockId);
            halamanIcd.putExtra("chapterId", chapterId);
            halamanIcd.putExtra("indoName", indoName);
            halamanIcd.putExtra("engName", name);
            startActivity(halamanIcd);

        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void onClick(View v){

        String getKode = kode.getText().toString();
        String getSubKode = sub_kategori.getText().toString();

        JSON_URL =  "http://192.168.43.69:3000/code/"+getKode+"."+getSubKode;

        Toast.makeText(Cari_icd.this, getKode+getSubKode, Toast.LENGTH_LONG );

        switch (v.getId()){
            case R.id.tcari:
                sendRequest();
                break;
        }
    }
}