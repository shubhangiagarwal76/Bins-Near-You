package com.example.smartbins;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screen);
        //SPLASH SCREEN
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent (SplashScreen.this, MapsActivity.class);
                startActivity(i);
                finish();
            }
        }, 1500); //DELLAY TIME OF SPLASH SCREEN
    }
}








