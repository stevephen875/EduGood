package com.example.edugood;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class MatematikaKelas4Activity extends AppCompatActivity {

    private Button btnMateri1, btnMateri2, btnMateri3, btnFinalTest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_matematika_kelas4);

        btnMateri1 = findViewById(R.id.btn_materi1);
        btnMateri2 = findViewById(R.id.btn_materi2);
        btnMateri3 = findViewById(R.id.btn_materi3);
        btnFinalTest = findViewById(R.id.btn_final_test);

        btnMateri1.setOnClickListener(v -> {
            startActivity(new Intent(this, Matematika4Materi1Activity.class));
        });

        btnMateri2.setOnClickListener(v -> {
            startActivity(new Intent(this, Matematika4Materi2Activity.class));
        });

        btnMateri3.setOnClickListener(v -> {
            startActivity(new Intent(this, Matematika4Materi3Activity.class));
        });

        btnFinalTest.setOnClickListener(v -> {
            startActivity(new Intent(this, Matematika4FinalTesActivity.class));
        });
    }
}