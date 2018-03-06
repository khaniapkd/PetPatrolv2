package com.petpatrol.petpatrolapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void send_email(View view) {
        Intent intent = new Intent(MainActivity.this,ForgotPassword2.class );
        startActivity(intent);
    }
}
