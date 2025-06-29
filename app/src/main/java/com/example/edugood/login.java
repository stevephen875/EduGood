package com.example.edugood;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class login extends AppCompatActivity {

    EditText etEmail, etPassword;
    Button btnMasukSekarang, btnToRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etEmail = findViewById(R.id.etEmail);
        etPassword = findViewById(R.id.etPassword);
        btnMasukSekarang = findViewById(R.id.btnMasukSekarang);
        btnToRegister = findViewById(R.id.btnToRegister);

        btnMasukSekarang.setOnClickListener(v -> {
            String emailInput = etEmail.getText().toString();
            String passInput = etPassword.getText().toString();

            SharedPreferences prefs = getSharedPreferences("users", MODE_PRIVATE);
            String userData = prefs.getString("data", "[]");

            try {
                JSONArray userArray = new JSONArray(userData);
                for (int i = 0; i < userArray.length(); i++) {
                    JSONObject obj = userArray.getJSONObject(i);
                    if (obj.getString("email").equals(emailInput) &&
                            obj.getString("password").equals(passInput)) {

                        // ✅ Simpan user yang sedang login
                        SharedPreferences loginPrefs = getSharedPreferences("active_user", MODE_PRIVATE);
                        SharedPreferences.Editor editor = loginPrefs.edit();
                        editor.putString("email", emailInput);
                        editor.putString("kelas", obj.getString("kelas"));
                        editor.apply();

                        // ✅ Masuk ke Dashboard
                        startActivity(new Intent(this, Dashboard.class));
                        finish();
                        return;
                    }
                }

                Toast.makeText(this, "Email atau password salah", Toast.LENGTH_SHORT).show();

            } catch (JSONException e) {
                e.printStackTrace();
                Toast.makeText(this, "Data rusak", Toast.LENGTH_SHORT).show();
            }
        });

        btnToRegister.setOnClickListener(v -> {
            startActivity(new Intent(this, register.class));
        });
    }
}