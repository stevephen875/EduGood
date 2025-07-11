package com.example.edugood;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MatematikaQuiz1Activity extends AppCompatActivity {

    private TextView tvResult;
    private Button btnA, btnB, btnC;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_matematika_quiz1_kelas1);

        btnA = findViewById(R.id.btn_a);
        btnB = findViewById(R.id.btn_b);
        btnC = findViewById(R.id.btn_c);
        tvResult = findViewById(R.id.tv_result);

        btnA.setOnClickListener(v -> cekJawaban("A"));
        btnB.setOnClickListener(v -> cekJawaban("B"));
        btnC.setOnClickListener(v -> cekJawaban("C"));
    }

    private void cekJawaban(String jawaban) {
        String hasil;
        int warna;

        if (jawaban.equals("B")) {
            hasil = "Benar! 🎉 Jawabannya 2 🍎";
            warna = getResources().getColor(android.R.color.holo_green_dark);
        } else {
            hasil = "Salah 😢 Coba lagi ya!";
            warna = getResources().getColor(android.R.color.holo_red_dark);
        }

        tvResult.setText(hasil);
        tvResult.setTextColor(warna);
        tvResult.setVisibility(View.VISIBLE);
    }
}
