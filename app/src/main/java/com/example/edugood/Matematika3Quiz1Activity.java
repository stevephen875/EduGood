package com.example.edugood;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class Matematika3Quiz1Activity extends AppCompatActivity {

    private TextView tvSoal, tvResult;
    private Button btnA, btnB, btnC, btnNext, btnKembali;

    private int soalIndex = 0;
    private int score = 0;

    private final String[] soalList = {
            "Soal 1: 100 + 200 = ?",
            "Soal 2: 150 + 150 = ?",
            "Soal 3: 300 + 100 = ?"
    };

    private final String[][] pilihan = {
            {"A. 200", "B. 300", "C. 400"},
            {"A. 250", "B. 300", "C. 350"},
            {"A. 400", "B. 350", "C. 450"}
    };

    private final String[] jawabanBenar = {"B", "B", "A"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_matematika3_quiz1);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(v -> finish());

        tvSoal = findViewById(R.id.tv_soal);
        tvResult = findViewById(R.id.tv_result);
        btnA = findViewById(R.id.btn_a);
        btnB = findViewById(R.id.btn_b);
        btnC = findViewById(R.id.btn_c);
        btnNext = findViewById(R.id.btn_next);
        btnKembali = findViewById(R.id.btn_kembali);

        setSoal();

        btnA.setOnClickListener(v -> cekJawaban("A"));
        btnB.setOnClickListener(v -> cekJawaban("B"));
        btnC.setOnClickListener(v -> cekJawaban("C"));

        btnNext.setOnClickListener(v -> {
            soalIndex++;
            if (soalIndex < soalList.length) {
                setSoal();
            } else {
                showHasilAkhir();
            }
        });

        btnKembali.setOnClickListener(v -> {
            startActivity(new Intent(this, MatematikaKelas3Activity.class));
            finish();
        });
    }

    private void setSoal() {
        tvSoal.setText(soalList[soalIndex]);
        btnA.setText(pilihan[soalIndex][0]);
        btnB.setText(pilihan[soalIndex][1]);
        btnC.setText(pilihan[soalIndex][2]);
        tvResult.setVisibility(View.GONE);
        btnNext.setVisibility(View.GONE);
        btnKembali.setVisibility(View.GONE);
        enableButtons(true);
    }

    private void cekJawaban(String pilihan) {
        String hasil;
        int warna;

        if (pilihan.equals(jawabanBenar[soalIndex])) {
            hasil = "Benar! 🎉";
            warna = getResources().getColor(android.R.color.holo_green_dark);
            score++;
        } else {
            hasil = "Salah 😢";
            warna = getResources().getColor(android.R.color.holo_red_dark);
        }

        tvResult.setText(hasil);
        tvResult.setTextColor(warna);
        tvResult.setVisibility(View.VISIBLE);
        btnNext.setVisibility(View.VISIBLE);
        enableButtons(false);
    }

    private void showHasilAkhir() {
        int nilai = (int) ((score / (float) soalList.length) * 100);
        tvSoal.setText("Quiz selesai!\nNilai kamu: " + nilai);
        tvResult.setText(nilai >= 80 ? "Bagus sekali! 👏" : "Yuk belajar lagi ya!");
        tvResult.setTextColor(getResources().getColor(android.R.color.holo_blue_dark));
        tvResult.setVisibility(View.VISIBLE);

        btnA.setVisibility(View.GONE);
        btnB.setVisibility(View.GONE);
        btnC.setVisibility(View.GONE);
        btnNext.setVisibility(View.GONE);
        btnKembali.setVisibility(View.VISIBLE);
    }

    private void enableButtons(boolean status) {
        btnA.setEnabled(status);
        btnB.setEnabled(status);
        btnC.setEnabled(status);
    }
}