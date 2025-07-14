package com.example.edugood;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class Indonesia3FinalTestActivity extends AppCompatActivity {

    private TextView tvSoal, tvResult;
    private Button btnA, btnB, btnC, btnNext, btnKembali;

    private int soalIndex = 0;
    private int score = 0;

    private final String[] soalList = {
            "Soal 1: Penulisan huruf kapital yang benar adalah...",
            "Soal 2: Ide pokok paragraf adalah...",
            "Soal 3: Kalimat “Tolong ambilkan buku itu!” termasuk kalimat apa? "
    };

    private final String[][] pilihan = {
            {"A.  ayah pergi ke pasar.", "B.  Ayah Pergi Ke Pasar.", "C. Ayah pergi ke pasar. "},
            {"A. Gagasan utama dalam paragraf", "B. Judul bacaan ", "C. Kata terakhir dalam paragraf"},
            {"A. Pernyataan", "B. Tanya", "C. Perintah"},
    };

    private final String[] jawabanBenar = {"C", "A", "C"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_indonesia3_final_test);

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
            startActivity(new Intent(this, IndonesiaKelas3Activity.class));
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

    private void enableButtons(boolean status) {
        btnA.setEnabled(status);
        btnB.setEnabled(status);
        btnC.setEnabled(status);
    }

    private void showHasilAkhir() {
        int nilaiPersen = (int) Math.round((double) score / soalList.length * 100);

        tvSoal.setText("Tes selesai!\nNilai kamu: " + nilaiPersen);
        btnA.setVisibility(View.GONE);
        btnB.setVisibility(View.GONE);
        btnC.setVisibility(View.GONE);
        btnNext.setVisibility(View.GONE);
        btnKembali.setVisibility(View.VISIBLE);

        if (nilaiPersen >= 99) {
            tvResult.setText("Luar biasa! 💯");
        } else if (nilaiPersen >= 66) {
            tvResult.setText("Bagus! 👍");
        } else {
            tvResult.setText("Ayo belajar lagi! ✏️");
        }

        tvResult.setVisibility(View.VISIBLE);
    }

}
