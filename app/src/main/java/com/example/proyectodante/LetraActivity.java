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
                img1.setImageResource(R.drawable.aejarbol);
                tv2.setText("Abeja");
                img2.setImageResource(R.drawable.aejabeja);
                tv3.setText("Agua");
                img3.setImageResource(R.drawable.aejagua);
                break;
            case "B":
                tv1.setText("Barco");
                tv2.setText("Ballena");
                tv3.setText("Botella");
                break;
            case "C":
                tv1.setText("Casa");
                tv2.setText("Caramelo");
                tv3.setText("Castillo");
                break;
            case "D":
                tv1.setText("Dado");
                tv2.setText("Delfin");
                tv3.setText("Dinosaurio");
                break;
            case "E":
                tv1.setText("Elefante");
                tv2.setText("Estrella");
                tv3.setText("Escalera");
                break;
            default:
                tv1.setText("Error");
                tv2.setText("Error");
                tv3.setText("Error");
                break;
        }
    }
}