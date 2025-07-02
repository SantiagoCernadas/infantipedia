package com.santidev.proyectodante;

import static com.santidev.proyectodante.MainActivity.pause;
import static com.santidev.proyectodante.MainActivity.start;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.santidev.proyectodante.PlaysActivity.MatPlayActivity;
import com.santidev.proyectodante.PlaysActivity.MemoriaActivity;

public class MemoriaDificultadActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memoria_dificultad);
    }

    public void getDificultad(View view){
        switch(view.getId()){
            case R.id.memoria_dif_facil:
                jugarMemoria("Facil");
                break;
            case R.id.memoria_dif_medio:
                jugarMemoria("Medio");
                break;
            case R.id.memoria_dif_dificil:
                jugarMemoria("Dificil");
                break;
        }
    }

    public void jugarMemoria(String dif){
        Intent i = new Intent(this, MemoriaActivity.class);
        i.putExtra("dificultad",dif);
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