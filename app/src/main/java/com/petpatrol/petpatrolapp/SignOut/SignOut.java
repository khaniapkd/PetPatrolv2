package com.petpatrol.petpatrolapp.SignOut;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.google.firebase.auth.FirebaseAuth;
import com.petpatrol.petpatrolapp.Login.MainActivity;
import com.petpatrol.petpatrolapp.R;

public class SignOut extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_out);
    }

    public void SignOut(View view) {
        Intent intent = new Intent(SignOut.this, MainActivity.class);
        FirebaseAuth.getInstance().signOut();
        startActivity(intent);
    }
}


