package com.example.edugood;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONArray;
import org.json.JSONObject;

public class ProfileActivity extends AppCompatActivity {

    TextView tvNama, tvEmail, tvPhone, tvKelas;
    Button btnEdit;

    SharedPreferences prefs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        tvNama = findViewById(R.id.tvNama);
        tvEmail = findViewById(R.id.tvEmail);
        tvPhone = findViewById(R.id.tvPhone);
        tvKelas = findViewById(R.id.tvKelas);
        btnEdit = findViewById(R.id.btnEdit);

        prefs = getSharedPreferences("active_user", MODE_PRIVATE);
        showData();

        btnEdit.setOnClickListener(v -> showEditDialog());
    }

    private void showData() {
        tvNama.setText("Nama: " + prefs.getString("nama", "-"));
        tvEmail.setText("Email: " + prefs.getString("email", "-"));
        tvPhone.setText("No. Telepon: " + prefs.getString("phone", "-"));
        tvKelas.setText("Kelas: " + prefs.getString("kelas", "-"));
    }

    private void showEditDialog() {
        LinearLayout layout = new LinearLayout(this);
        layout.setOrientation(LinearLayout.VERTICAL);
        layout.setPadding(50, 40, 50, 10);

        final EditText inputNama = new EditText(this);
        inputNama.setHint("Nama baru");
        inputNama.setText(prefs.getString("nama", ""));
        layout.addView(inputNama);

        final EditText inputPhone = new EditText(this);
        inputPhone.setHint("No. Telepon baru");
        inputPhone.setText(prefs.getString("phone", ""));
        layout.addView(inputPhone);

        new AlertDialog.Builder(this)
                .setTitle("Edit Profil")
                .setView(layout)
                .setPositiveButton("Simpan", (dialog, which) -> {
                    String namaBaru = inputNama.getText().toString();
                    String phoneBaru = inputPhone.getText().toString();

                    SharedPreferences.Editor editor = prefs.edit();
                    editor.putString("nama", namaBaru);
                    editor.putString("phone", phoneBaru);
                    editor.apply();

                    SharedPreferences allUsers = getSharedPreferences("users", MODE_PRIVATE);
                    String userData = allUsers.getString("data", "[]");

                    try {
                        JSONArray userArray = new JSONArray(userData);
                        for (int i = 0; i < userArray.length(); i++) {
                            JSONObject obj = userArray.getJSONObject(i);
                            if (obj.getString("email").equals(prefs.getString("email", ""))) {
                                obj.put("nama", namaBaru);
                                obj.put("phone", phoneBaru);
                                break;
                            }
                        }

                        // Simpan ulang data users
                        SharedPreferences.Editor usersEditor = allUsers.edit();
                        usersEditor.putString("data", userArray.toString());
                        usersEditor.apply();

                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                    showData();
                })
                .setNegativeButton("Batal", null)
                .show();
    }
}