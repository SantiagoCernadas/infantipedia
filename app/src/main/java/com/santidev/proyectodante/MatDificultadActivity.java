package com.santidev.proyectodante;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.santidev.proyectodante.PlaysActivity.MatPlayActivity;

import static com.santidev.proyectodante.MainActivity.pause;
import static com.santidev.proyectodante.MainActivity.start;

public class MatDificultadActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mat_dificultad);
    }

    public void getDificultad(View view){
        switch(view.getId()){
            case R.id.dif_principiante:
                jugarCalculadora("2","10","0");
                break;
            case R.id.dif_intermedia:
                jugarCalculadora("2","30","0");
                break;
            case R.id.dif_avanzada:
                jugarCalculadora("3","50","10");
                break;
            case R.id.dif_experta:
                jugarCalculadora("3","100","20");
                break;
        }

    }

    public void jugarCalculadora(String cantSignos, String rangoSumRes, String rangoMult){
        Intent i = new Intent(this, MatPlayActivity.class);
        i.putExtra("signos",cantSignos);
        i.putExtra("rango_suma_resta",rangoSumRes);
        i.putExtra("rango_multiplicacion",rangoMult);
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