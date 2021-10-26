

package com.example.proyectodante.PlaysActivity;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.proyectodante.MainActivity;
import com.example.proyectodante.R;

import static com.example.proyectodante.MainActivity.pause;
import static com.example.proyectodante.MainActivity.start;

public class PptActivity extends AppCompatActivity {
    private boolean botonesDisp;
    private int condicionVictoria;
    private int jugadorOpc,CPUOpc;
    private int puntosJugador,puntosCPU;
    private TextView txtPtsJugador, txtPtsCPU,txtGanadorRonda;
    private ImageView imagenJugador,imagenCPU;
    private Button botonSalir,botonVolver;
    private int[] idImagenes;
    private String nombreJugador;
    private boolean ganador;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        nombreJugador = MainActivity.getNombre();
        if(nombreJugador.equals("")){
            nombreJugador = "Jugador";
        }
        ganador = false;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ppt);
        idImagenes = new int[3];
        setImagenes();
        condicionVictoria = 5;
        txtPtsJugador = findViewById(R.id.txt_puntos_jugador);
        txtPtsCPU = findViewById(R.id.txt_puntos_cpu);
        txtGanadorRonda = findViewById(R.id.txt_ganador_ronda);
        imagenJugador = findViewById(R.id.imagen_jugador);
        imagenCPU = findViewById(R.id.imagen_cpu);
        botonSalir = findViewById(R.id.ppt_salir);
        botonVolver = findViewById(R.id.ppt_volver_jugar);
        puntosJugador = 0;
        puntosCPU = 0;
        botonesDisp = true;
        txtGanadorRonda.setText("presiona una opción para comenzar! ");
        estadoImagenes(View.INVISIBLE);
        estadoBotones(View.INVISIBLE);
        actualizarDatos();
    }

    private void estadoImagenes(int estado) {
        imagenJugador.setVisibility(estado);
        imagenCPU.setVisibility(estado);
    }

    private void estadoBotones(int estado) {
        botonSalir.setVisibility(estado);
        botonVolver.setVisibility(estado);
    }


    public void opcion(View view){
        if(botonesDisp){
            switch (view.getId()){
                case R.id.imagen_tijera:
                    jugadorOpc = 0;
                    break;
                case R.id.imagen_papel:
                    jugadorOpc = 1;
                    break;
                case R.id.imagen_piedra:
                    jugadorOpc = 2;
                    break;
            }
            CPUOpc = (int)(Math.random()*3+0);
            imagenJugador.setImageResource(idImagenes[jugadorOpc]);
            imagenCPU.setImageResource(idImagenes[CPUOpc]);
            estadoImagenes(View.VISIBLE);
            ganador();
            actualizarDatos();
            botonesDisp = false;
            if(!ganador){
                limpiarPantalla();
            }
            else{
                estadoBotones(View.VISIBLE);
            }
        }
    }

    public void salirppt(View view){
        finish();
    }

    public void volverAJugar(View view){
        txtGanadorRonda.setText("");
        botonesDisp = true;
        estadoImagenes(View.INVISIBLE);
        estadoBotones(View.INVISIBLE);
        puntosJugador = 0;
        puntosCPU = 0;
        ganador = false;
    }

    public void limpiarPantalla(){
        Handler handler = new Handler();
        handler. postDelayed(new Runnable() {
            public void run() {
                txtGanadorRonda.setText("");
                botonesDisp = true;
                estadoImagenes(View.INVISIBLE);
            }
        }, 2000);
    }

    public void ganador() {
        if(jugadorOpc == CPUOpc){
            txtGanadorRonda.setText("Empate ");
        }
        else if(ganadorJugador()){
            puntosJugador++;
            if(puntosJugador == condicionVictoria){
                if(nombreJugador.equals("Jugador")){
                    txtGanadorRonda.setText("Gano el jugador! ");
                }
                else{
                    txtGanadorRonda.setText("Ganó " + nombreJugador + "! ");
                }
                ganador = true;
            }
            else{
                if(nombreJugador.equals("Jugador")){
                    txtGanadorRonda.setText("Punto para el jugador! ");
                }
                else{
                    txtGanadorRonda.setText("Punto para " + nombreJugador + "! ");
                }
            }
        }
        else{
            puntosCPU++;
            if(puntosCPU == condicionVictoria){
                txtGanadorRonda.setText("Ganó Duxi! ");
                ganador = true;
            }
            else{
                txtGanadorRonda.setText("Punto para Duxi! ");
            }

        }
    }

    public boolean ganadorJugador() {
        return (jugadorOpc == 0 && CPUOpc == 1) || (jugadorOpc == 1 && CPUOpc == 2) || (jugadorOpc == 2 && CPUOpc == 0);
    }


    public void actualizarDatos() {
        txtPtsJugador.setText(nombreJugador+": " + puntosJugador + "/" + condicionVictoria + " ");
        txtPtsCPU.setText("Duxi: " + puntosCPU + "/" + condicionVictoria + " ");
    }

    public void setImagenes() {
        idImagenes[0] = R.drawable.tijera;
        idImagenes[1] = R.drawable.papel;
        idImagenes[2] = R.drawable.piedra;
    }



    @Override
    public void onBackPressed() {
        AlertDialog.Builder alerta = new AlertDialog.Builder(PptActivity.this);
        alerta.setMessage("Perderás todo tu progreso");
        alerta.setCancelable(true);
        alerta.setPositiveButton("Salir", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                finish();
            }

        });
        alerta.setNegativeButton("Continuar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        });
        AlertDialog titulo = alerta.create();
        titulo.setTitle("¿Deseas salir?");
        titulo.show();
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