package com.example.bathangban;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.bathangban.R;
import com.example.bathangban.signup;

public class MainActivity extends AppCompatActivity {
    Button btnDangKy,btnDangNhap;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnDangNhap =(Button)findViewById(R.id.buttonDangNhap);
        btnDangKy = (Button)findViewById(R.id.buttonDangKy);
        btnDangKy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Opensignup();
            }
        });
        btnDangNhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Opensignin();
            }
        });


    }
    private void Opensignup(){
        Intent intent = new Intent(MainActivity.this, signup.class);
        startActivity(intent);
    }
    private void Opensignin(){
        Intent intent = new Intent(MainActivity.this, signin.class);
        startActivity(intent);
    }
}