package com.example.proyectodante;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private TextView tv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String nombre = getIntent().getStringExtra("usuario");
        tv1 = findViewById(R.id.txt_welcome);
        if (!nombre.equals("invitado")) {
            tv1.setText("Bienvenido " + nombre + "!");
        }
    }

    public void activity_abecedario(View view) {
        //activity Abecedario
        Intent i = new Intent(this, AbecedarioActivity.class);
        startActivity(i);
    }

    public void activity_matematicas(View view) {
        Intent i = new Intent(this, MathActivity.class);
        startActivity(i);
    }

    public void activity_animales(View view) {
        getMensajeProximamente();
    }

    public void activity_dibujo(View view) {
        getMensajeProximamente();
    }

    public void getMensajeProximamente() {
        Toast.makeText(this, "Proximamente...", Toast.LENGTH_SHORT).show();
    }
}