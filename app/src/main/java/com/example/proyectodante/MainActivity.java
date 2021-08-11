package com.example.proyectodante;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void activity_abecedario(View view){
        //activity Abecedario
        Intent i = new Intent(this, AbecedarioActivity.class);
        startActivity(i);
    }
    public void activity_matematicas(View view){
        getMensajeProximamente();
    }
    public void activity_animales(View view){
        getMensajeProximamente();
    }
    public void activity_dibujo(View view){
        getMensajeProximamente();
    }

    public void getMensajeProximamente(){
        Toast.makeText(this,"Proximamente...",Toast.LENGTH_SHORT).show();
    }
}