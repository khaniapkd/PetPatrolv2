package com.petpatrol.petpatrolapp.Login;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.facebook.CallbackManager;
import com.facebook.FacebookActivity;
import com.facebook.login.widget.LoginButton;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.petpatrol.petpatrolapp.ForgotPassword.ForgotPassword2;
import com.petpatrol.petpatrolapp.Register.PetCareRegisterActivity;
import com.petpatrol.petpatrolapp.R;
import com.petpatrol.petpatrolapp.SignIn.SignIn;
import com.petpatrol.petpatrolapp.SignOut.SignOut;

import java.security.AccessController;
import java.security.Provider;

public class MainActivity extends AppCompatActivity {

    private EditText mEmail;
    private EditText mPassword;
    private Button mlogin;


    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        mAuth = FirebaseAuth.getInstance();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mEmail = (EditText) findViewById(R.id.email);
        mPassword = (EditText) findViewById(R.id.password);
        mlogin = (Button) findViewById(R.id.login);



        mAuth = FirebaseAuth.getInstance();
        mAuthListener = new FirebaseAuth.AuthStateListener() {

            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {

                if (firebaseAuth.getCurrentUser() != null) {

                    startActivity(new Intent(MainActivity.this, SignOut.class) );
                }
            }
        };
        mlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SignIn();
            }
        });
    }

    private void SignIn() {

        String email = mEmail.getText().toString();
        String password = mPassword.getText().toString();

        if (TextUtils.isEmpty(email) | TextUtils.isEmpty(password)) {
            Toast.makeText(MainActivity.this, "Harap isi Email dan Password Anda", Toast.LENGTH_SHORT).show();

        } else {

            mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener() {

                @Override

                public void onComplete(@NonNull Task task) {
                    if (!task.isSuccessful()) {
                        Toast.makeText(MainActivity.this, "Login Error", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }

    @Override

    protected void onStart() {
        super.onStart();
        mAuth.addAuthStateListener(mAuthListener);

    }


    public void SignUp(View view) {
        Intent intent = new Intent(MainActivity.this, PetCareRegisterActivity.class);
        startActivity(intent);
    }

    public void forgot(View view) {
        Intent intent = new Intent(MainActivity.this, ForgotPassword2.class);
        startActivity(intent);
    }

    public void loginFB(View view) {
        Intent intent = new Intent(MainActivity.this, SignIn.class);
        startActivity(intent);
    }


    public final class JSSEProvider extends Provider {

        public JSSEProvider() {
            super("HarmonyJSSE", 1.0, "Harmony JSSE Provider");
            AccessController.doPrivileged(new java.security.PrivilegedAction<Void>() {
                public Void run() {
                    put("SSLContext.TLS",
                            "org.apache.harmony.xnet.provider.jsse.SSLContextImpl");
                    put("Alg.Alias.SSLContext.TLSv1", "TLS");
                    put("KeyManagerFactory.X509",
                            "org.apache.harmony.xnet.provider.jsse.KeyManagerFactoryImpl");
                    put("TrustManagerFactory.X509",
                            "org.apache.harmony.xnet.provider.jsse.TrustManagerFactoryImpl");
                    return null;
                }
            });
        }
    }
}