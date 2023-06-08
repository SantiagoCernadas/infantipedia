package com.santidev.proyectodante.PlaysActivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.santidev.proyectodante.MatDificultadActivity;
import com.santidev.proyectodante.R;

import static com.santidev.proyectodante.MainActivity.pause;
import static com.santidev.proyectodante.MainActivity.start;

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
        Intent i = null;
        if(juego.equals("¿Que es?")){
            i = new Intent(this, PalabraPlayActivity.class);
        }
        else if (juego.equals("Problemas matematicos")){
            i = new Intent(this, MatDificultadActivity.class);
        }
        else if(juego.equals("En su lugar")){
            i = new Intent(this,FiguraPlayActivity.class);
        }
        startActivity(i);
        finish();
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