package com.santidev.proyectodante;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class LaunchScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launch_screen);

        Handler handler = new Handler();
        handler. postDelayed(new Runnable() {
            public void run() {
                Intent i = new Intent(LaunchScreenActivity.this,PrimerActivity.class);
                startActivity(i);
                finish();
            }
        }, 1500);
    }
}