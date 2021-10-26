package com.example.proyectodante;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.proyectodante.PlaysActivity.HowPlayActivity;

import static com.example.proyectodante.MainActivity.pause;
import static com.example.proyectodante.MainActivity.start;

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
                "las vidas. Si quieres una pista pulsa el botón “¿?”. ¡Buena suerte y diviértete!");
        i.putExtra("idimg1",R.drawable.matplayej1);
        i.putExtra("idimg2",R.drawable.matplayej2);
        startActivity(i);
    }

    public void familiaActivity(View view){
        Intent i = new Intent(this, familiasActivity.class);
        startActivity(i);
    }

    public void tablasActivity(View view){
        Intent i = new Intent(this, TablasActivity.class);
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