package com.santidev.proyectodante;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.santidev.proyectodante.PlaysActivity.HowPlayActivity;

import static com.santidev.proyectodante.MainActivity.pause;
import static com.santidev.proyectodante.MainActivity.start;

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

    public void palabraPlay(View view){
        Intent i = new Intent(this, HowPlayActivity.class);
        i.putExtra("titulo","¿Que es?");
        i.putExtra("descripcion","4 Palabras, 1 Correcta");
        i.putExtra("idimg1",R.drawable.palabraplayej1);
        i.putExtra("idimg2",R.drawable.palabraplayej2);
        startActivity(i);
    }

    public void matPlay(View view){
        Intent i = new Intent(this, HowPlayActivity.class);
        i.putExtra("titulo","Problemas matematicos");
        i.putExtra("descripcion","1 problema matematico, 1 solución");
        i.putExtra("idimg1",R.drawable.matplayej1);
        i.putExtra("idimg2",R.drawable.matplayej2);
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