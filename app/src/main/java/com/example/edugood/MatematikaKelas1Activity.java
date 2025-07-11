package com.example.edugood;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class MatematikaKelas1Activity extends AppCompatActivity {

    private Button btnMateri1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_matematika_kelas1);

        btnMateri1 = findViewById(R.id.btn_materi1);

        btnMateri1.setOnClickListener(v -> {
            Intent intent = new Intent(MatematikaKelas1Activity.this, MatematikaKelas1Activity.class);
            startActivity(intent);
        });
    }
}
