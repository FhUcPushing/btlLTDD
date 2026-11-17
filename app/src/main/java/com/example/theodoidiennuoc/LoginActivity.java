package com.example.theodoidiennuoc;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.database.sqlite.SQLiteDatabase;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.theodoidiennuoc.database.DatabaseHelper;

public class LoginActivity extends AppCompatActivity {

    private EditText edtRoomCode;
    private EditText edtPassword;
    private Button btnLogin;
    private DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);
        edtRoomCode = findViewById(R.id.edtRoomCode);
        edtPassword = findViewById(R.id.edtPassword);
        btnLogin = findViewById(R.id.btnLogin);
        db = new DatabaseHelper(this);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleLogin();
            }
        });
    }
    private void handleLogin() {
        String maPhong = edtRoomCode.getText().toString().trim();
        String matKhau = edtPassword.getText().toString().trim();
        if(maPhong.isEmpty()||matKhau.isEmpty()){
            Toast.makeText(LoginActivity.this,"Vui lòng nhập đầy đủ",Toast.LENGTH_SHORT).show();
            return;
        }
        boolean ktraDangNhap = db.kiemTraDangNhap(maPhong,matKhau);
        if(!ktraDangNhap){
            Toast.makeText(LoginActivity.this,"Sai mã phòng hoặc mật khẩu",Toast.LENGTH_SHORT).show();
            return;
        }else{
            Toast.makeText(LoginActivity.this,"Đăng nhập thành công!",Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(LoginActivity.this,HomeActivity.class);
            intent.putExtra("MA_PHONG",maPhong);
            startActivity(intent);
            finish();
        }
    }
}