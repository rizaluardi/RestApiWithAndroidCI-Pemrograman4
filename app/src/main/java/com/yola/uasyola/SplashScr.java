package com.yola.uasyola;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;

public class SplashScr extends AppCompatActivity {
    SharedPreferences sharedPreferences;
    private static final String APUSI="apusi";

    private int waktu_splash=4000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SharedPreferences apusPref = this.getSharedPreferences(APUSI, Context.MODE_PRIVATE);
        if (apusPref.getBoolean("Apus", false)) {
            Intent mainIntent = new Intent(SplashScr.this, LoginActivity.class);
            startActivity(mainIntent);
        }
        else
            setContentView(R.layout.activity_splash_scr);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                //setelah loading maka akan langsung berpindah ke home activity
                apusPref.edit().putBoolean("Apus", true).apply();
                Intent home=new Intent(SplashScr.this, LoginActivity.class);
                startActivity(home);
                finish();

            }
        },waktu_splash);
    }
}