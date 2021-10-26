package com.example.proyectodante;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.proyectodante.PlaysActivity.TatetiActivity;
import com.example.proyectodante.PlaysActivity.TatetiActivityDosJugadores;

import static com.example.proyectodante.MainActivity.pause;
import static com.example.proyectodante.MainActivity.start;

public class TatetiModoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ppt_modo);
    }

    public void modoCpu(View view){
        Intent i = new Intent(this, TatetiActivity.class);
        startActivity(i);
        finish();
    }

    public void dosJugadores(View view){
        Intent i = new Intent(this, TatetiActivityDosJugadores.class);
        startActivity(i);
        finish();
    }

    public void onPause() {
        super.onPause();
        pause();
    }

    @Override
    public void onResume() {
        super.onResume();
        start();
    }
}