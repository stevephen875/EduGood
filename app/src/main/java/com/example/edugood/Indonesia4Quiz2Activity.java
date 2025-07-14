package com.example.edugood;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class Indonesia4Quiz2Activity extends AppCompatActivity {

    private TextView tvResult;
    private Button btnA, btnB, btnC, btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_indonesia4_quiz2);

        btnA = findViewById(R.id.btn_a);
        btnB = findViewById(R.id.btn_b);
        btnC = findViewById(R.id.btn_c);
        btnBack = findViewById(R.id.btn_back);
        tvResult = findViewById(R.id.tv_result);

        btnA.setOnClickListener(v -> cekJawaban("A"));
        btnB.setOnClickListener(v -> cekJawaban("B"));
        btnC.setOnClickListener(v -> cekJawaban("C"));

        btnBack.setOnClickListener(v -> {
            Intent intent = new Intent(this, IndonesiaKelas4Activity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
            startActivity(intent);
            finish();
        });
    }

    private void cekJawaban(String jawaban) {
        String hasil;
        int warna;

        if ("A".equals(jawaban)) {
            hasil = "Benar! 🎉 Jawabannya adalah Adik saya pergi ke sekolah naik sepeda setiap pagi. ";
            warna = getResources().getColor(android.R.color.holo_green_dark);

            btnBack.setVisibility(View.VISIBLE);
        } else {
            hasil = "Salah 😢 Coba lagi ya!";
            warna = getResources().getColor(android.R.color.holo_red_dark);
        }

        tvResult.setText(hasil);
        tvResult.setTextColor(warna);
        tvResult.setVisibility(View.VISIBLE);
    }
}
