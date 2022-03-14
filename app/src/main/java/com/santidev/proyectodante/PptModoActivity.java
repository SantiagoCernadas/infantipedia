package com.santidev.proyectodante;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.santidev.proyectodante.PlaysActivity.PptActivity;
import com.santidev.proyectodante.PlaysActivity.PptActivityDosJugadores;
import static com.santidev.proyectodante.MainActivity.pause;
import static com.santidev.proyectodante.MainActivity.start;

public class PptModoActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ppt_modo);
        TextView txtTitulo = findViewById(R.id.txt_play_title);
        txtTitulo.setText("Piedra papel o tijeras");
    }

    public void modoCpu(View view){
        Intent i = new Intent(this, PptActivity.class);
        startActivity(i);
        finish();
    }

    public void dosJugadores(View view){
        Intent i = new Intent(this, PptActivityDosJugadores.class);
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