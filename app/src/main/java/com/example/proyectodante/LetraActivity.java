package com.example.proyectodante;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class LetraActivity extends AppCompatActivity {

    private TextView titulo,tv1,tv2,tv3;
    private ImageView img1,img2,img3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_letra);
        String letraSeleccionada = getIntent().getStringExtra("letra");
        titulo = findViewById(R.id.txt_letra_titulo);
        titulo.setText("Letra " + letraSeleccionada);
    }
}