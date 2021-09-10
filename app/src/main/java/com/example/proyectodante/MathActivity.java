package com.example.proyectodante;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.proyectodante.PlaysActivity.MatPlayActivity;

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

    public void jugarCalculadora(View view){
        Intent i = new Intent(this, MatPlayActivity.class);
        startActivity(i);
    }
}