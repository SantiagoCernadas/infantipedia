package com.santidev.proyectodante;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Bundle;
import android.view.View;
import android.widget.SeekBar;

import static com.santidev.proyectodante.MainActivity.mp;
import static com.santidev.proyectodante.MainActivity.pause;
import static com.santidev.proyectodante.MainActivity.start;
import static com.santidev.proyectodante.MainActivity.volumenEfecto;
import static com.santidev.proyectodante.MainActivity.volumenMusica;

public class ConfigActivity extends AppCompatActivity {
    private SeekBar seekBarMusica,seekBarEfecto;
    private SoundPool sp;
    private int spRep;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_config);
        seekBarMusica = findViewById(R.id.volumen_musica);
        seekBarMusica.setProgress(volumenMusica);
        seekBarEfecto = findViewById(R.id.volumen_efecto);
        seekBarEfecto.setProgress(volumenEfecto);

        sp = new SoundPool(1, AudioManager.STREAM_MUSIC,1);
        spRep = sp.load(this,R.raw.tatetiding,1);

        seekBarMusica.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                mp.setVolume(progress / 50f,progress / 50f);
                volumenMusica = progress;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                SharedPreferences preferencias = getSharedPreferences("datos",Context.MODE_PRIVATE);
                SharedPreferences.Editor objEditor = preferencias.edit();
                objEditor.putInt("volumenMusica",volumenMusica);
                objEditor.apply();
            }
        });

        seekBarEfecto.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                volumenEfecto = progress;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                SharedPreferences preferencias = getSharedPreferences("datos",Context.MODE_PRIVATE);
                SharedPreferences.Editor objEditor = preferencias.edit();
                objEditor.putInt("volumenSonido",volumenEfecto);
                objEditor.apply();
            }
        });
    }

    public void reproducir(View view){
        sp.play(spRep,volumenEfecto / 50f,volumenEfecto / 50f,1,0,1);

    }

    public void regresar(View view){
        finish();
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