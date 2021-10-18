package com.example.proyectodante;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private TextView tv1;
    private static MediaPlayer mp;
    private ImageButton iv,iv2;
    private static String nombre;

    public static String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    private boolean musicaRep;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nombre = getIntent().getStringExtra("usuario");
        iv = findViewById(R.id.iv_musica);
        iv2 = findViewById(R.id.iv_musica_off);
        tv1 = findViewById(R.id.txt_welcome);
        if (!nombre.equals("")) {
            tv1.setText("Hola " + nombre + "!");
        }
        musicaRep = true;
        mp = MediaPlayer.create(this,R.raw.cancionfondo);
        mp.setLooping(true);
        mp.setVolume(0.5f,0.5f);
        mp.start();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        mp.stop();
    }


    public void activity_abecedario(View view) {
        Intent i = new Intent(this, AbecedarioActivity.class);
        startActivity(i);
    }

    public void activity_matematicas(View view) {
        Intent i = new Intent(this, MathActivity.class);
        startActivity(i);
    }

    public void activity_animales(View view) {
        Intent i = new Intent(this,AnimalesActivity.class);
        startActivity(i);
    }

    public void activity_dibujo(View view) {
        Intent i = new Intent(this,JuegosActivity.class);
        startActivity(i);
    }

    public void getMensajeProximamente() {
        Toast.makeText(this, "Proximamente...", Toast.LENGTH_SHORT).show();
    }

    public void modificarEstadoMusica(View view){
        if(musicaRep){
            iv.setVisibility(View.INVISIBLE);
            iv2.setVisibility(View.VISIBLE);
            musicaRep = false;
            mp.setVolume(0,0);
        }
        else{
            iv2.setVisibility(View.INVISIBLE);
            iv.setVisibility(View.VISIBLE);
            musicaRep = true;
            mp.setVolume(0.5f,0.5f);
        }
    }
}