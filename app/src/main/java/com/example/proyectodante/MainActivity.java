package com.example.proyectodante;

import androidx.appcompat.app.AppCompatActivity;

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
        Toast.makeText(this,"Entrando en abecedario...",Toast.LENGTH_SHORT).show();
    }
    public void activity_matematicas(View view){
        Toast.makeText(this,"Entrando en matematicas...",Toast.LENGTH_SHORT).show();
    }
    public void activity_animales(View view){
        Toast.makeText(this,"Entrando en animales...",Toast.LENGTH_SHORT).show();
    }
    public void activity_dibujo(View view){
        Toast.makeText(this,"Entrando en dibujo...",Toast.LENGTH_SHORT).show();
    }
}