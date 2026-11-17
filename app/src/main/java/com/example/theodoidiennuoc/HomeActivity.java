package com.example.theodoidiennuoc;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class HomeActivity extends AppCompatActivity {
    private TextView txtMaPhong;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_home);
        txtMaPhong = findViewById(R.id.txtMaPhong);
        Intent intent = getIntent();
        String maPhong = intent.getStringExtra("MA_PHONG");
        txtMaPhong.setText(maPhong);
        Toast.makeText(this,maPhong,Toast.LENGTH_SHORT).show();
    }
}