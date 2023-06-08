package com.santidev.proyectodante;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.santidev.proyectodante.PlaysActivity.HowPlayActivity;

import static com.santidev.proyectodante.MainActivity.pause;
import static com.santidev.proyectodante.MainActivity.start;

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
        i.putExtra("descripcion","1 problema matematico, 1 solución");
        i.putExtra("idimg1",R.drawable.matplayej1);
        i.putExtra("idimg2",R.drawable.matplayej2);
        startActivity(i);
    }

    public void familiaActivity(View view){
        Intent i = new Intent(this, NumFamiliaActivity.class);
        startActivity(i);
    }

    public void tablasActivity(View view){
        Intent i = new Intent(this, NumTablaActivity.class);
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