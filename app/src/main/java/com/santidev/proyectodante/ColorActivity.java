package com.santidev.proyectodante;

import static com.santidev.proyectodante.MainActivity.pause;
import static com.santidev.proyectodante.MainActivity.start;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class ColorActivity extends AppCompatActivity {
    private TextView titulo,tv1,tv2,tv3;
    private ImageView img1,img2,img3;
    private String colorHex;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_color);
        titulo = findViewById(R.id.txt_color_titulo);
        tv1 = findViewById(R.id.txt_color_ej1);
        tv2 = findViewById(R.id.txt_color_ej2);
        tv3 = findViewById(R.id.txt_color_ej3);

        img1 = findViewById(R.id.img_color_ej1);
        img2 = findViewById(R.id.img_color_ej2);
        img3 = findViewById(R.id.img_color_ej3);

        String color = getIntent().getStringExtra("color");
        colorHex = getIntent().getStringExtra("colorHex");

        setPalabras(getIntent().getStringExtra("nombre1"),
                getIntent().getStringExtra("nombre2"),
                getIntent().getStringExtra("nombre3"));

        setImagenes(getIntent().getIntExtra("idImg1",0),
                getIntent().getIntExtra("idImg2",0),
                getIntent().getIntExtra("idImg3",0));


        titulo.setText(color);
        titulo.setTextColor(Color.parseColor(colorHex));
    }

    public void setPalabras(String palabra1,String palabra2, String palabra3){
        tv1.setText(palabra1);
        tv1.setTextColor(Color.parseColor(colorHex));
        tv2.setText(palabra2);
        tv2.setTextColor(Color.parseColor(colorHex));
        tv3.setText(palabra3);
        tv3.setTextColor(Color.parseColor(colorHex));
    }

    public void setImagenes(int idImg1,int idImg2, int idImg3){
        img1.setImageResource(idImg1);
        img2.setImageResource(idImg2);
        img3.setImageResource(idImg3);
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