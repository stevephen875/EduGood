package com.example.edugood.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

import com.example.edugood.R;
import com.example.edugood.model.Pengguna;
import io.realm.Realm;

public class Penggunaadapter extends ArrayAdapter<Pengguna> {

    public Penggunaadapter(@NonNull Context context, ArrayList<Pengguna> arrayList) {

        super(context, 0, arrayList);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View currentItemView = convertView;

        if (currentItemView == null) {
            currentItemView = LayoutInflater.from(getContext())
                    .inflate(R.layout.layout_user_item, parent, false);
        }

        Pengguna currentNumberPosition = getItem(position);

        TextView textView1 = currentItemView.findViewById(R.id.etNama);
        textView1.setText(currentNumberPosition.getName());

        TextView textView2= currentItemView.findViewById(R.id.etEmail);
        textView2.setText(currentNumberPosition.getEmail());

        TextView textView3= currentItemView.findViewById(R.id.etPhone);
        textView3.setText(currentNumberPosition.getPhoneNumber());

        TextView textView4= currentItemView.findViewById(R.id.etPassword);
        textView4.setText(currentNumberPosition.getPassword());

        TextView textView5= currentItemView.findViewById(R.id.etConfirmPassword);
        textView5.setText(currentNumberPosition.getKonfirmasipassword());

        TextView textView6= currentItemView.findViewById(R.id.spinnerKelas);
        textView6.setText(currentNumberPosition.getStudentClass());

        return currentItemView;
    }
}