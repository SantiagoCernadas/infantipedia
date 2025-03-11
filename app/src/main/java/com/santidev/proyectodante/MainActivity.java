package com.santidev.proyectodante;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private TextView tv1;
    static MediaPlayer mp;
    private static String nombre;
    static boolean pause;
    public static int volumenMusica;
    public static int volumenEfecto;

    public static String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        MainActivity.nombre = nombre;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nombre = getIntent().getStringExtra("usuario");
        tv1 = findViewById(R.id.txt_welcome);
        pause = false;
        if (!nombre.equals("")) {
            tv1.setText("Hola " + nombre + "!");
        }
        volumenMusica = 25;
        volumenEfecto = 50;
        SharedPreferences sharedPreferences = getSharedPreferences("datos",Context.MODE_PRIVATE);
        volumenMusica = sharedPreferences.getInt("volumenMusica",25);
        volumenEfecto = sharedPreferences.getInt("volumenSonido",50);
        mp = MediaPlayer.create(this, R.raw.cancionfondo);
        mp.setVolume(volumenMusica / 50f,volumenMusica / 50f);
        mp.setLooping(true);
    }

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

    public void activity_figuras(View view){
        Intent i = new Intent(this, FigurasActivity.class);
        startActivity(i);
    }

    public void activity_juegos(View view) {
        Intent i = new Intent(this,JuegosActivity.class);
        startActivity(i);
    }

    public void activity_config(View view) {
        Intent i = new Intent(this, ConfigActivity.class);
        startActivity(i);
    }

    public void getMensajeProximamente() {
        Toast.makeText(this, "Proximamente...", Toast.LENGTH_SHORT).show();
    }

    public static void start(){
        pause = true;
        startLoop();
    }
    public static void pause(){
        pause = false;
        new android.os.Handler().postDelayed(
                new Runnable() {
                    public void run() {
                        if(!pause) {
                            mp.pause();
                        }
                    }
                }, 100);
    }

    private static void startLoop(){
        if(mp != null){
            if(!mp.isPlaying()){
                mp.start();
            }
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

