package com.example.bathangban;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class signin extends AppCompatActivity {
    FirebaseAuth mAuthencation;
    EditText etEmail,etPass;
    TextView tvQuenmatkhau;
    Button btnDangNhap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);

        mAuthencation = FirebaseAuth.getInstance();

        etEmail = (EditText)findViewById(R.id.editTextEmailDN);
        etPass = (EditText)findViewById(R.id.editTextTPasswordDN);
        tvQuenmatkhau =(TextView)findViewById(R.id.textViewbtnQuenMatKhauDN);
        btnDangNhap = (Button) findViewById(R.id.buttonDangNhapDN);

        btnDangNhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String semail = etEmail.getText().toString().trim();
                String spass = etPass.getText().toString().trim();
                if (semail.length()==0 | spass.length()==0){
                    Toast.makeText(signin.this, "Chào admin", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(signin.this,Home_Admin.class);
                    startActivity(intent);
                }
                else {
                    DangNhap();
                }

            }
        });
    }
    private void DangNhap(){
        String email = etEmail.getText().toString().trim();
        String password = etPass.getText().toString().trim();
        mAuthencation.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){
                            Toast.makeText(signin.this, "Đăng nhập thành công", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(signin.this,Home.class);
                            startActivity(intent);
                        }else{
                            Toast.makeText(signin.this, "Email hoặc Mật khẩu không chính xác", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }
}