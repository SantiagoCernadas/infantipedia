package com.santidev.proyectodante.PlaysActivity;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.graphics.Color;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.santidev.proyectodante.MainActivity;
import com.santidev.proyectodante.Manager.StatsJugadorTatetiDos;
import com.santidev.proyectodante.R;

import static com.santidev.proyectodante.MainActivity.pause;
import static com.santidev.proyectodante.MainActivity.start;

public class TatetiActivityDosJugadores extends AppCompatActivity {
    private int[] tablero;
    private Button[] botones;
    private StatsJugadorTatetiDos[] jugadores;
    private TextView txtMsgGanador;
    private Button botonSalir,botonVolver;
    private int casillerosUsados;
    private int condicionVictoria;
    private boolean botonesDips;
    private String nombre;
    private SoundPool sp;
    private int spRep;
    private int turnoJugador,comienzojugador;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tateti);
        tablero = new int[]{
                0,0,0,
                0,0,0,
                0,0,0
        };
        nombre = MainActivity.getNombre();
        if(nombre.equals("")){
            nombre = "jugador";
        }
        comienzojugador = 0;
        turnoJugador = comienzojugador;
        botones = new Button[9];
        sp = new SoundPool(1, AudioManager.STREAM_MUSIC,1);
        spRep = sp.load(this,R.raw.tatetiding,1);
        jugadores = new StatsJugadorTatetiDos[2];
        setJugadores();
        txtMsgGanador = findViewById(R.id.txt_msg_ganador_tateti);
        botonVolver = findViewById(R.id.ttt_volver_jugar);
        botonSalir = findViewById(R.id.ttt_salir);
        estadoBotones(View.INVISIBLE);
        casillerosUsados = 0;
        condicionVictoria = 5;
        botonesDips = true;
        setBotones();
        limpiarPantalla();
        actualizarDatos();
        imprimirTurnoJugador(comienzojugador);

    }

    public void imprimirTurnoJugador(int i){
        if(jugadores[i].getNombre().equals("jugador")){
            txtMsgGanador.setText("Turno de el jugador ");
        }
        else{
            txtMsgGanador.setText("Turno de " + jugadores[i].getNombre()+ " ");
        }
        txtMsgGanador.setTextColor(Color.parseColor(jugadores[i].getStringColor()));
    }
    public void imprimirPuntoJugador(int i){
        if(jugadores[i].getNombre().equals("jugador")){
            txtMsgGanador.setText("Punto para el jugador! ");
        }
        else{
            txtMsgGanador.setText("Punto para " + jugadores[i].getNombre() + "! ");
        }
        txtMsgGanador.setTextColor(Color.parseColor(jugadores[i].getStringColor()));
    }
    public void imprimirGanadorJugador(int i){
        if(jugadores[i].getNombre().equals("jugador")){
            txtMsgGanador.setText("Ganó el jugador! ");
        }
        else{
            txtMsgGanador.setText("Ganó " + jugadores[i].getNombre()+ "! ");
        }
        txtMsgGanador.setTextColor(Color.parseColor(jugadores[i].getStringColor()));
    }


    public void setJugadores() {
        jugadores[0] = new StatsJugadorTatetiDos(findViewById(R.id.txt_puntos_jugador_tateti),"X","#F8A69A",1,3,nombre);
        jugadores[1] = new StatsJugadorTatetiDos(findViewById(R.id.txt_puntos_cpu_tateti),"O","#9FADEE",-1,-3,"el jugador 2");
    }

    private void setBotones() {
        botones[0] = findViewById(R.id.tateti_boton_1);
        botones[1] = findViewById(R.id.tateti_boton_2);
        botones[2] = findViewById(R.id.tateti_boton_3);
        botones[3] = findViewById(R.id.tateti_boton_4);
        botones[4] = findViewById(R.id.tateti_boton_5);
        botones[5] = findViewById(R.id.tateti_boton_6);
        botones[6] = findViewById(R.id.tateti_boton_7);
        botones[7] = findViewById(R.id.tateti_boton_8);
        botones[8] = findViewById(R.id.tateti_boton_9);
    }

    private void actualizarDatos() {
        jugadores[0].getPuntosMsg().setText(jugadores[0].getNombre() + ": " + jugadores[0].getPuntos() + "/" + condicionVictoria + " ");
        jugadores[1].getPuntosMsg().setText("Jugador 2: "+ jugadores[1].getPuntos() + "/" + condicionVictoria + " ");
    }

    public void limpiarPantalla(){
        for(int i = 0;i < 9;i++){
            botones[i].setText("");
            botones[i].setTextColor(Color.BLACK);
            tablero[i] = 0;
        }
        txtMsgGanador.setText("");
        casillerosUsados = 0;
    }

    public void setCasilleroJugador(View view){
        if(botonesDips){
            int opcion = 0;

            switch (view.getId()){
                case R.id.tateti_boton_1:
                    opcion = 1;
                    break;
                case R.id.tateti_boton_2:
                    opcion = 2;
                    break;
                case R.id.tateti_boton_3:
                    opcion = 3;
                    break;
                case R.id.tateti_boton_4:
                    opcion = 4;
                    break;
                case R.id.tateti_boton_5:
                    opcion = 5;
                    break;
                case R.id.tateti_boton_6:
                    opcion = 6;
                    break;
                case R.id.tateti_boton_7:
                    opcion = 7;
                    break;
                case R.id.tateti_boton_8:
                    opcion = 8;
                    break;
                case R.id.tateti_boton_9:
                    opcion = 9;
                    break;
            }

            if(esLibre(opcion-1)){
                int linea = jugadores[turnoJugador].getLinea();
                int tablero = jugadores[turnoJugador].getTableroJugador();
                String color = jugadores[turnoJugador].getStringColor();
                String signo = jugadores[turnoJugador].getSigno();
                String nombreAct = jugadores[turnoJugador].getNombre();
                sp.play(spRep,1,1,1,0,1);
                setCasillero(opcion-1,signo,tablero,color);
                casillerosUsados++;


                if(verificarGanador(linea,tablero)){
                    imprimirPuntoJugador(turnoJugador);
                    jugadores[turnoJugador].setPuntos(jugadores[turnoJugador].getPuntos() + 1);
                    actualizarDatos();
                    botonesDips = false;

                    if(jugadores[turnoJugador].getPuntos() == condicionVictoria){
                        imprimirGanadorJugador(turnoJugador);
                        estadoBotones(View.VISIBLE);
                    }
                    else{
                        Handler handler = new Handler();
                        handler. postDelayed(new Runnable() {
                            public void run() {
                                if (comienzojugador == 0){
                                    comienzojugador = 1;
                                }
                                else{
                                    comienzojugador = 0;
                                }
                                turnoJugador = comienzojugador;
                                limpiarPantalla();
                                imprimirTurnoJugador(comienzojugador);
                                botonesDips = true;
                            }
                        }, 2000);
                    }
                }
                else if(casillerosUsados == 9){
                    txtMsgGanador.setText("Empate");
                    Handler handler = new Handler();
                    handler. postDelayed(new Runnable() {
                        public void run() {
                            if (comienzojugador == 0){
                                comienzojugador = 1;
                            }
                            else{
                                comienzojugador = 0;
                            }
                            turnoJugador = comienzojugador;
                            limpiarPantalla();
                            imprimirTurnoJugador(comienzojugador);
                            botonesDips = true;
                        }
                    }, 2000);
                }
                else{
                    if (turnoJugador == 0){
                        turnoJugador = 1;
                    }
                    else{
                        turnoJugador = 0;
                    }
                    imprimirTurnoJugador(turnoJugador);
                }
            }

        }
    }

    public boolean verificarGanador(int linea,int numJugador) {

        if(lineaHorizontal(0,3,numJugador,linea)){
            return true;
        }
        else if(lineaHorizontal(3,6,numJugador,linea)){
            return true;
        }
        else if(lineaHorizontal(6,9,numJugador,linea)){
            return true;
        }
        else if(lineaVertical(0,7,numJugador,linea)){
            return true;
        }
        else if(lineaVertical(1,8,numJugador,linea)){
            return true;
        }
        else if(lineaVertical(2,9,numJugador,linea)){
            return true;
        }
        else if(lineaDiagonal1(0,9,numJugador,linea)){
            return true;
        }
        else if(lineaDiagonal2(6,1,numJugador,linea)){
            return true;
        }

        return false;
    }



    public boolean lineaDiagonal2(int inicio, int fin, int numJugador, int linea) {
        Button[] botonesColor = new Button[3];
        int j = 0;
        int cant = 0;
        for(int i = inicio; i > fin; i -= 2){
            if(tablero[i] == numJugador){
                cant += numJugador;
                botonesColor[j] = botones[i];
                j++;
            }
        }
        if(cant == linea){
            for(int i = 0;i < 3;i++){
                botonesColor[i].setTextColor(Color.parseColor("#BAF5A9"));
            }
            return true;
        }
        return false;
    }

    public boolean lineaDiagonal1(int inicio, int fin, int numJugador, int linea) {
        Button[] botonesColor = new Button[3];
        int j = 0;
        int cant = 0;
        for(int i = inicio; i < fin; i += 4){
            if(tablero[i] == numJugador){
                cant += numJugador;
                botonesColor[j] = botones[i];
                j++;
            }
        }
        if(cant == linea){
            for(int i = 0;i < 3;i++){
                botonesColor[i].setTextColor(Color.parseColor("#BAF5A9"));
            }
            return true;
        }
        return false;
    }

    public boolean lineaVertical(int inicio, int fin, int numJugador, int linea) {
        Button[] botonesColor = new Button[3];
        int j = 0;
        int cant = 0;
        for(int i = inicio; i < fin; i += 3){
            if(tablero[i] == numJugador){
                cant += numJugador;
                botonesColor[j] = botones[i];
                j++;
            }
        }
        if(cant == linea){
            for(int i = 0;i < 3;i++){
                botonesColor[i].setTextColor(Color.parseColor("#BAF5A9"));
            }
            return true;
        }
        return false;
    }

    public boolean lineaHorizontal(int inicio,int fin,int numJugador,int linea){
        Button[] botonesColor = new Button[3];
        int j = 0;
        int cant = 0;
        for(int i = inicio; i < fin; i++){
            if(tablero[i] == numJugador){
                cant += numJugador;
                botonesColor[j] = botones[i];
                j++;
            }
        }
        if(cant == linea){
            for(int i = 0;i < 3;i++){
                botonesColor[i].setTextColor(Color.parseColor("#BAF5A9"));
            }
            return true;
        }
        return false;
    }


    public boolean esLibre(int i) {
        return tablero[i] == 0;
    }

    public void setCasillero(int i,String signo,int tableroJugador,String color){
        botones[i].setText(signo);
        tablero[i] = tableroJugador;
        botones[i].setTextColor(Color.parseColor(color));
    }

    public void salirTTT(View view){
        finish();
    }
    public void volverTTT(View view){
        jugadores[0].setPuntos(0);
        jugadores[1].setPuntos(0);
        limpiarPantalla();
        actualizarDatos();
        botonesDips = true;
        comienzojugador = 0;
        turnoJugador = comienzojugador;
        txtMsgGanador.setText("Turno de " + jugadores[comienzojugador].getNombre());
        estadoBotones(View.INVISIBLE);
    }
    private void estadoBotones(int estado) {
        botonSalir.setVisibility(estado);
        botonVolver.setVisibility(estado);
    }
    @Override
    public void onBackPressed() {
        AlertDialog.Builder alerta = new AlertDialog.Builder(TatetiActivityDosJugadores.this);
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