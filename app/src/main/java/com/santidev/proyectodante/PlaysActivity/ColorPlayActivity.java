package com.santidev.proyectodante.PlaysActivity;

import static com.santidev.proyectodante.MainActivity.pause;
import static com.santidev.proyectodante.MainActivity.start;
import static com.santidev.proyectodante.MainActivity.volumenEfecto;
import static com.santidev.proyectodante.Manager.Colores.*;

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
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.santidev.proyectodante.Manager.ColorManagerPlay;
import com.santidev.proyectodante.Manager.Colores;
import com.santidev.proyectodante.Manager.MinijuegoManager;
import com.santidev.proyectodante.R;

public class ColorPlayActivity extends AppCompatActivity {

    private MinijuegoManager minijuegoManager;
    private ColorManagerPlay colorManagerPlay;
    private ImageView imagen;
    private int objActual;
    private Colores colorSelec;
    private Button[] botones;
    private SoundPool[] sp;
    private int[] sonidosRep;
    private boolean botonesDisponibles;
    private TextView txt_titulo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_color_play);

        minijuegoManager = new MinijuegoManager(3,0,3,
                findViewById(R.id.txt_color_vidas),findViewById(R.id.txt_color_puntos),findViewById(R.id.txt_pista_color),
                findViewById(R.id.txt_pista_color_cant),findViewById(R.id.button_pista_color));
        colorManagerPlay = new ColorManagerPlay();
        imagen = findViewById(R.id.txt_color_imagen);
        txt_titulo = findViewById(R.id.txt_colorplay_titulo);
        botones = setBotonesId();
        generarProblema();
        asignarSonidos();
    }

    public void generarSonido(int i){
        sp[i].play(sonidosRep[i],volumenEfecto / 50f,volumenEfecto / 50f,1,0,1);
    }

    public void asignarSonidos() {
        sp = new SoundPool[3];
        sonidosRep = new int[3];

        for(int i = 0;i < sp.length;i++){
            sp[i] = new SoundPool(1, AudioManager.STREAM_MUSIC,1);
        }
        sonidosRep[0] = sp[0].load(this,R.raw.sonidocorrecto,1);
        sonidosRep[1] = sp[1].load(this,R.raw.sonidofallar,1);
        sonidosRep[2] = sp[2].load(this,R.raw.sonidoohno,1);
    }

    private Button[] setBotonesId() {
        return new Button[]{
                findViewById(R.id.button_amarillo_play),
                findViewById(R.id.button_celeste_play),
                findViewById(R.id.button_rojo_play),
                findViewById(R.id.button_verde_play),
                findViewById(R.id.button_naranja_play),
                findViewById(R.id.button_negro_play),
                findViewById(R.id.button_blanco_play),
                findViewById(R.id.button_marron_play),
                findViewById(R.id.button_rosa_play),
                findViewById(R.id.button_azul_play),
                findViewById(R.id.button_morado_play)
        };
    }


    public void generarProblema(){
        if(minijuegoManager.sinVidas()){
            Intent i = new Intent(this,FinJuegoActivity.class);
            i.putExtra("puntos",minijuegoManager.getPuntos());
            startActivity(i);
            finish();
        }
        else{
            txt_titulo.setText("¿Que color?");
            objActual = colorManagerPlay.getIdAleatorio();
            minijuegoManager.getPista().setEnabled(true);
            botonesDisponibles = true;
            imagen.setImageResource(colorManagerPlay.getIdImagenes()[objActual]);
            ImageViewCompat.setImageTintList(imagen, ColorStateList.valueOf(Color.parseColor("#EDAFAFAF")));
            minijuegoManager.getTxtPista().setText("");
        }
    }

    public void opcionPresionada(View view){
        if(botonesDisponibles){
            botonesDisponibles = false;
            int id = view.getId();
            switch (id){
                case R.id.button_amarillo_play:
                    colorSelec = AMARILLO;
                    break;
                case R.id.button_celeste_play:
                    colorSelec = CELESTE;
                    break;
                case R.id.button_rojo_play:
                    colorSelec = ROJO;
                    break;
                case R.id.button_verde_play:
                    colorSelec = VERDE;
                    break;
                case R.id.button_naranja_play:
                    colorSelec = NARANJA;
                    break;
                case R.id.button_negro_play:
                    colorSelec = NEGRO;
                    break;
                case R.id.button_blanco_play:
                    colorSelec = BLANCO;
                    break;
                case R.id.button_marron_play:
                    colorSelec = MARRON;
                    break;
                case R.id.button_rosa_play:
                    colorSelec = ROSA;
                    break;
                case R.id.button_azul_play:
                    colorSelec = AZUL;
                    break;
                case R.id.button_morado_play:
                    colorSelec = MORADO;
                    break;
                default:
                    Toast.makeText(this,"ERROR",Toast.LENGTH_SHORT).show();
                    break;
            }

            if(colorCorrecto(colorSelec)){
                generarSonido(0);
                txt_titulo.setText("Bien Hecho!");
                minijuegoManager.sumarPunto();
                if(minijuegoManager.getPuntos() % 5 == 0){
                    minijuegoManager.sumarPista();
                }
            }
            else{
                generarSonido(1);
                generarSonido(2);
                txt_titulo.setText("Ups.. no era.");
                minijuegoManager.restarVida();
            }
            ImageViewCompat.setImageTintList(imagen, null);

            Handler handler = new Handler();
            handler. postDelayed(new Runnable() {
                public void run() {
                    generarProblema();
                }
            }, 2000);

        }
    }

    private boolean colorCorrecto(Colores colorSelec) {
        return colorSelec.equals(colorManagerPlay.getNombreColor()[objActual]);
    }

    public void getPista(View view){
        if(minijuegoManager.getPista().isEnabled() && botonesDisponibles){
            if(minijuegoManager.getPistas() > 0){
                minijuegoManager.getTxtPista().setText(String.valueOf(colorManagerPlay.getNombreColor()[objActual]));
                minijuegoManager.restarPísta();
            }
            else{
                minijuegoManager.getTxtPista().setText("No tienes pistas");
            }
            minijuegoManager.getPista().setEnabled(false);
        }
    }


    @Override
    public void onBackPressed() {
        AlertDialog.Builder alerta = new AlertDialog.Builder(ColorPlayActivity.this);
        alerta.setMessage("Perderás todo tu progreso");
        alerta.setCancelable(true);
        alerta.setPositiveButton("Salir", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Intent salir = new Intent(ColorPlayActivity.this,FinJuegoActivity.class);
                salir.putExtra("puntos",minijuegoManager.getPuntos());
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