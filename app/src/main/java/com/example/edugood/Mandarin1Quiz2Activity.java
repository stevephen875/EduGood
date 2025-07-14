package com.example.edugood;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class Mandarin1Quiz2Activity extends AppCompatActivity {

    private TextView tvSoal, tvResult;
    private Button btnA, btnB, btnC, btnKembali;

    private boolean sudahJawab = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mandarin1_quiz2);

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

        tvSoal.setText("Apa arti dari 妈妈 (Māma) dalam Bahasa Indonesia?");

        btnA.setText("A. Ayah");
        btnB.setText("B. Ibu");
        btnC.setText("C. Kakak");

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

        if (pilihan.equals("B")) {
            tvResult.setText("Benar! 🎉 妈妈 artinya Ibu.");
            tvResult.setTextColor(getResources().getColor(android.R.color.holo_green_dark));
        } else {
            tvResult.setText("Salah 😢 Jawaban yang benar adalah B. Ibu");
            tvResult.setTextColor(getResources().getColor(android.R.color.holo_red_dark));
        }

        btnA.setEnabled(false);
        btnB.setEnabled(false);
        btnC.setEnabled(false);
    }
}