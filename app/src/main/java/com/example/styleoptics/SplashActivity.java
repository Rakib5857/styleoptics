package com.example.styleoptics;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class SplashActivity extends AppCompatActivity {

    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //make fullscreen
        getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash);

        firebaseAuth = FirebaseAuth.getInstance();

        //start login activity after 2sec
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
              FirebaseUser user = firebaseAuth.getCurrentUser();
              if (user==null){
                  //user not logged in start login activity
                  startActivity(new Intent(SplashActivity.this,MainActivity.class));
                  finish();
              }//user is logger in, check type

            }
        },2000);

    }

}
