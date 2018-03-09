package com.petpatrol.petpatrolapp.ForgotPassword;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.google.firebase.auth.FirebaseAuth;
import com.petpatrol.petpatrolapp.Login.MainActivity;
import com.petpatrol.petpatrolapp.R;

public class ForgotPassword2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password2);


    }

    public void Back_login(View view) {
        Intent intent = new Intent(ForgotPassword2.this, MainActivity.class);
        startActivity(intent);
    }
}
