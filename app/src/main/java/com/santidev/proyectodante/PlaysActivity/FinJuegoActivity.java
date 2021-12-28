package com.santidev.proyectodante.PlaysActivity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.santidev.proyectodante.R;

import static com.santidev.proyectodante.MainActivity.pause;
import static com.santidev.proyectodante.MainActivity.start;

public class FinJuegoActivity extends AppCompatActivity {
    private TextView msjPuntos,msjFinal;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fin_juego);
        int puntos = getIntent().getIntExtra("puntos",0);
        msjPuntos = findViewById(R.id.txt_msj_puntos);
        msjFinal = findViewById(R.id.txt_msj_final);
        setMensajePuntos(puntos);
        setMensajeFinal(puntos);
    }

    public void setMensajeFinal(int puntos) {
        if(puntos < 5){
            msjFinal.setText("¡Buen intento!");
        }
        else if(puntos < 10){
            msjFinal.setText("¡Buena puntuación!");
        }
        else if(puntos < 20){
            msjFinal.setText("¡Muy bien!");
        }
        else if(puntos < 35){
            msjFinal.setText("¡Excelente!");
        }
        else if(puntos < 50){
            msjFinal.setText("¡Impresionante!");
        }
        else{
            msjFinal.setText("¡Eres Muy Inteligente!");
        }
    }

    public void setMensajePuntos(int puntos) {
        if(puntos == 1){
            msjPuntos.setText("Obtuviste " + puntos + " punto");
        }
        else{
            msjPuntos.setText("Obtuviste " + puntos + " puntos");
        }
    }

    public void volverMenu(View view){
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