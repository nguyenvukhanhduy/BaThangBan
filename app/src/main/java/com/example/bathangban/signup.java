package com.example.bathangban;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.bathangban.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class signup extends AppCompatActivity {
    FirebaseAuth mAuthencation;
    Button btnDangKy;
    EditText etEmail,etPass,etRepeatPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        mAuthencation = FirebaseAuth.getInstance();

        btnDangKy = (Button) findViewById(R.id.buttonDangKyDk);
        etEmail = (EditText)findViewById(R.id.editTextEmailDK);
        etPass = (EditText)findViewById(R.id.editTextTPasswordDK);
        etRepeatPass = (EditText)findViewById(R.id.editTextRepeatPasswordDK);
        btnDangKy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String semail = etEmail.getText().toString().trim();
                String spass = etPass.getText().toString().trim();
                String srepass = etRepeatPass.getText().toString().trim();
                if (spass.equals(srepass) && spass.length()>5 && srepass.length()>5 && semail.length()>0){
                    DangKy();
                }else if (semail.length()<1){
                    Toast.makeText(signup.this, "Vui lòng điền Email", Toast.LENGTH_SHORT).show();
                }
                else if (spass.length()<6 && srepass.length()<6){
                    Toast.makeText(signup.this, "Mật khẩu phải có ít nhất 6 kí tự", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(signup.this, "Mật khẩu không khớp", Toast.LENGTH_SHORT).show();
                }

            }
        });

    }
    private void DangKy(){
        String email =  etEmail.getText().toString().trim();
        String password = etPass.getText().toString().trim();
        mAuthencation.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(signup.this, "Đăng Ký thành công", Toast.LENGTH_SHORT).show();
                        }else {
                            Toast.makeText(signup.this, "Email đã tồn tại hoặc sai định dạng", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }
}