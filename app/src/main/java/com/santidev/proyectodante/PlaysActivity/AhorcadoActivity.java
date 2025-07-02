package com.santidev.proyectodante.PlaysActivity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.santidev.proyectodante.Manager.PalabraPlayManager;
import com.santidev.proyectodante.R;

public class AhorcadoActivity extends AppCompatActivity {

    private int puntos;
    private TextView txtTitulo,txtPalabra,txtPuntos;
    private ImageView imgEnigma,imgPersona;
    private String[] palabras;
    private int[] idImagen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ahorcado);
        setIds();
        idImagen = PalabraPlayManager.setImagenes();
        palabras =  PalabraPlayManager.setPalabras();
        generarProblema();
    }

    private void generarProblema() {
        int palabraAleatoria = (int)(Math.random()*idImagen.length+0);
        txtPalabra.setText(palabras[palabraAleatoria]);
        imgEnigma.setImageResource(idImagen[palabraAleatoria]);
    }

    private void setIds() {
        imgEnigma = findViewById(R.id.img_ahorcado_enigma);
        imgPersona = findViewById(R.id.img_ahorcado_persona);
        txtTitulo = findViewById(R.id.txt_titulo_ahorcado);
        txtPalabra = findViewById(R.id.txt_ahorcado_palabra);
        txtPuntos = findViewById(R.id.txt_ahorcado_puntos);
    }


}