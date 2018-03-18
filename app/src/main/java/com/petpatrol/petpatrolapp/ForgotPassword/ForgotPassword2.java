package com.petpatrol.petpatrolapp.ForgotPassword;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.google.firebase.auth.FirebaseAuth;
import com.petpatrol.petpatrolapp.Login.MainActivity;
import com.petpatrol.petpatrolapp.R;
import com.petpatrol.petpatrolapp.Register.PetCareRegisterActivity;
import com.petpatrol.petpatrolapp.SignIn.SignIn;
import com.petpatrol.petpatrolapp.ForgotPassword.ForgotPassword;

public class ForgotPassword2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);


    }

    public void regis(View view) {
        Intent intent = new Intent(ForgotPassword2.this, PetCareRegisterActivity.class);
        startActivity(intent);
    }

    public void send_email(View view) {
        Intent intent = new Intent(ForgotPassword2.this,ForgotPassword.class );
        startActivity(intent);
    }

}
