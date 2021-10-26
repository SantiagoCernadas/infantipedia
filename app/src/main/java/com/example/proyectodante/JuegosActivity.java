package com.example.proyectodante;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.proyectodante.PlaysActivity.PptActivity;
import com.example.proyectodante.PlaysActivity.PptActivityDosJugadores;

import static com.example.proyectodante.MainActivity.pause;
import static com.example.proyectodante.MainActivity.start;

public class JuegosActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_juegos);
    }

    public void PPT(View view){
        Intent i = new Intent(this, PptModoActivity.class);
        startActivity(i);
    }

    public void tateti(View view){
        Intent i = new Intent(this, TatetiModoActivity.class);
        startActivity(i);
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