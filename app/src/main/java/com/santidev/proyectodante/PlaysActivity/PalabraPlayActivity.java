package com.santidev.proyectodante.PlaysActivity;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
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

import com.santidev.proyectodante.Manager.MinijuegoManager;
import com.santidev.proyectodante.Manager.PalabraPlayManager;
import com.santidev.proyectodante.R;

import static com.santidev.proyectodante.MainActivity.pause;
import static com.santidev.proyectodante.MainActivity.start;
import static com.santidev.proyectodante.MainActivity.volumenEfecto;

public class PalabraPlayActivity extends AppCompatActivity {

    private final int NUM_PALABRAS = 81;
    private Button[] opciones;
    private ImageView imagen;
    private String palabraCorrecta;
    private int opcCorrecta;
    private String[] palabras;
    private int[] idImagen;
    private SoundPool[] sp;
    private int[] sonidosRep;
    private TextView txt_titulo;

    private MinijuegoManager minijuegoManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_palabra_play);
        PalabraPlayManager manager = new PalabraPlayManager();

        minijuegoManager = new MinijuegoManager(3,0,3,
                findViewById(R.id.txt_palabra_vidas),findViewById(R.id.txt_palabra_puntos),findViewById(R.id.txt_pista_palabra),
                findViewById(R.id.txt_pista_palabra_cant),findViewById(R.id.button_pista_palabra));


        opciones = new Button[4];
        palabras = new String[NUM_PALABRAS];
        idImagen = new int[NUM_PALABRAS];
        txt_titulo = findViewById(R.id.txt_palabra_titulo);

        asignarSonidos();
        conectarID();
        manager.setImagenes(idImagen);
        manager.setPalabras(palabras);
        generarProblema();
    }

    public void asignarSonidos() {
        sp = new SoundPool[3];
        sonidosRep = new int[3];

        for(int i = 0;i < sp.length;i++){
            sp[i] = new SoundPool(1,AudioManager.STREAM_MUSIC,1);
        }
        sonidosRep[0] = sp[0].load(this,R.raw.sonidocorrecto,1);
        sonidosRep[1] = sp[1].load(this,R.raw.sonidofallar,1);
        sonidosRep[2] = sp[2].load(this,R.raw.sonidoohno,1);
    }
    public void generarSonido(int i){
        sp[i].play(sonidosRep[i],volumenEfecto / 50f,volumenEfecto / 50f,1,0,1);
    }

    public void opcionPresionada(View view){
        int id = view.getId();
        switch (id){
            case R.id.button_opc1:
                esCorrecto(0);
                break;
            case R.id.button_opc2:
                esCorrecto(1);
                break;
            case R.id.button_opc3:
                esCorrecto(2);
                break;
            case R.id.button_opc4:
                esCorrecto(3);
                break;
            default:
                Toast.makeText(this,"ERROR",Toast.LENGTH_SHORT).show();
                break;
        }

        bloquearOpciones(opciones);

        Handler handler = new Handler();
        handler. postDelayed(new Runnable() {
            public void run() {
                    txt_titulo.setText("¿Que es?");
                    minijuegoManager.getPista().setEnabled(true);
                    minijuegoManager.getTxtPista().setText("");
                    habilitarOpciones(opciones);
                    generarProblema();
                }
                }, 2000);

    }

    public void bloquearOpciones(Button[] opciones) {
        for(int i = 0; i < opciones.length; i++){
            opciones[i].setEnabled(false);
        }
    }

    public void habilitarOpciones(Button[] opciones) {
        for(int i = 0; i < opciones.length; i++){
            opciones[i].setEnabled(true);
        }
    }



    public void esCorrecto(int i) {

        if(opciones[i].getText().toString().equals(palabraCorrecta)){
            opciones[i].setBackgroundColor(Color.GREEN);
            generarSonido(0);
            txt_titulo.setText("Bien Hecho!");
            minijuegoManager.sumarPunto();
            if(minijuegoManager.getPuntos() % 5 == 0){
                minijuegoManager.sumarPista();
            }
        }
        else{
            opciones[i].setBackgroundColor(Color.RED);
            opciones[opcCorrecta].setBackgroundColor(Color.GREEN);
            generarSonido(1);
            generarSonido(2);
            minijuegoManager.restarVida();
            txt_titulo.setText("Ups.. no era.");
        }

    }



    public void generarProblema(){
        if(minijuegoManager.sinVidas()){
            Intent i = new Intent(this,FinJuegoActivity.class);
            i.putExtra("puntos",minijuegoManager.getPuntos());
            startActivity(i);
            finish();
        }
        else{
            pintarBotones(opciones);
            int numCorrecto = (int)(Math.random()*NUM_PALABRAS+0);
            palabraCorrecta = palabras[numCorrecto];
            imagen.setImageResource(idImagen[numCorrecto]);
            opcCorrecta = (int)(Math.random()*4+0);
            opciones[opcCorrecta].setText(palabraCorrecta);

            for(int i = 0;i < opciones.length;i++){
                if(i != opcCorrecta){
                    do{
                        opciones[i].setText(palabras[(int)(Math.random()*NUM_PALABRAS+0)]);
                    }while (esRepetido(i));

                }
            }
        }
    }

    public void pintarBotones(Button[] opciones) {
        for(int i = 0; i < opciones.length; i++){
            opciones[i].setBackgroundColor(Color.WHITE);
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

    @Override
    public void onBackPressed() {
        AlertDialog.Builder alerta = new AlertDialog.Builder(PalabraPlayActivity.this);
        alerta.setMessage("Perderás todo tu progreso");
        alerta.setCancelable(true);
        alerta.setPositiveButton("Salir", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Intent salir = new Intent(PalabraPlayActivity.this,FinJuegoActivity.class);
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

    public void getPista(View view){
        if(minijuegoManager.getPista().isEnabled() && opciones[0].isEnabled()){
            if(minijuegoManager.getPistas() > 0){
                if(opciones[opcCorrecta].getText().toString().contains(" ")){
                    minijuegoManager.getTxtPista().setText("Empieza con " + opciones[opcCorrecta].getText().toString().charAt(0));
                }
                else{
                    int numero = (int)(Math.random()*2+1);
                    if(numero == 1){
                        minijuegoManager.getTxtPista().setText("Tiene " + opciones[opcCorrecta].getText().toString().length() + " Letras ");
                    }
                    else{
                        minijuegoManager.getTxtPista().setText("Empieza con " + opciones[opcCorrecta].getText().toString().charAt(0));
                    }
                }
                minijuegoManager.getPista().setEnabled(false);
                minijuegoManager.restarPísta();
            }
            else{
                minijuegoManager.getTxtPista().setText("No tienes pistas");
            }

        }
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