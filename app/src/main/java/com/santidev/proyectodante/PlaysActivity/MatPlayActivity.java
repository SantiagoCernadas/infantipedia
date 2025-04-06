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
import android.widget.TextView;
import android.widget.Toast;

import com.santidev.proyectodante.Manager.MinijuegoManager;
import com.santidev.proyectodante.R;

import static com.santidev.proyectodante.MainActivity.pause;
import static com.santidev.proyectodante.MainActivity.start;
import static com.santidev.proyectodante.MainActivity.volumenEfecto;

public class MatPlayActivity extends AppCompatActivity {
    private TextView txtNum1, txtNum2, txtSigno, txtResultado, txtDescripcion;
    private int resultadoInt;
    private String[] signos;
    private String signoSeleccionado;
    private SoundPool[] sp;
    private int[] sonidosRep;
    private int cantSignos;
    private int rangoSumRes;
    private int rangoMult;
    private boolean botonesDisponibles;

    MinijuegoManager minijuegoManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mat_play);

        minijuegoManager = new MinijuegoManager(3,0,3,
                findViewById(R.id.txt_mat_vidas),findViewById(R.id.txt_mat_puntos),findViewById(R.id.txt_pista_mat),
                findViewById(R.id.txt_pista_mat_cant),findViewById(R.id.button_pista_mat));

        txtNum1 = findViewById(R.id.txt_num1);
        txtNum2 = findViewById(R.id.txt_num2);
        txtSigno = findViewById(R.id.txt_signo);
        txtResultado = findViewById(R.id.txt_resultado);
        txtDescripcion = findViewById(R.id.txt_mat_play_desc);
        cantSignos = Integer.parseInt(getIntent().getStringExtra("signos"));
        rangoSumRes = Integer.parseInt(getIntent().getStringExtra("rango_suma_resta"));
        rangoMult = Integer.parseInt(getIntent().getStringExtra("rango_multiplicacion"));
        botonesDisponibles = true;
        txtDescripcion.setText("");

        asignarSonidos();
        setSignos();
        generarProblema();

        if(cantSignos == 3){
            minijuegoManager.getPista().setVisibility(View.INVISIBLE);
            minijuegoManager.getTxtCantPistas().setVisibility(View.INVISIBLE);
            minijuegoManager.getTxtPista().setVisibility(View.INVISIBLE);
        }
    }

    private void asignarSonidos() {
        sp = new SoundPool[3];
        sonidosRep = new int[3];

        for(int i = 0;i < sp.length;i++){
            sp[i] = new SoundPool(1, AudioManager.STREAM_MUSIC,1);
        }
        sonidosRep[0] = sp[0].load(this,R.raw.sonidocorrecto,1);
        sonidosRep[1] = sp[1].load(this,R.raw.sonidofallar,1);
        sonidosRep[2] = sp[2].load(this,R.raw.sonidoohno,1);
    }

    public void setSignos() {
         signos = new String[3];
         signos[0] = "+";
         signos[1] = "-";
         signos[2] = "X";
    }

    public void generarProblema() {
        if(!minijuegoManager.sinVidas()){
            signoSeleccionado = signos[(int)(Math.random()*cantSignos+0)];
            int num2Int;
            int num1Int;
            if(signoSeleccionado.equals("-")){
                num1Int = (int)(Math.random()*rangoSumRes+1);
                num2Int = (int)(Math.random()* num1Int +1);
            }
            else if (signoSeleccionado.equals("+")){
                num1Int = (int)(Math.random()*rangoSumRes+1);
                num2Int = (int)(Math.random()*rangoSumRes+1);
            }
            else{
                num1Int = (int)(Math.random()*rangoMult+1);
                num2Int = (int)(Math.random()*rangoMult+1);
            }
            txtNum1.setText(String.valueOf(num1Int));
            txtSigno.setText(signoSeleccionado);
            txtNum2.setText(String.valueOf(num2Int));
            resultadoInt = calcularProblema(num1Int,num2Int);
        }
        else{
            Intent i = new Intent(this,FinJuegoActivity.class);
            i.putExtra("puntos",minijuegoManager.getPuntos());
            startActivity(i);
            finish();
        }
    }

    public int calcularProblema(int num1, int num2){
        int resultado;
        if(signoSeleccionado.equals("+")){
            resultado = num1 + num2;
        }
        else if(signoSeleccionado.equals("-")){
            resultado = num1 - num2;
        }
        else{
            resultado = num1 * num2;
        }

        return resultado;
    }

    public void botonPresionado(View view){
        if (botonesDisponibles){
            String resultadoAct = txtResultado.getText().toString();
            switch (view.getId()){
                case R.id.button_num_play1:
                    txtResultado.setText(resultadoAct + "1");
                    break;
                case R.id.button_num_play2:
                    txtResultado.setText(resultadoAct + "2");
                    break;
                case R.id.button_num_play3:
                    txtResultado.setText(resultadoAct + "3");
                    break;
                case R.id.button_num_play4:
                    txtResultado.setText(resultadoAct + "4");
                    break;
                case R.id.button_num_play5:
                    txtResultado.setText(resultadoAct + "5");
                    break;
                case R.id.button_num_play6:
                    txtResultado.setText(resultadoAct + "6");
                    break;
                case R.id.button_num_play7:
                    txtResultado.setText(resultadoAct + "7");
                    break;
                case R.id.button_num_play8:
                    txtResultado.setText(resultadoAct + "8");
                    break;
                case R.id.button_num_play9:
                    txtResultado.setText(resultadoAct + "9");
                    break;
                case R.id.button_num_play0:
                case R.id.button_num_play01:
                case R.id.button_num_play02:
                    txtResultado.setText(resultadoAct + "0");
                    break;
                default:
                    txtResultado.setText("ERROR");
                    break;
            }
        }
    }

    public void calcular(View view){
        if (botonesDisponibles){
            if(!txtResultado.getText().toString().equals("")){
                int resultadoUsuario = Integer.parseInt(txtResultado.getText().toString());
                if(resultadoUsuario == resultadoInt){
                    minijuegoManager.sumarPunto();
                    generarSonido(0);
                    txtDescripcion.setText("Bien Hecho!");
                    txtResultado.setTextColor(Color.GREEN);
                    if(minijuegoManager.getPuntos() % 5 == 0 && cantSignos != 3){
                        minijuegoManager.getTxtPista().setText("+1 pista!");
                        minijuegoManager.sumarPista();
                    }
                }
                else{
                    minijuegoManager.restarVida();
                    generarSonido(1);
                    generarSonido(2);
                    txtDescripcion.setText("Ups.. la respuesta correcta era " + resultadoInt);
                    txtResultado.setTextColor(Color.RED);
                }

                botonesDisponibles = false;
                Handler handler = new Handler();
                handler. postDelayed(new Runnable() {
                    public void run() {
                        txtResultado.setTextColor(Color.BLACK);
                        txtDescripcion.setText("");
                        minijuegoManager.getPista().setEnabled(true);
                        minijuegoManager.getTxtPista().setText("");
                        botonesDisponibles = true;
                        txtResultado.setText("");
                        generarProblema();
                    }
                }, 3000);
            }
            else{
                Toast.makeText(this,"Ingrese un numero.",Toast.LENGTH_SHORT).show();
            }
        }
    }


    private void generarSonido(int i) {
        sp[i].play(sonidosRep[i],volumenEfecto / 50f,volumenEfecto / 50f,1,0,1);
    }

    public void borrarTodo(View view){
        if(botonesDisponibles){
            txtResultado.setText("");
        }

    }

    public void atras(View view){
        if(botonesDisponibles){
            String resultadoAct = txtResultado.getText().toString();
            if(resultadoAct.length() > 0){
                txtResultado.setText(resultadoAct.substring(0,resultadoAct.length()-1));
            }
        }
    }

    public void getPista(View view){

        if(minijuegoManager.getPista().isEnabled() && botonesDisponibles){
            if(minijuegoManager.getPistas() > 0){
                int numero = (int)(Math.random()*2+1);
                if(numero == 1){
                    minijuegoManager.getTxtPista().setText("detras del " + (resultadoInt + 1) + " ");
                }
                else{
                    minijuegoManager.getTxtPista().setText("delante del " + (resultadoInt - 1)+ " ");
                }
                minijuegoManager.getPista().setEnabled(false);
                minijuegoManager.restarPísta();
            }
            else{
                minijuegoManager.getTxtPista().setText("No tienes pistas");
            }

        }
    }

    @Override
    public void onBackPressed() {
        AlertDialog.Builder alerta = new AlertDialog.Builder(MatPlayActivity.this);
        alerta.setMessage("Perderás todo tu progreso");
        alerta.setCancelable(true);
        alerta.setPositiveButton("Salir", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Intent salir = new Intent(MatPlayActivity.this,FinJuegoActivity.class);
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