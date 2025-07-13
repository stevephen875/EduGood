package com.example.edugood;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class Matematika2FinalTestActivity extends AppCompatActivity {

    private Button btnCek, btnKembali;
    private TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_matematika2_final_test);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null)
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        toolbar.setNavigationOnClickListener(v -> finish());

        btnCek = findViewById(R.id.btn_cek);
        btnKembali = findViewById(R.id.btn_kembali);
        tvResult = findViewById(R.id.tv_result);

        btnCek.setOnClickListener(v -> periksaJawaban());

        btnKembali.setOnClickListener(v -> {
            Intent intent = new Intent(this, MatematikaKelas2Activity.class);
            startActivity(intent);
            finish();
        });
    }

    private void periksaJawaban() {
        RadioButton s1 = findViewById(R.id.s1_a);
        RadioButton s2 = findViewById(R.id.s2_b);
        RadioButton s3 = findViewById(R.id.s3_b);

        if (s1.isChecked() && s2.isChecked() && s3.isChecked()) {
            tvResult.setText("Selamat! Semua jawaban benar 🎉");
            tvResult.setTextColor(getResources().getColor(android.R.color.holo_green_dark));
            btnKembali.setVisibility(View.VISIBLE);
        } else {
            tvResult.setText("Ada jawaban yang belum tepat. Yuk coba lagi!");
            tvResult.setTextColor(getResources().getColor(android.R.color.holo_red_dark));
        }
        tvResult.setVisibility(View.VISIBLE);
    }
}
