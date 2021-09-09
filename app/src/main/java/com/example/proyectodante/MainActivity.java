package com.example.proyectodante;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private TextView tv1;
    private MediaPlayer mp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String nombre = getIntent().getStringExtra("usuario");
        tv1 = findViewById(R.id.txt_welcome);
        if (!nombre.equals("invitado")) {
            tv1.setText("Hola " + nombre + "!");
        }
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
        Intent i = new Intent(this,DibujarActivity.class);
        startActivity(i);
    }

    public void getMensajeProximamente() {
        Toast.makeText(this, "Proximamente...", Toast.LENGTH_SHORT).show();
    }
}