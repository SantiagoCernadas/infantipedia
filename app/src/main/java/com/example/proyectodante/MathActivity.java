package com.example.proyectodante;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.proyectodante.PlaysActivity.HowPlayActivity;

public class MathActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mat);
    }


    public void iniciarCalculadora(View view){
        Intent i = new Intent(this,CalculadoraActivity.class);
        startActivity(i);
    }

    public void howPlayActivity(View view){
        Intent i = new Intent(this, HowPlayActivity.class);
        i.putExtra("titulo","Problemas matematicos");
        i.putExtra("descripcion","En este minijuego tendrás problemas matemáticos que " +
                "varían según la dificultad seleccionada, después de resolver el problema " +
                "tienes 3 opciones: ver si el problema es correcto con el botón de “=”, " +
                "borrar un número con el botón “borrar” y borrar el numero completo con el botón " +
                "“borrar todo”. la partida se acabará si pierdes todas " +
                "las vidas. ¡Buena suerte y diviértete!");
        startActivity(i);
    }
}