package com.santidev.proyectodante;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.santidev.proyectodante.PlaysActivity.HowPlayActivity;
import com.santidev.proyectodante.PlaysActivity.MemoriaActivity;

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

    public void memoria(View view){
        Intent i = new Intent(this, MemoriaActivity.class);
        i.putExtra("dificultad","Dificil");
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