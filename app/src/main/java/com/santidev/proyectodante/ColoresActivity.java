package com.santidev.proyectodante;

import static com.santidev.proyectodante.MainActivity.pause;
import static com.santidev.proyectodante.MainActivity.start;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class ColoresActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_colores);
    }

    public void teclaPresionada(View view){
        switch (view.getId()){
            case R.id.button_amarillo:
                startLetraActivity("Amarillo","#FFEB3B");
                break;
            case R.id.button_celeste:
                startLetraActivity("Celeste","#00BCD4");
                break;
            case R.id.button_rojo:
                startLetraActivity("Rojo","#DA0000");
                break;
            case R.id.button_verde:
                startLetraActivity("Verde","#8BC34A");
                break;
            case R.id.button_naranja:
                startLetraActivity("Naranja","#FF9800");
                break;
            case R.id.button_negro:
                startLetraActivity("Negro","#000000");
                break;
            case R.id.button_blanco:
                startLetraActivity("Blanco","#FFFFFF");
                break;
            case R.id.button_marron:
                startLetraActivity("Marron","#6C3B2A");
                break;
            case R.id.button_rosa:
                startLetraActivity("Rosa","#FF0080");
                break;
            case R.id.button_azul:
                startLetraActivity("Azul" ,"#0037A4");
                break;
            case R.id.button_morado:
                startLetraActivity("Morado","#673AB7");
                break;
            default:
                Toast.makeText(this,"Color no encontrado.",Toast.LENGTH_SHORT).show();
                break;
        }
    }

    public void startLetraActivity(String color,String colorHex){
        Intent i = new Intent(this,ColorActivity.class);
        i.putExtra("color",color);
        i.putExtra("colorHex",colorHex);
        startActivity(i);
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