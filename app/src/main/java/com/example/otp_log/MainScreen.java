package com.example.otp_log;

//This is the home activity, replace it with project's home activity.

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.firebase.auth.FirebaseAuth;

public class MainScreen extends AppCompatActivity {

    Button logOut;
    FirebaseAuth fa;
    GoogleSignInAccount account;
    GoogleSignInClient mGoogleSignInClient;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen);

        logOut= findViewById(R.id.logout);

        fa= FirebaseAuth.getInstance();
        account = GoogleSignIn.getLastSignedInAccount(this);
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();
        // Build a GoogleSignInClient with the options specified by gso.
        mGoogleSignInClient = GoogleSignIn.getClient(this, gso);

        logOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fa.signOut();
                mGoogleSignInClient.signOut();
                Toast.makeText(MainScreen.this,"Logged Out!!",Toast.LENGTH_LONG).show();
                Intent logIn= new Intent(MainScreen.this, Login.class);
                startActivity(logIn);
                finish();
            }
        });
    }
}