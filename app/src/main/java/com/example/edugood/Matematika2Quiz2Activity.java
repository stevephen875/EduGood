package com.example.edugood;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class Matematika2Quiz2Activity extends AppCompatActivity {

    private TextView tvResult;
    private Button btnA, btnB, btnC, btnKembali;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_matematika2_quiz2);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(v -> finish());

        btnA = findViewById(R.id.btn_a);
        btnB = findViewById(R.id.btn_b);
        btnC = findViewById(R.id.btn_c);
        tvResult = findViewById(R.id.tv_result);
        btnKembali = findViewById(R.id.btn_kembali);

        btnA.setOnClickListener(v -> cekJawaban("A"));
        btnB.setOnClickListener(v -> cekJawaban("B"));
        btnC.setOnClickListener(v -> cekJawaban("C"));

        btnKembali.setOnClickListener(v -> {
            Intent intent = new Intent(this, Matematika2Materi2Activity.class);
            startActivity(intent);
            finish();
        });
    }

    private void cekJawaban(String pilihan) {
        String hasil;
        int warna;

        if (pilihan.equals("B")) {
            hasil = "Benar! 🎉 Jawabannya 33 🍬";
            warna = getResources().getColor(android.R.color.holo_green_dark);
            btnKembali.setVisibility(View.VISIBLE);
        } else {
            hasil = "Salah 😢 Coba lagi ya!";
            warna = getResources().getColor(android.R.color.holo_red_dark);
        }

        tvResult.setText(hasil);
        tvResult.setTextColor(warna);
        tvResult.setVisibility(View.VISIBLE);
    }
}
