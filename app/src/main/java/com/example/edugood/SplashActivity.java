package com.example.edugood;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

public class SplashActivity extends AppCompatActivity {

    private static final int SPLASH_DELAY = 2000; // 2 detik

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        new Handler().postDelayed(() -> {
            SharedPreferences prefs = getSharedPreferences("active_user", MODE_PRIVATE);
            String email = prefs.getString("email", null);

            if (email != null) {
                startActivity(new Intent(SplashActivity.this, Dashboard.class));
            } else {
                startActivity(new Intent(SplashActivity.this, login.class));
            }
            finish();
        }, SPLASH_DELAY);
    }
}
