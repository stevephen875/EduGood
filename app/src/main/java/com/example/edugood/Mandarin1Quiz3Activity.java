package com.example.edugood;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class Mandarin1Quiz3Activity extends AppCompatActivity {

    private TextView tvSoal, tvResult;
    private Button btnA, btnB, btnC, btnKembali;

    private boolean sudahJawab = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mandarin1_quiz3);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            toolbar.setNavigationOnClickListener(v -> finish());
        }

        tvSoal = findViewById(R.id.tv_soal);
        tvResult = findViewById(R.id.tv_result);
        btnA = findViewById(R.id.btn_a);
        btnB = findViewById(R.id.btn_b);
        btnC = findViewById(R.id.btn_c);
        btnKembali = findViewById(R.id.btn_kembali);

        tvSoal.setText("哥哥 pinyin nya adalah = ?");

        btnA.setText("A. Gēge");
        btnB.setText("B. Mèimei");
        btnC.setText("C. Dìdi");

        btnA.setOnClickListener(v -> cekJawaban("A"));
        btnB.setOnClickListener(v -> cekJawaban("B"));
        btnC.setOnClickListener(v -> cekJawaban("C"));

        btnKembali.setOnClickListener(v -> {
            startActivity(new Intent(this, MandarinKelas1Activity.class));
            finish();
        });
    }

    private void cekJawaban(String pilihan) {
        if (sudahJawab) return;

        sudahJawab = true;
        tvResult.setVisibility(View.VISIBLE);
        btnKembali.setVisibility(View.VISIBLE);

        if (pilihan.equals("A")) {
            tvResult.setText("正确！答案是 A 🎉");
            tvResult.setTextColor(getResources().getColor(android.R.color.holo_green_dark));
        } else {
            tvResult.setText("❌ 错误，请再试一次！");
            tvResult.setTextColor(getResources().getColor(android.R.color.holo_red_dark));
        }

        btnA.setEnabled(false);
        btnB.setEnabled(false);
        btnC.setEnabled(false);
    }
}