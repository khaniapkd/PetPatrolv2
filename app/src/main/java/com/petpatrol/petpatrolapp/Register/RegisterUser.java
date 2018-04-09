package com.petpatrol.petpatrolapp.Register;

import android.nfc.Tag;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.petpatrol.petpatrolapp.R;

import java.util.HashMap;
import java.util.Map;

public class RegisterUser extends AppCompatActivity {

    public static final String USERNAME_KEY = "username";
    public static final String EMAIL_KEY = "email";
    public static final String SANDI_KEY = "password";
   // public static final String REPASSWORD_KEY = "repassword";

    private DocumentReference mDocRef = FirebaseFirestore.getInstance().document("PetPatrol/UserData");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_user);
    }


    public void saveDataUser(View view) {
        EditText usrUsername = findViewById(R.id.usr_usrname);
        EditText usrEmail = findViewById(R.id.usr_usremail);
        EditText usrSandi = findViewById(R.id.usr_sandi);
        //EditText usrRePassword = findViewById(R.id.usr_usrre_password);

        String UsernameText = usrUsername.getText().toString();
        String EmailText = usrEmail.getText().toString();
        String SandiText = usrSandi.getText().toString();
        //String RePasswordText = usrRePassword.getText().toString();

        if (UsernameText.isEmpty() || EmailText.isEmpty()) { return;} // || PasswordText.isEmpty() || RePasswordText.isEmpty()

        Map<String, Object> dataToSave = new HashMap<String, Object>();

        dataToSave.put(USERNAME_KEY,UsernameText);
        dataToSave.put(EMAIL_KEY,EmailText);
        dataToSave.put(SANDI_KEY,SandiText);
        //dataToSave.put(REPASSWORD_KEY,usrRePassword);

        mDocRef.set(dataToSave).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if (task.isSuccessful()) {
                    Toast.makeText(RegisterUser.this, "Document has been saved", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(RegisterUser.this, "Document has not been saved", Toast.LENGTH_SHORT).show();
                }
            }

        });

    }


}
