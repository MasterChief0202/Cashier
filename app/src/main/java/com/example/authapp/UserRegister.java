package com.example.authapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.PatternMatcher;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;

import java.util.regex.Pattern;

public class UserRegister extends AppCompatActivity implements View.OnClickListener {

    private FirebaseAuth mAuth;

    private TextView UserRegister;
    private EditText editTextNamaUsaha, editTextPemilik, editTextEmail, editTextPassword;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_register);

        mAuth = FirebaseAuth.getInstance();
        TextView banner = (TextView) findViewById(R.id.banner);
        banner. setOnClickListener(this);

        UserRegister = (Button) findViewById(R.id.register);
        UserRegister . setOnClickListener(this);

        editTextEmail = (EditText) findViewById(R.id.email);
        editTextPassword = (EditText) findViewById(R.id.password);

        progressBar = (ProgressBar) findViewById(R.id.progressBar);
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.banner:
                startActivity(new Intent(this, MainActivity.class));
                break;
            case R.id.userRegister:
                userRegister();
                break;
        }
    }

    private void userRegister() {
        String namaUsaha = editTextNamaUsaha.getText().toString().trim();
        String pemilik = editTextPemilik.getText().toString().trim();
        String email = editTextEmail.getText().toString().trim();
        String password = editTextPassword.getText().toString().trim();

        if (namaUsaha.isEmpty()){
            editTextNamaUsaha.setError("Harap masukkan nama usaha");
            editTextNamaUsaha.requestFocus();
            return;
        }

        if (pemilik.isEmpty()){
            editTextPemilik.setError("Masukkan nama pemilik usaha");
            editTextPemilik.requestFocus();
            return;
        }

        if (email.isEmpty()){
            editTextEmail.setError("Masukkan email anda");
            editTextEmail.requestFocus();
            return;
        }

        if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            editTextEmail.setError("Harap masukkan email yang valid");
            editTextEmail.requestFocus();
        }

        if(password.isEmpty()){
            editTextPassword.setError("Masukkan password");
            editTextPassword.requestFocus();
            return;
        }

        if(password.length() < 6){
            editTextPassword.setError("Password minimal 6 karakter");
            editTextPassword.requestFocus();
            return;
        }
    }
}