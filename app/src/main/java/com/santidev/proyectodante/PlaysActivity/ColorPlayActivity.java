package com.santidev.proyectodante.PlaysActivity;

import static com.santidev.proyectodante.MainActivity.pause;
import static com.santidev.proyectodante.MainActivity.start;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import com.santidev.proyectodante.Manager.MinijuegoManager;
import com.santidev.proyectodante.R;

public class ColorPlayActivity extends AppCompatActivity {

    private MinijuegoManager minijuegoManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_color_play);

        minijuegoManager = new MinijuegoManager(3,0,3,
                findViewById(R.id.txt_color_vidas),findViewById(R.id.txt_color_puntos),findViewById(R.id.txt_pista_color),
                findViewById(R.id.txt_pista_color_cant),findViewById(R.id.button_pista_color));
    }



    @Override
    public void onBackPressed() {
        AlertDialog.Builder alerta = new AlertDialog.Builder(ColorPlayActivity.this);
        alerta.setMessage("Perderás todo tu progreso");
        alerta.setCancelable(true);
        alerta.setPositiveButton("Salir", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Intent salir = new Intent(ColorPlayActivity.this,FinJuegoActivity.class);
                salir.putExtra("puntos",minijuegoManager.getPuntos());
                startActivity(salir);
                finish();
            }

        });
        alerta.setNegativeButton("Continuar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        });
        AlertDialog titulo = alerta.create();
        titulo.setTitle("¿Deseas salir?");
        titulo.show();
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