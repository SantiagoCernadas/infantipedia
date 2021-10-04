package com.example.proyectodante;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Bundle;
import android.view.View;

import com.example.proyectodante.Manager.NombreNumsManager;

public class familiasActivity extends AppCompatActivity {
    private int[] nums;
    private String[] nombreNums;
    private SoundPool[] sonidosNums;
    private int[]  sonidosRep;
    private SoundPool sonidoCien;
    private int sonidoCienRep;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_familias);
        nums = new int[10];
        nombreNums = new String[10];
        sonidoCien = new SoundPool(1, AudioManager.STREAM_MUSIC,1);
        sonidoCienRep = sonidoCien.load(this,R.raw.sonidocien,1);
    }

    public void repCien(View view){
        sonidoCien.play(sonidoCienRep,1,1,1,0,1);
    }

    public void familiaNumActivity(View view){
        Intent i = new Intent(this,NumFamiliaActivity.class);
        switch (view.getId()){
            case R.id.familia_0:
                nums = generarNums(0);
                nombreNums = NombreNumsManager.getFamilia0();
                break;
            case R.id.familia_10:
                nums = generarNums(10);
                nombreNums = NombreNumsManager.getFamilia10();
                break;
            case R.id.familia_20:
                nums = generarNums(20);
                nombreNums = NombreNumsManager.getFamilia20();
                break;
            case R.id.familia_30:
                nums = generarNums(30);
                nombreNums = NombreNumsManager.getFamilia30();
                break;
            case R.id.familia_40:
                nums = generarNums(40);
                nombreNums = NombreNumsManager.getFamilia40();
                break;
            case R.id.familia_50:
                nums = generarNums(50);
                nombreNums = NombreNumsManager.getFamilia50();
                break;
            case R.id.familia_60:
                nums = generarNums(60);
                nombreNums = NombreNumsManager.getFamilia60();
                break;
            case R.id.familia_70:
                nums = generarNums(70);
                nombreNums = NombreNumsManager.getFamilia70();
                break;
            case R.id.familia_80:
                nums = generarNums(80);
                nombreNums = NombreNumsManager.getFamilia80();
                break;
            case R.id.familia_90:
                nums = generarNums(90);
                nombreNums = NombreNumsManager.getFamilia90();
                break;
        }
        i.putExtra("numeros",nums);
        i.putExtra("nombres",nombreNums);
        startActivity(i);
    }

    private int[] generarNums(int familia) {
        int[] nums = new int[10];

        for(int i = 0;i < nums.length;i++){
            nums[i] = familia + i;
        }

        return nums;
    }
}