package com.example.proyectodante.PlaysActivity;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.proyectodante.MainActivity;
import com.example.proyectodante.Manager.StatsJugadorPpt;
import com.example.proyectodante.R;

import static com.example.proyectodante.MainActivity.pause;
import static com.example.proyectodante.MainActivity.start;

public class PptActivityDosJugadores extends AppCompatActivity {
    private boolean botonesDisp;
    private boolean ganador;
    private Button botonSalir,botonVolver,botonComenzar;
    private StatsJugadorPpt jugador1,jugador2;
    private TextView txMsgJugador1,txMsgJugador2,cuentaRegresiva;
    private int condicionVictoria = 5;
    private int[] idImagenes;
    private SoundPool[] sp;
    private int[] spRep;
    private String nombre;
    private boolean cerrado;
    private boolean jugador1bloq,jugador2bloq;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ppt_dos_jugadores);
        cerrado = false;
        jugador1 = establecerJugador(R.id.imagen_jugador_1,R.id.txt_puntos_jugador_1);
        jugador2 = establecerJugador(R.id.imagen_jugador_2,R.id.txt_puntos_jugador_2);
        txMsgJugador1 = findViewById(R.id.txt_mensaje_jugador_1);
        txMsgJugador2 = findViewById(R.id.txt_mensaje_jugador_2);
        cuentaRegresiva = findViewById(R.id.txt_cuenta_regresiva);
        botonComenzar = findViewById(R.id.boton_ppt_siguiente);
        sp = new SoundPool[2];
        spRep = new int[2];
        setSonidos(sp,spRep);
        botonSalir = findViewById(R.id.ppt_salir_2);
        botonVolver = findViewById(R.id.ppt_volver_jugar_2);
        nombre = MainActivity.getNombre();
        if(nombre.equals("")){
            nombre = "Jugador";
        }
        txMsgJugador1.setText("Buena Suerte!");
        txMsgJugador2.setText("Buena Suerte!");
        estadoBotones(View.INVISIBLE);
        estadoImagenes(View.INVISIBLE);
        actualizarDatos2();
        botonesDisp = false;
        idImagenes = new int[3];
        setImagenes();
    }

    public void comenzarRonda(View view){
        if(botonComenzar.getText().toString().equals("Comenzar")){
            botonComenzar.setText("Siguiente");
        }
        botonComenzar.setVisibility(View.INVISIBLE);
        estadoImagenes(View.INVISIBLE);
        txMsgJugador1.setText("");
        txMsgJugador2.setText("");
        jugador1.setOpcion(-1);
        jugador2.setOpcion(-1);
        iniciarCuentaRegresiva();
    }

    public void setSonidos(SoundPool[] sp, int[] spRep) {
        for(int i = 0;i < 2;i++){
            sp[i] = new SoundPool(1, AudioManager.STREAM_MUSIC,1);
        }
        spRep[0] = sp[0].load(this,R.raw.sonidocuentaregresiva,1);
        spRep[1] = sp[1].load(this,R.raw.sonidocuentaregresiva2,1);

    }

    public void repSonido(int i){
        if(!cerrado){
            sp[i].play(spRep[i],1,1,1,0,1);
        }
    }

    public void iniciarCuentaRegresiva() {
        cuentaRegresiva.setText("Piedra..");
        repSonido(0);
        Handler handler = new Handler();
        handler. postDelayed(new Runnable() {
            public void run() {
                cuentaRegresiva.setText("Papel..");
                repSonido(0);
            }
            }, 1000);

        handler. postDelayed(new Runnable() {
            public void run() {
                cuentaRegresiva.setText("Tijera!");
                repSonido(1);
                botonesDisp = true;
                }
            }, 2000);

        handler. postDelayed(new Runnable() {
            public void run() {
                botonesDisp = false;
                jugador1bloq = false;
                jugador2bloq = false;
                ganador();
                }
            }, 2750);

    }

    public void ganador() {
        if(jugador1.getOpcion() == -1 && jugador2.getOpcion() == -1){
            txMsgJugador1.setText("Tienes que ser mas rapido!");
            txMsgJugador2.setText("Tienes que ser mas rapido!");
        }
        else if(jugador1.getOpcion() == -1){
            jugador2.setPuntos(jugador2.getPuntos()+1);
            txMsgJugador1.setText("Tienes que ser mas rapido!");
            txMsgJugador2.setText("Punto para ti!");
        }
        else if(jugador2.getOpcion() == -1){
            jugador1.setPuntos(jugador1.getPuntos()+1);
            txMsgJugador2.setText("Tienes que ser mas rapido!");
            txMsgJugador1.setText("Punto para ti!");
        }
        else if(jugador1.getOpcion() == jugador2.getOpcion()){
            txMsgJugador1.setText("Empate");
            txMsgJugador2.setText("Empate");
        }
        else if(ganadorJugador1()){
            jugador1.setPuntos(jugador1.getPuntos()+1);
            txMsgJugador1.setText("Punto para ti!");
            txMsgJugador2.setText("Punto para el rival");
        }
        else{
            jugador2.setPuntos(jugador2.getPuntos()+1);
            txMsgJugador2.setText("Punto para ti!");
            txMsgJugador1.setText("Punto para el rival");
        }

        if(jugador1.getPuntos() == condicionVictoria){
            txMsgJugador1.setText("Ganaste!");
            txMsgJugador2.setText("Perdiste");
            ganador = true;
        }
        else if(jugador2.getPuntos() == condicionVictoria){
            txMsgJugador2.setText("Ganaste!");
            txMsgJugador1.setText("Perdiste");
            ganador = true;
        }

        actualizarDatos2();
        if(ganador){
            estadoBotones(View.VISIBLE);
        }
        else {
            cuentaRegresiva.setText("");
            botonComenzar.setVisibility(View.VISIBLE);
        }
    }


    public boolean ganadorJugador1(){
        return (jugador1.getOpcion() == 0 && jugador2.getOpcion() == 1) || (jugador1.getOpcion() == 1 && jugador2.getOpcion() == 2) || (jugador1.getOpcion() == 2 && jugador2.getOpcion() == 0);
    }

    public void actualizarDatos2() {
        jugador1.getTexto().setText(nombre + ": " +jugador1.getPuntos() + "/" + condicionVictoria + " ");
        jugador2.getTexto().setText("Jugador 2: " + jugador2.getPuntos() + "/" + condicionVictoria + " ");
    }

    public void volverAJugar(View view){
        ganador = false;
        estadoBotones(View.INVISIBLE);
        jugador1.setPuntos(0);
        jugador2.setPuntos(0);
        actualizarDatos2();
        txMsgJugador1.setText("");
        txMsgJugador2.setText("");
        estadoImagenes(View.INVISIBLE);
        iniciarCuentaRegresiva();
        jugador1.setOpcion(-1);
        jugador2.setOpcion(-1);
    }
    public void salirppt(View view){
        finish();
    }

    public StatsJugadorPpt establecerJugador(int idImagen,int idTexto){
        StatsJugadorPpt jugador = new StatsJugadorPpt();
        jugador.setPuntos(0);
        jugador.setOpcion(-1);
        jugador.setImagen(findViewById(idImagen));
        jugador.setTexto(findViewById(idTexto));
        return jugador;
    }
    public void setImagenes() {
        idImagenes[0] = R.drawable.tijera;
        idImagenes[1] = R.drawable.papel;
        idImagenes[2] = R.drawable.piedra;
    }

    private void estadoImagenes(int estado) {
        jugador1.getImagen().setVisibility(estado);
        jugador2.getImagen().setVisibility(estado);
    }

    private void estadoBotones(int estado) {
        botonSalir.setVisibility(estado);
        botonVolver.setVisibility(estado);
    }

    public void presionOpcion1(View view){
        if (botonesDisp && !jugador1bloq){
            switch (view.getId()){
                case R.id.imagen_tijera_jugador_1:
                    jugador1.setOpcion(0);
                    break;
                case R.id.imagen_papel_jugador_1:
                    jugador1.setOpcion(1);
                    break;
                case R.id.imagen_piedra_jugador_1:
                    jugador1.setOpcion(2);
                    break;
            }
            jugador1bloq = true;
            jugador1.getImagen().setImageResource(idImagenes[jugador1.getOpcion()]);
            jugador1.getImagen().setVisibility(View.VISIBLE);
        }
    }

    public void presionOpcion2(View view){
        if(botonesDisp && !jugador2bloq){
            switch (view.getId()){
                case R.id.imagen_tijera_jugador_2:
                    jugador2.setOpcion(0);
                    break;
                case R.id.imagen_papel_jugador_2:
                    jugador2.setOpcion(1);
                    break;
                case R.id.imagen_piedra_jugador_2:
                    jugador2.setOpcion(2);
                    break;
            }
            jugador2bloq = true;
            jugador2.getImagen().setImageResource(idImagenes[jugador2.getOpcion()]);
            jugador2.getImagen().setVisibility(View.VISIBLE);
        }

    }

    @Override
    public void onBackPressed() {
        AlertDialog.Builder alerta = new AlertDialog.Builder(PptActivityDosJugadores.this);
        alerta.setMessage("Perderás todo tu progreso");
        alerta.setCancelable(true);
        alerta.setPositiveButton("Salir", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                cerrado = true;
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

    @Override
    protected void onPause() {
        super.onPause();
        cerrado = true;
        pause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        cerrado = false;
        start();
    }
}