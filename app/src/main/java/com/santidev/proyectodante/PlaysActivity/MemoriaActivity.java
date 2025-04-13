package com.santidev.proyectodante.PlaysActivity;

import static com.santidev.proyectodante.MainActivity.pause;
import static com.santidev.proyectodante.MainActivity.start;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.santidev.proyectodante.R;

public class MemoriaActivity extends AppCompatActivity {
    private int puntos,cantCartas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String dif = getIntent().getStringExtra("dificultad");


        if(dif.equals("Facil")){
            setContentView(R.layout.activity_memoria);
            cantCartas = 6;
        }
        else if(dif.equals("Medio")){
            setContentView(R.layout.activity_memoria_medio);
            cantCartas = 12;
        }
        else{
            setContentView(R.layout.activity_memoria_dificil);
            cantCartas = 20;
        }


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