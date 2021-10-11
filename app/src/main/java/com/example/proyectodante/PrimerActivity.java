package com.example.proyectodante;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class PrimerActivity extends AppCompatActivity {
    private EditText et1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_primer);
        et1 = findViewById(R.id.txt_nombreUser);
    }

    public void logUsuario(View view){
        String nombre = et1.getText().toString();
        if(nombre.equals("")){
            Toast.makeText(this,"Porfavor ingrese un nombre.",Toast.LENGTH_SHORT).show();
        }
        else{
            iniciarAPP(nombre);
        }
    }

    public void logInvitado(View view){
        String nombre = "";
        iniciarAPP(nombre);
    }

    public void iniciarAPP(String nombre){
        Intent i = new Intent(this,MainActivity.class);
        i.putExtra("usuario",nombre);
        startActivity(i);
        finish();
    }
}