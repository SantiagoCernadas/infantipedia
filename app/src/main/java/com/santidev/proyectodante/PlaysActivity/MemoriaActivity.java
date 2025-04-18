package com.santidev.proyectodante.PlaysActivity;

import static com.santidev.proyectodante.MainActivity.pause;
import static com.santidev.proyectodante.MainActivity.start;
import static com.santidev.proyectodante.MainActivity.volumenEfecto;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.widget.ImageViewCompat;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.santidev.proyectodante.Manager.PalabraPlayManager;
import com.santidev.proyectodante.R;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class MemoriaActivity extends AppCompatActivity {
    private int puntos,cantCartas,cantFilas, aciertos;
    private long segundos;
    private TextView txtPuntos,txtTiempo;
    private CountDownTimer countDownTimer,inicio;
    private boolean botonesDisponibles,partidaIniciada;
    private ImageButton[] cartas;
    private int[] idImagenes;
    private int[] idImagenesProblema;
    private SoundPool[] sp;
    private int[] sonidosRep;
    private int[] posCartasSeleccionadas;


    private TableLayout tabla;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String dif = getIntent().getStringExtra("dificultad");

        idImagenes = PalabraPlayManager.setImagenes();
        botonesDisponibles = false;
        partidaIniciada = false;
        aciertos = 0;


        if(dif.equals("Facil")){
            setContentView(R.layout.activity_memoria);
            cantCartas = 6;
            cartas = new ImageButton[cantCartas];
            cantFilas = 2;
            setIdFacil();
        }
        else if(dif.equals("Medio")){
            setContentView(R.layout.activity_memoria_medio);
            cantCartas = 12;
            cantFilas = 3;
            cartas = new ImageButton[cantCartas];
            setIdNormal();
        }
        else{
            setContentView(R.layout.activity_memoria_dificil);
            cantCartas = 20;
            cantFilas = 4;
            cartas = new ImageButton[cantCartas];
            setIdDificil();
        }

        puntos=0;
        idImagenesProblema = new int[cantCartas];
        txtTiempo = findViewById(R.id.txt_memoria_temporizador);
        tabla = findViewById(R.id.memoria_tabla);
        txtPuntos = findViewById(R.id.txt_memoria_puntos);
        posCartasSeleccionadas = new int[]{-1,-1};

        asignarSonidos();
        ocultarCartas();


        Handler handler = new Handler();
        handler. postDelayed(new Runnable() {
            public void run() {
                dimensionarCartas();
                getPartidaMemoria();
            }
        }, 100);

    }

    public void asignarSonidos() {
        sp = new SoundPool[5];
        sonidosRep = new int[5];

        for(int i = 0;i < sp.length;i++){
            sp[i] = new SoundPool(1, AudioManager.STREAM_MUSIC,1);
        }
        sonidosRep[0] = sp[0].load(this,R.raw.sonidocorrecto,1);
        sonidosRep[1] = sp[1].load(this,R.raw.sonidofallar,1);
        sonidosRep[2] = sp[2].load(this,R.raw.tatetiding,1);
        sonidosRep[3] = sp[3].load(this,R.raw.sonidocuentaregresiva,1);
        sonidosRep[4] = sp[4].load(this,R.raw.sonidocuentaregresiva2,1);
    }
    public void generarSonido(int i){
        sp[i].play(sonidosRep[i],volumenEfecto / 20f,volumenEfecto / 20f,1,0,1);
    }

    private void dimensionarCartas() {
        for(int i = 0;i < cartas.length;i++){
            cartas[i].getLayoutParams().height = (tabla.getHeight()/cantFilas)-5;
        }

    }

    private void mostrarCartas() {
        for(int i = 0;i < cartas.length;i++){
            cartas[i].setImageResource(idImagenesProblema[i]);
            cartas[i].setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#77dd77")));
        }

    }

    private void getPartidaMemoria() {


        for(int i = 0; i < idImagenesProblema.length/2 ;i++){
            int randomAux;
                do{
                    randomAux = idImagenes[(int)(Math.random()*idImagenes.length+0)];
                    idImagenesProblema[i] = randomAux;
                }while (esRepetido(idImagenesProblema[i],i));
            idImagenesProblema[i+idImagenesProblema.length/2] = randomAux;
        }

        //Desordenar la array
        Random r = new Random();
        for (int i=0; i<idImagenesProblema.length; i++) {
            int posAleatoria = r.nextInt(idImagenesProblema.length);
            int temp = idImagenesProblema[i];
            idImagenesProblema[i] = idImagenesProblema[posAleatoria];
            idImagenesProblema[posAleatoria] = temp;
        }

        mostrarCartas();
        habilitarCartas();
        iniciarRonda(4);
    }

    private void habilitarCartas() {
        for(int i = 0;i < cartas.length;i++){
            cartas[i].setEnabled(true);
        }
    }

    private void iniciarRonda(int tiempo) {
        Handler handler = new Handler();
        handler. postDelayed(new Runnable() {
            public void run() {
                generarSonido(3);
            }
        }, 1000);

        handler. postDelayed(new Runnable() {
            public void run() {
                generarSonido(3);
            }
        }, 2000);

        handler. postDelayed(new Runnable() {
            public void run() {
                generarSonido(3);
            }
        }, 3000);

        handler. postDelayed(new Runnable() {
            public void run() {
                generarSonido(4);
            }
        }, 4000);


        inicio = new CountDownTimer(tiempo * 1000,1000){

            public void onTick(long millisUntilFinished) {
                segundos = (millisUntilFinished /1000);
                txtTiempo.setTextColor(Color.GREEN);
                txtTiempo.setText(String.valueOf(segundos));
            }

            public void onFinish() {
                cuentaRegresiva(30);
                ocultarCartas();
                botonesDisponibles = true;
            }
        }.start();
    }

    private void ocultarCartas() {
        for(int i = 0;i < cartas.length;i++){
            cartas[i].setImageResource(R.drawable.signospregunta);
            cartas[i].setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#895129")));
        }
    }

    private boolean esRepetido(int id,int posAct) {
        for(int i = 0; i < idImagenesProblema.length;i++){
            if(id == idImagenesProblema[i] && i != posAct){
                return true;
            }
        }
        return false;
    }

    public void teclaPresionada(View view){
        if(botonesDisponibles){
            //77dd77
            //.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#77dd77")));

            int cartaPresionada = buscarCarta(cartas,view.getId());
            if(posCartasSeleccionadas[0] == -1){
                posCartasSeleccionadas[0] = cartaPresionada;
                cartas[cartaPresionada].setImageResource(idImagenesProblema[cartaPresionada]);
                cartas[cartaPresionada].setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#77dd77")));
                generarSonido(2);
            }
            else if(posCartasSeleccionadas[0] == cartaPresionada){
                cartas[cartaPresionada].setImageResource(R.drawable.signospregunta);
                posCartasSeleccionadas[0] = -1;
                cartas[cartaPresionada].setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#895129")));
            }
            else{
                botonesDisponibles = false;
                posCartasSeleccionadas[1] = cartaPresionada;
                cartas[cartaPresionada].setImageResource(idImagenesProblema[cartaPresionada]);
                cartas[cartaPresionada].setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#77dd77")));
                generarSonido(2);
                if(idImagenesProblema[posCartasSeleccionadas[0]] == idImagenesProblema[posCartasSeleccionadas[1]]){
                    puntos++;
                    txtPuntos.setText("Puntos = " + puntos);
                    generarSonido(0);
                    cartas[posCartasSeleccionadas[0]].setEnabled(false);
                    cartas[posCartasSeleccionadas[1]].setEnabled(false);
                    posCartasSeleccionadas[0] = -1;
                    posCartasSeleccionadas[1] = -1;
                    aciertos++;
                    botonesDisponibles = true;
                    if(aciertos == cantCartas/2){
                        aciertos = 0;
                        botonesDisponibles = false;
                        countDownTimer.cancel();
                        getPartidaMemoria();
                    }
                }
                else{
                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        public void run() {
                            generarSonido(1);
                            cartas[posCartasSeleccionadas[0]].setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#ff6961")));
                            cartas[posCartasSeleccionadas[1]].setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#ff6961")));
                        }

                    }, 500);

                    handler.postDelayed(new Runnable() {
                        public void run() {
                            cartas[posCartasSeleccionadas[0]].setImageResource(R.drawable.signospregunta);
                            cartas[posCartasSeleccionadas[1]].setImageResource(R.drawable.signospregunta);
                            cartas[posCartasSeleccionadas[0]].setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#895129")));
                            cartas[posCartasSeleccionadas[1]].setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#895129")));
                            posCartasSeleccionadas[0] = -1;
                            posCartasSeleccionadas[1] = -1;
                            botonesDisponibles = true;
                        }
                    }, 1500);
                }

            }
        }
    }

    private int buscarCarta(ImageButton[] cartas,int id) {
        for(int i = 0;i < cartas.length;i++){
            if(cartas[i].getId() == id){
                return i;
            }
        }
        return -1;
    }

    private void setIdDificil() {
        //20 cartas
        cartas[0] = findViewById(R.id.memoria_dificil_carta_1);
        cartas[1] = findViewById(R.id.memoria_dificil_carta_2);
        cartas[2] = findViewById(R.id.memoria_dificil_carta_3);
        cartas[3] = findViewById(R.id.memoria_dificil_carta_4);
        cartas[4] = findViewById(R.id.memoria_dificil_carta_5);
        cartas[5] = findViewById(R.id.memoria_dificil_carta_6);
        cartas[6] = findViewById(R.id.memoria_dificil_carta_7);
        cartas[7] = findViewById(R.id.memoria_dificil_carta_8);
        cartas[8] = findViewById(R.id.memoria_dificil_carta_9);
        cartas[9] = findViewById(R.id.memoria_dificil_carta_10);
        cartas[10] = findViewById(R.id.memoria_dificil_carta_11);
        cartas[11] = findViewById(R.id.memoria_dificil_carta_12);
        cartas[12] = findViewById(R.id.memoria_dificil_carta_13);
        cartas[13] = findViewById(R.id.memoria_dificil_carta_14);
        cartas[14] = findViewById(R.id.memoria_dificil_carta_15);
        cartas[15] = findViewById(R.id.memoria_dificil_carta_16);
        cartas[16] = findViewById(R.id.memoria_dificil_carta_17);
        cartas[17] = findViewById(R.id.memoria_dificil_carta_18);
        cartas[18] = findViewById(R.id.memoria_dificil_carta_19);
        cartas[19] = findViewById(R.id.memoria_dificil_carta_20);
    }

    private void setIdNormal() {
        //12 cartas
        cartas[0] = findViewById(R.id.memoria_medio_carta_1);
        cartas[1] = findViewById(R.id.memoria_medio_carta_2);
        cartas[2] = findViewById(R.id.memoria_medio_carta_3);
        cartas[3] = findViewById(R.id.memoria_medio_carta_4);
        cartas[4] = findViewById(R.id.memoria_medio_carta_5);
        cartas[5] = findViewById(R.id.memoria_medio_carta_6);
        cartas[6] = findViewById(R.id.memoria_medio_carta_7);
        cartas[7] = findViewById(R.id.memoria_medio_carta_8);
        cartas[8] = findViewById(R.id.memoria_medio_carta_9);
        cartas[9] = findViewById(R.id.memoria_medio_carta_10);
        cartas[10] = findViewById(R.id.memoria_medio_carta_11);
        cartas[11] = findViewById(R.id.memoria_medio_carta_12);
    }

    private void setIdFacil() {
        //6 cartas
        cartas[0] = findViewById(R.id.memoria_carta_1);
        cartas[1] = findViewById(R.id.memoria_carta_2);
        cartas[2] = findViewById(R.id.memoria_carta_3);
        cartas[3] = findViewById(R.id.memoria_carta_4);
        cartas[4] = findViewById(R.id.memoria_carta_5);
        cartas[5] = findViewById(R.id.memoria_carta_6);
    }



    private void cuentaRegresiva(long tiempo){
        partidaIniciada = true;
        countDownTimer = new CountDownTimer(tiempo * 1000,1000){

            public void onTick(long millisUntilFinished) {
                segundos = (millisUntilFinished /1000);
                if(segundos >= 20 ){
                    txtTiempo.setTextColor(Color.GREEN);
                }
                else if(segundos >= 10){
                    txtTiempo.setTextColor(Color.YELLOW);
                }
                else{
                    txtTiempo.setTextColor(Color.RED);
                }
                txtTiempo.setText(String.valueOf(segundos));
            }

            public void onFinish() {
                txtTiempo.setText("Se acabo el tiempo");
                botonesDisponibles = false;
                Handler handler = new Handler();
                handler. postDelayed(new Runnable() {
                    public void run() {
                        Intent salir = new Intent(MemoriaActivity.this,FinJuegoActivity.class);
                        salir.putExtra("puntos",puntos);
                        startActivity(salir);
                        finish();
                    }
                }, 1500);
            }
        }.start();
    }

    @Override
    public void onBackPressed() {
        AlertDialog.Builder alerta = new AlertDialog.Builder(MemoriaActivity.this);
        alerta.setMessage("Perderás todo tu progreso");
        alerta.setCancelable(true);
        alerta.setPositiveButton("Salir", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Intent salir = new Intent(MemoriaActivity.this,FinJuegoActivity.class);
                salir.putExtra("puntos", puntos);
                inicio.cancel();
                if(partidaIniciada){
                    countDownTimer.cancel();
                }

                startActivity(salir);
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