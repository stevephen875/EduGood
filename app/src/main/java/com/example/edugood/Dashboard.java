package com.example.edugood;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;

public class Dashboard extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout drawerLayout;
    private SharedPreferences prefs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard); // sesuai layout XML kamu

        // ✅ Setup Toolbar
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // ✅ Setup Drawer dan NavigationView
        drawerLayout = findViewById(R.id.drawerLayout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        // ✅ Buka drawer saat hamburger diklik
        toolbar.setNavigationOnClickListener(v -> drawerLayout.openDrawer(GravityCompat.START));

        // ✅ Setup SharedPreferences
        prefs = getSharedPreferences("active_user", MODE_PRIVATE);
        String kelas = prefs.getString("kelas", "Kelas 1");

        // ✅ Gambar pelajaran
        ImageView imgMandarin = findViewById(R.id.imgMandarin);
        ImageView imgIndonesia = findViewById(R.id.imgIndonesia);
        ImageView imgMatematika = findViewById(R.id.imgMatematika);

        imgMandarin.setOnClickListener(v -> startActivity(getKelasIntent("Mandarin", kelas)));
        imgIndonesia.setOnClickListener(v -> startActivity(getKelasIntent("Indonesia", kelas)));
        imgMatematika.setOnClickListener(v -> startActivity(getKelasIntent("Matematika", kelas)));
    }

    private Intent getKelasIntent(String mapel, String kelas) {
        switch (mapel) {
            case "Mandarin":
                switch (kelas) {
                    case "Kelas 1": return new Intent(this, MandarinKelas1Activity.class);
                    case "Kelas 2": return new Intent(this, MandarinKelas2Activity.class);
                    case "Kelas 3": return new Intent(this, MandarinKelas3Activity.class);
                    case "Kelas 4": return new Intent(this, MandarinKelas4Activity.class);
                }
                break;
            case "Indonesia":
                switch (kelas) {
                    case "Kelas 1": return new Intent(this, IndonesiaKelas1Activity.class);
                    case "Kelas 2": return new Intent(this, IndonesiaKelas2Activity.class);
                    case "Kelas 3": return new Intent(this, IndonesiaKelas3Activity.class);
                    case "Kelas 4": return new Intent(this, IndonesiaKelas4Activity.class);
                }
                break;
            case "Matematika":
                switch (kelas) {
                    case "Kelas 1": return new Intent(this, MatematikaKelas1Activity.class);
                    case "Kelas 2": return new Intent(this, MatematikaKelas2Activity.class);
                    case "Kelas 3": return new Intent(this, MatematikaKelas3Activity.class);
                    case "Kelas 4": return new Intent(this, MatematikaKelas4Activity.class);
                }
                break;
        }
        return new Intent(this, Dashboard.class); // fallback
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        drawerLayout.closeDrawer(GravityCompat.START);
        String kelas = prefs.getString("kelas", "Kelas 1");

        int id = item.getItemId();
        if (id == R.id.nav_mandarin) {
            startActivity(getKelasIntent("Mandarin", kelas));
        } else if (id == R.id.nav_indonesia) {
            startActivity(getKelasIntent("Indonesia", kelas));
        } else if (id == R.id.nav_matematika) {
            startActivity(getKelasIntent("Matematika", kelas));
        } else if (id == R.id.nav_target) {
            startActivity(new Intent(this, TargetActivity.class));
        } else if (id == R.id.nav_pengingat) {
            startActivity(new Intent(this, PengingatActivity.class));
        } else if (id == R.id.nav_profile) {
            startActivity(new Intent(this, ProfileActivity.class));
        } else if (id == R.id.nav_logout) {
            SharedPreferences.Editor editor = prefs.edit();
            editor.clear();
            editor.apply();
            Intent intent = new Intent(this, login.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
            finish();
        }

        return true;
    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
}