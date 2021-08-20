package com.example.proyectodante;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MathActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mat);
    }

    public void signoSumar(View view){
        iniciarCalculadora("+");
    }
    public void signoRestar(View view){
        iniciarCalculadora("-");
    }

    public void iniciarCalculadora(String signo){
        Intent i = new Intent(this,CalculadoraActivity.class);
        i.putExtra("signo",signo);
        startActivity(i);
    }
}