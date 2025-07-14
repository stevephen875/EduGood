package com.example.edugood;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class Matematika4FinalTesActivity extends AppCompatActivity {

    private TextView tvSoal, tvResult;
    private Button btnA, btnB, btnC, btnNext, btnKembali;

    private int soalIndex = 0;
    private int score = 0;

    private final String[] soalList = {
            "Soal 1: 3 × 2 = ?",
            "Soal 2: 8 ÷ 2 = ?",
            "Soal 3: Nilai angka 3 pada 345 adalah...?"
    };

    private final String[][] pilihan = {
            {"A. 5", "B. 6", "C. 9"},
            {"A. 6", "B. 4", "C. 3"},
            {"A. 300", "B. 30", "C. 3"}
    };

    private final String[] jawabanBenar = {"B", "B", "A"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_matematika4_final_tes);

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
            startActivity(new Intent(this, MatematikaKelas4Activity.class));
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
        int nilai = (int) Math.round((double) score / soalList.length * 100);

        tvSoal.setText("Tes selesai!\nNilai kamu: " + nilai);
        btnA.setVisibility(View.GONE);
        btnB.setVisibility(View.GONE);
        btnC.setVisibility(View.GONE);
        btnNext.setVisibility(View.GONE);
        btnKembali.setVisibility(View.VISIBLE);

        if (nilai >= 90) {
            tvResult.setText("Luar biasa! 💯");
        } else if (nilai >= 60) {
            tvResult.setText("Bagus! 👍");
        } else {
            tvResult.setText("Ayo belajar lagi ✏");
        }

        tvResult.setVisibility(View.VISIBLE);
    }

    private void enableButtons(boolean enable) {
        btnA.setEnabled(enable);
        btnB.setEnabled(enable);
        btnC.setEnabled(enable);
    }
}