package com.example.edugood;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class Matematika4Quiz2Activity extends AppCompatActivity {

    private TextView tvSoal, tvResult;
    private Button btnA, btnB, btnC, btnKembali;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_matematika4_quiz2);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null)
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(v -> finish());

        tvSoal = findViewById(R.id.tv_soal);
        tvResult = findViewById(R.id.tv_result);
        btnA = findViewById(R.id.btn_a);
        btnB = findViewById(R.id.btn_b);
        btnC = findViewById(R.id.btn_c);
        btnKembali = findViewById(R.id.btn_kembali);

        tvSoal.setText("Soal: 6 ÷ 2 = ?");

        btnA.setText("A. 2");
        btnB.setText("B. 3");
        btnC.setText("C. 4");

        btnA.setOnClickListener(v -> cekJawaban("A"));
        btnB.setOnClickListener(v -> cekJawaban("B"));
        btnC.setOnClickListener(v -> cekJawaban("C"));

        btnKembali.setOnClickListener(v -> {
            startActivity(new Intent(this, MatematikaKelas4Activity.class));
            finish();
        });
    }

    private void cekJawaban(String pilihan) {
        boolean benar = pilihan.equals("B");

        tvResult.setText(benar ? "Benar! 🎉" : "Salah 😢");
        tvResult.setTextColor(getResources().getColor(
                benar ? android.R.color.holo_green_dark : android.R.color.holo_red_dark
        ));

        tvResult.setVisibility(View.VISIBLE);
        btnKembali.setVisibility(View.VISIBLE);
        btnA.setEnabled(false);
        btnB.setEnabled(false);
        btnC.setEnabled(false);
    }
}