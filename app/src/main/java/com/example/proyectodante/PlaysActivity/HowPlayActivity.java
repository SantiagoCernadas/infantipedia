package com.example.proyectodante.PlaysActivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.proyectodante.MatDificultadActivity;
import com.example.proyectodante.R;

public class HowPlayActivity extends AppCompatActivity {
    private TextView txtTitulo,txtDescripcion;
    private ImageView img1,img2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_how_play);
        txtTitulo = findViewById(R.id.txt_titulo_juego);
        txtDescripcion = findViewById(R.id.txt_descripcion_juego);
        img1 = findViewById(R.id.imagen_ejemplo1);
        img2 = findViewById(R.id.imagen_ejemplo2);
        txtTitulo.setText(getIntent().getStringExtra("titulo"));
        txtDescripcion.setText(getIntent().getStringExtra("descripcion"));
        img1.setImageResource(getIntent().getIntExtra("idimg1",0));
        img2.setImageResource(getIntent().getIntExtra("idimg2",0));
    }

    public void jugar(View view){
        String juego = txtTitulo.getText().toString();
        Intent i;
        if(juego.equals("¿Que es?")){
            i = new Intent(this, PalabraPlayActivity.class);
        }
        else{
            i = new Intent(this, MatDificultadActivity.class);
        }
        startActivity(i);
        finish();
    }
}