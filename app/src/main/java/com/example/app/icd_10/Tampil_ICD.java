package com.example.app.icd_10;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Tampil_ICD extends AppCompatActivity {
//    EditText kategori,blockid,chapter,english,indo;
    TextView code,kategori,blockid,chapter,english,indo;

    public String kodeTampil;
    public String catagori;
    public String blockId;
    public String chapterId;
    public String name;
    public String indoName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tampil__icd);

        kodeTampil = this.getIntent().getExtras().getString("kodeTampil");
        catagori = this.getIntent().getExtras().getString("catagori");
        blockId = this.getIntent().getExtras().getString("blockId");
        chapterId = this.getIntent().getExtras().getString("chapterId");
        indoName = this.getIntent().getExtras().getString("indoName");
        name = this.getIntent().getExtras().getString("engName");

        code = (TextView) findViewById(R.id.kodeicd);
        kategori = (TextView) findViewById(R.id.kategori);
        blockid = (TextView) findViewById(R.id.blockid);
        chapter = (TextView) findViewById(R.id.chapter);
        english = (TextView) findViewById(R.id.english);
        indo = (TextView) findViewById(R.id.indo);

        code.setText(kodeTampil);
        kategori.setText(catagori);
        blockid.setText(blockId);
        chapter.setText(chapterId);
        english.setText(name);
        indo.setText(indoName);

    }
}
