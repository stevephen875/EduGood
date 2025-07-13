package com.example.edugood;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class IndonesiaKelas2Activity extends AppCompatActivity {

    private Button btnMateri1, btnMateri2, btnMateri3, btnFinalTest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_indonesia_kelas2);

        btnMateri1 = findViewById(R.id.btn_materi1);
        btnMateri2 = findViewById(R.id.btn_materi2);
        btnMateri3 = findViewById(R.id.btn_materi3);
        btnFinalTest = findViewById(R.id.btn_final_test);

        btnMateri1.setOnClickListener(v -> {
            Intent intent = new Intent(IndonesiaKelas2Activity.this, Indonesia2Materi1Activity.class);
            startActivity(intent);
        });

        btnMateri2.setOnClickListener(v -> {
            Intent intent = new Intent(IndonesiaKelas2Activity.this, Indonesia2Materi2Activity.class);
            startActivity(intent);
        });

        btnMateri3.setOnClickListener(v -> {
            Intent intent = new Intent(IndonesiaKelas2Activity.this, Indonesia2Materi3Activity.class);
            startActivity(intent);
        });

        btnFinalTest.setOnClickListener(v -> {
            Intent intent = new Intent(IndonesiaKelas2Activity.this, Indonesia2FinalTestActivity.class);
            startActivity(intent);
        });
    }
}
