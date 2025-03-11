package com.santidev.proyectodante.PlaysActivity;

import android.annotation.SuppressLint;
import android.content.ClipData;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Bundle;
import android.os.Handler;
import android.view.DragEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.widget.ImageViewCompat;

import com.santidev.proyectodante.R;

import static com.santidev.proyectodante.MainActivity.pause;
import static com.santidev.proyectodante.MainActivity.start;
import static com.santidev.proyectodante.MainActivity.volumenEfecto;

public class FiguraPlayActivity extends AppCompatActivity {
    private ImageView dragButton, dropCuadrado,dropCirculo,dropTriangulo,dropRectangulo;
    private Button pista;
    private ImageView dropRombo, dropEstrella;
    private TextView titulo,txtVidas,txtPuntos;
    private int[] idFigura = new int[6];
    private int figuraAct,vidas, puntos;
    private SoundPool[] sp;
    private int[] sonidosRep;
    private TextView txtPista,txtPistaCant;
    private int cantPista;

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_figura_play);
        getNums();
        cantPista = 3;
        vidas = 3;
        puntos = 0;
        setIds();
        asignarSonidos();
        dragButton(dropCuadrado,0);
        dragButton(dropCirculo,1);
        dragButton(dropTriangulo,2);
        dragButton(dropRombo,3);
        dragButton(dropRectangulo,4);
        dragButton(dropEstrella,5);

        txtPista.setText("");
        txtPistaCant.setText(String.valueOf(cantPista));

        dragButton.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                ClipData data = ClipData.newPlainText("","");
                View.DragShadowBuilder shadow = new View.DragShadowBuilder(dragButton);
                v.startDrag(data,shadow,null,0);
                return false;
            }
        });
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

    public void generarSonido(int i){
        sp[i].play(sonidosRep[i],volumenEfecto / 50f,volumenEfecto / 50f,1,0,1);
    }

    public void dragButton(ImageView iv, int iAct){
        iv.setOnDragListener(new View.OnDragListener() {
            @Override
            public boolean onDrag(View v, DragEvent event) {
                final int action = event.getAction();

                switch (action){
                    case DragEvent.ACTION_DROP: {
                        formaCorrecta(iAct);
                        return (true);
                    }
                    case DragEvent.ACTION_DRAG_ENDED:{
                        return true;
                    }
                    default:
                        break;
                }


                return true;
            }
        });
    }

    public void actPuntos() {
        txtPuntos.setText("Puntos = " + puntos + " ");
        txtVidas.setText("Vidas = " + vidas + " ");
    }

    public void cambiarForma() {
        if(vidas == 0){
            Intent intent = new Intent(this,FinJuegoActivity.class);
            intent.putExtra("puntos",puntos);
            startActivity(intent);
            finish();
        }
        int i = (int)(Math.random()*6+0);
        figuraAct = i;
        dragButton.setImageResource(idFigura[i]);
    }

    public void formaCorrecta(int i){
        dragButton.setVisibility(View.INVISIBLE);
        if(figuraAct == i){
            generarSonido(0);
            titulo.setText("bien hecho!");
            puntos++;
        }
        else{
            generarSonido(1);
            generarSonido(2);
            titulo.setText("ups.. no era");
            vidas--;
        }
        actPuntos();
        Handler handler = new Handler();
        handler. postDelayed(new Runnable() {
            public void run() {
                txtPista.setText("");
                pista.setEnabled(true);
                cambiarForma();
                titulo.setText("en que lugar va?");
                ImageViewCompat.setImageTintList(dragButton, ColorStateList.valueOf(Color.parseColor("#000000")));
                dragButton.setVisibility(View.VISIBLE);
            }
        }, 2000);
    }

    public void getNums() {
        idFigura[0] = R.drawable.imgcuadrado;
        idFigura[1] = R.drawable.imgcirculo;
        idFigura[2] = R.drawable.imgtriangulo;
        idFigura[3] = R.drawable.imgrombo;
        idFigura[4] = R.drawable.imgrectangulo;
        idFigura[5] = R.drawable.imgestrella;
    }


    public void setIds(){
        dragButton = findViewById(R.id.dragbutton);
        dropCuadrado = findViewById(R.id.drop_cuadrado);
        dropCirculo = findViewById(R.id.drop_circulo);
        dropTriangulo = findViewById(R.id.drop_triangulo);
        dropRectangulo = findViewById(R.id.drop_rectangulo);
        dropRombo = findViewById(R.id.drop_rombo);
        dropEstrella = findViewById(R.id.drop_estrella);
        titulo = findViewById(R.id.txt_figura_titulo);
        txtPuntos = findViewById(R.id.txt_figura_puntos);
        txtVidas = findViewById(R.id.txt_figura_vidas);
        pista = findViewById(R.id.button_pista_figura);
        txtPista = findViewById(R.id.txt_pista_figura);
        txtPistaCant = findViewById(R.id.txt_pista_figura_cant);
    }

    public void getPista(View view){
        if(pista.isEnabled()){
            if(cantPista > 0){
                /*Logica de la pista*/
                generarSonido(0);
                pista.setEnabled(false);
                cantPista--;
                txtPistaCant.setText(String.valueOf(cantPista));
                ImageViewCompat.setImageTintList(dragButton, null);
            }
            else{
                txtPista.setText("No tienes pistas");
            }

        }
    }

    @Override
    public void onBackPressed() {
        AlertDialog.Builder alerta = new AlertDialog.Builder(FiguraPlayActivity.this);
        alerta.setMessage("Perderás todo tu progreso");
        alerta.setCancelable(true);
        alerta.setPositiveButton("Salir", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Intent salir = new Intent(FiguraPlayActivity.this,FinJuegoActivity.class);
                salir.putExtra("puntos",puntos);
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


