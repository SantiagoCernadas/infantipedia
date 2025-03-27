package com.santidev.proyectodante;

import static com.santidev.proyectodante.MainActivity.pause;
import static com.santidev.proyectodante.MainActivity.start;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.TextView;

public class ColorActivity extends AppCompatActivity {
    private TextView titulo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_color);
        titulo = findViewById(R.id.txt_color_titulo);

        String color = getIntent().getStringExtra("color");
        String colorHex = getIntent().getStringExtra("colorHex");

        titulo.setText(color);
        titulo.setTextColor(Color.parseColor(colorHex));
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