package com.example.edugood;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class Matematika3Materi2Activity extends AppCompatActivity {

    private Toolbar toolbar;
    private Button btnQuiz;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_matematika3_materi2);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("EduGood - Kelas 3");
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
        toolbar.setNavigationOnClickListener(v -> finish());

        btnQuiz = findViewById(R.id.btn_quiz);
        btnQuiz.setOnClickListener(v -> {
            Intent intent = new Intent(this, Matematika3Quiz2Activity.class);
            startActivity(intent);
        });
    }
}