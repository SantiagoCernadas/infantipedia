package com.example.proyectodante;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class LetraActivity extends AppCompatActivity {

    private TextView titulo,tv1,tv2,tv3;
    private ImageView img1,img2,img3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_letra);
        String letraSeleccionada = getIntent().getStringExtra("letra");


        titulo = findViewById(R.id.txt_letra_titulo);
        tv1 = findViewById(R.id.txt_letra_ej1);
        tv2 = findViewById(R.id.txt_letra_ej2);
        tv3 = findViewById(R.id.txt_letra_ej3);
        img1 = findViewById(R.id.img_ej1);
        img2 = findViewById(R.id.img_ej2);
        img3 = findViewById(R.id.img_ej3);


        titulo.setText("Letra " + letraSeleccionada);
        generarActivity(letraSeleccionada);
    }

    public void generarActivity(String letra){
        switch (letra){
            case "A":
                tv1.setText("Arbol");
                img1.setImageResource(R.drawable.aejuno);
                tv2.setText("Abeja");
                img2.setImageResource(R.drawable.aejdos);
                tv3.setText("Avion");
                img3.setImageResource(R.drawable.aejtres);
                break;
            default:
                tv1.setText("Error");
                break;
        }
    }
}