package com.example.proyectodante;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.proyectodante.Manager.PalabraPlayManager;

public class PalabraPlayActivity extends AppCompatActivity {
    private final int NUM_PALABRAS = 81;

    private Button[] opciones;
    private ImageView imagen;
    private String palabraCorrecta;

    private String[] palabras;
    private int[] idImagen;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_palabra_play);
        PalabraPlayManager manager = new PalabraPlayManager();

        opciones = new Button[4];
        palabras = new String[NUM_PALABRAS];
        idImagen = new int[NUM_PALABRAS];
        conectarID();
        manager.setImagenes(idImagen);
        manager.setPalabras(palabras);
        generarProblema();
    }

    public void opcionPresionada(View view){
        int id = view.getId();

        switch (id){
            case R.id.button:
                break;
            default:
                Toast.makeText(this,"ERROR",Toast.LENGTH_SHORT).show();
        }
    }

    public void generarProblema(){
        int numcorrecto = (int)(Math.random()*NUM_PALABRAS+0);
        palabraCorrecta = palabras[numcorrecto];
        imagen.setImageResource(idImagen[numcorrecto]);

        int opcCorrecta = (int)(Math.random()*4+0);
        opciones[opcCorrecta].setText(palabraCorrecta);

        for(int i = 0;i < opciones.length;i++){
            if(i != opcCorrecta){
                do{
                    opciones[i].setText(palabras[(int)(Math.random()*NUM_PALABRAS+0)]);
                }while (esRepetido(i));

            }
        }
    }

    public boolean esRepetido(int verificar) {
        boolean repetido = false;

        if(verificar == 0){
            repetido = verificacion(0,1,2,3);
        }
        else if(verificar == 1){
            repetido = verificacion(1,0,2,3);
        }
        else if (verificar == 2){
            repetido = verificacion(2,0,1,3);
        }
        else {
            repetido = verificacion(3,0,1,2);
        }


        return repetido;
    }

    public boolean verificacion(int pVerificar ,int p1,int p2,int p3){
        if(opciones[pVerificar].getText().toString().equals(opciones[p1].getText().toString())){
            return true;
        }
        else if(opciones[pVerificar].getText().toString().equals(opciones[p2].getText().toString())){
            return true;
        }
        else if(opciones[pVerificar].getText().toString().equals(opciones[p3].getText().toString())){
            return true;
        }
        return false;
    }



    public void conectarID(){
        opciones[0] = findViewById(R.id.button_opc1);
        opciones[1] = findViewById(R.id.button_opc2);
        opciones[2] = findViewById(R.id.button_opc3);
        opciones[3] = findViewById(R.id.button_opc4);
        imagen = findViewById(R.id.txt_palabraplay_imagen);
    }

}