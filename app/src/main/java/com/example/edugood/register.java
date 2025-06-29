package com.example.edugood;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class register extends AppCompatActivity {

    EditText etNama, etEmail, etPhone, etPassword, etConfirmPassword;
    Spinner spinnerKelas;
    Button btnDaftar, btnMasuk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        etNama = findViewById(R.id.etNama);
        etEmail = findViewById(R.id.etEmail);
        etPhone = findViewById(R.id.etPhone);
        etPassword = findViewById(R.id.etPassword);
        etConfirmPassword = findViewById(R.id.etConfirmPassword);
        spinnerKelas = findViewById(R.id.spinnerKelas);
        btnDaftar = findViewById(R.id.btnDaftar);
        btnMasuk = findViewById(R.id.btnMasukSekarang);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.kelas_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerKelas.setAdapter(adapter);

        btnDaftar.setOnClickListener(v -> {
            String nama = etNama.getText().toString();
            String email = etEmail.getText().toString();
            String phone = etPhone.getText().toString();
            String password = etPassword.getText().toString();
            String confirmPassword = etConfirmPassword.getText().toString();
            String kelas = spinnerKelas.getSelectedItem().toString();

            if (nama.isEmpty() || email.isEmpty() || phone.isEmpty() ||
                    password.isEmpty() || confirmPassword.isEmpty()) {
                Toast.makeText(this, "Lengkapi semua data!", Toast.LENGTH_SHORT).show();
                return;
            }

            if (!password.equals(confirmPassword)) {
                Toast.makeText(this, "Password tidak cocok!", Toast.LENGTH_SHORT).show();
                return;
            }

            SharedPreferences prefs = getSharedPreferences("users", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = prefs.edit();


            String userData = prefs.getString("data", "[]");

            try {
                JSONArray userArray = new JSONArray(userData);


                for (int i = 0; i < userArray.length(); i++) {
                    JSONObject obj = userArray.getJSONObject(i);
                    if (obj.getString("email").equals(email)) {
                        Toast.makeText(this, "Email sudah terdaftar", Toast.LENGTH_SHORT).show();
                        return;
                    }
                }

                JSONObject newUser = new JSONObject();
                newUser.put("nama", nama);
                newUser.put("email", email);
                newUser.put("phone", phone);
                newUser.put("password", password);
                newUser.put("kelas", kelas);

                userArray.put(newUser);

                editor.putString("data", userArray.toString());
                editor.apply();

                Toast.makeText(this, "Daftar berhasil!", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(this, login.class));
                finish();

            } catch (JSONException e) {
                e.printStackTrace();
                Toast.makeText(this, "Gagal menyimpan data", Toast.LENGTH_SHORT).show();
            }
        });

        btnMasuk.setOnClickListener(v -> {
            startActivity(new Intent(register.this, login.class));
        });
    }
}