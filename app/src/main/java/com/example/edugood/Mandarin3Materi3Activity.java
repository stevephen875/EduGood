package com.example.edugood;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class Mandarin3Materi3Activity extends AppCompatActivity {

    private Toolbar toolbar;
    private Button btnQuiz;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mandarin3_materi3);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("EduGood");
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        btnQuiz = findViewById(R.id.btn_quiz);
        btnQuiz.setOnClickListener(v -> {
            Intent intent = new Intent(Mandarin3Materi3Activity.this, Mandarin3Quiz3Activity.class);
            startActivity(intent);

        });
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


}