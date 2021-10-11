package com.example.proyectodante;

import androidx.appcompat.app.AppCompatActivity;

import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class NumFamiliaActivity extends AppCompatActivity {
    private int[] nums;
    private String[] nombreNums;
    private SoundPool[] sp;
    private int[] spRep;
    private TextView[] tv;
    private TextView txtTitulo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        nums = new int[10];
        nombreNums = new String[10];
        sp = new SoundPool[10];
        spRep = new int[10];
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_num_familia);
        nums = getIntent().getIntArrayExtra("numeros");
        nombreNums = getIntent().getStringArrayExtra("nombres");
        tv = new TextView[20];
        txtTitulo = findViewById(R.id.txt_familia_titulo);
        conectarID();
        setNumeros();
        setNombres();
        setSonidos(sp,spRep);
        txtTitulo.setText("Familia del " + nums[0]);
    }

    private void setSonidos(SoundPool[] sp, int[] spRep) {
        for(int i = 0;i < 10;i++){
            sp[i] = new SoundPool(1, AudioManager.STREAM_MUSIC,1);
        }
        switch (nums[0]){
            case 0:
                getSonidos0(sp,spRep);
                break;
            case 10:
                getSonidos10(sp,spRep);
                break;
            case 20:
                getSonidos20(sp,spRep);
                break;
            case 30:
                getSonidos30(sp,spRep);
                break;
            case 40:
                getSonidos40(sp,spRep);
                break;
            case 50:
                getSonidos50(sp,spRep);
                break;
            case 60:
                getSonidos60(sp,spRep);
                break;
            case 70:
                getSonidos70(sp,spRep);
                break;
            case 80:
                getSonidos80(sp,spRep);
                break;
            case 90:
                getSonidos90(sp,spRep);
                break;
        }
    }

    private void conectarID() {
        tv[0] = findViewById(R.id.tabla_ec_1);
        tv[1] = findViewById(R.id.tabla_ec_2);
        tv[2] = findViewById(R.id.tabla_ec_3);
        tv[3] = findViewById(R.id.tabla_ec_4);
        tv[4] = findViewById(R.id.tabla_ec_5);
        tv[5] = findViewById(R.id.tabla_ec_6);
        tv[6] = findViewById(R.id.tabla_ec_7);
        tv[7] = findViewById(R.id.tabla_ec_8);
        tv[8] = findViewById(R.id.tabla_ec_9);
        tv[9] = findViewById(R.id.tabla_ec_10);
        tv[10] = findViewById(R.id.familia_nombre_0);
        tv[11] = findViewById(R.id.familia_nombre_1);
        tv[12] = findViewById(R.id.familia_nombre_2);
        tv[13] = findViewById(R.id.familia_nombre_3);
        tv[14] = findViewById(R.id.familia_nombre_4);
        tv[15] = findViewById(R.id.familia_nombre_5);
        tv[16] = findViewById(R.id.familia_nombre_6);
        tv[17] = findViewById(R.id.familia_nombre_7);
        tv[18] = findViewById(R.id.familia_nombre_8);
        tv[19] = findViewById(R.id.familia_nombre_9);

    }


    private void setNumeros() {
        for(int i = 0;i < 10;i++){
            tv[i].setText(nums[i]+"- ");
        }
    }
    private void setNombres() {
        for(int i = 0;i < 10;i++){
            tv[i+10].setText(nombreNums[i] + " ");
        }
    }

    public void Reproducir(View view){
        switch (view.getId()){
            case R.id.rep_sonido_0:
                reproducirSonido(0);
                break;
            case R.id.rep_sonido_1:
                reproducirSonido(1);
                break;
            case R.id.rep_sonido_2:
                reproducirSonido(2);
                break;
            case R.id.rep_sonido_3:
                reproducirSonido(3);
                break;
            case R.id.rep_sonido_4:
                reproducirSonido(4);
                break;
            case R.id.rep_sonido_5:
                reproducirSonido(5);
                break;
            case R.id.rep_sonido_6:
                reproducirSonido(6);
                break;
            case R.id.rep_sonido_7:
                reproducirSonido(7);
                break;
            case R.id.rep_sonido_8:
                reproducirSonido(8);
                break;
            case R.id.rep_sonido_9:
                reproducirSonido(9);
                break;
        }
    }

    public void reproducirSonido(int i){
        sp[i].play(spRep[i],1,1,1,0,1);
    }


    public void getSonidos0(SoundPool sp[],int spRep[]){
        spRep[0] = sp[0].load(this,R.raw.sonidocero,1);
        spRep[1] = sp[1].load(this,R.raw.sonidouno,1);
        spRep[2] = sp[2].load(this,R.raw.sonidodos,1);
        spRep[3] = sp[3].load(this,R.raw.sonidotres,1);
        spRep[4] = sp[4].load(this,R.raw.sonidocuatro,1);
        spRep[5] = sp[5].load(this,R.raw.sonidocinco,1);
        spRep[6] = sp[6].load(this,R.raw.sonidoseis,1);
        spRep[7] = sp[7].load(this,R.raw.sonidosiete,1);
        spRep[8] = sp[8].load(this,R.raw.sonidoocho,1);
        spRep[9] = sp[9].load(this,R.raw.sonidonueve,1);
    }
    public void getSonidos10(SoundPool sp[],int spRep[]){
        spRep[0] = sp[0].load(this,R.raw.sonidodiez,1);
        spRep[1] = sp[1].load(this,R.raw.sonidoonce,1);
        spRep[2] = sp[2].load(this,R.raw.sonidodoce,1);
        spRep[3] = sp[3].load(this,R.raw.sonidotrece,1);
        spRep[4] = sp[4].load(this,R.raw.sonidocatorce,1);
        spRep[5] = sp[5].load(this,R.raw.sonidoquince,1);
        spRep[6] = sp[6].load(this,R.raw.sonidodieciseis,1);
        spRep[7] = sp[7].load(this,R.raw.sonidodiecisiete,1);
        spRep[8] = sp[8].load(this,R.raw.sonidodieciocho,1);
        spRep[9] = sp[9].load(this,R.raw.sonidodiecinueve,1);
    }
    public void getSonidos20(SoundPool sp[],int spRep[]){
        spRep[0] = sp[0].load(this,R.raw.sonidoveinte,1);
        spRep[1] = sp[1].load(this,R.raw.sonidoveintiuno,1);
        spRep[2] = sp[2].load(this,R.raw.sonidoveintidos,1);
        spRep[3] = sp[3].load(this,R.raw.sonidoveintitres,1);
        spRep[4] = sp[4].load(this,R.raw.sonidoveinticuatro,1);
        spRep[5] = sp[5].load(this,R.raw.sonidoveinticinco,1);
        spRep[6] = sp[6].load(this,R.raw.sonidoveintiseis,1);
        spRep[7] = sp[7].load(this,R.raw.sonidoveintisiete,1);
        spRep[8] = sp[8].load(this,R.raw.sonidoveintiocho,1);
        spRep[9] = sp[9].load(this,R.raw.sonidoveintinueve,1);
    }
    public void getSonidos30(SoundPool sp[],int spRep[]){
        spRep[0] = sp[0].load(this,R.raw.sonidotreinta,1);
        spRep[1] = sp[1].load(this,R.raw.sonidotreintayuno,1);
        spRep[2] = sp[2].load(this,R.raw.sonidotreintaydos,1);
        spRep[3] = sp[3].load(this,R.raw.sonidotreintaytres,1);
        spRep[4] = sp[4].load(this,R.raw.sonidotreintaycuatro,1);
        spRep[5] = sp[5].load(this,R.raw.sonidotreintaycinco,1);
        spRep[6] = sp[6].load(this,R.raw.sonidotreintayseis,1);
        spRep[7] = sp[7].load(this,R.raw.sonidotreintaysiete,1);
        spRep[8] = sp[8].load(this,R.raw.sonidotreintayocho,1);
        spRep[9] = sp[9].load(this,R.raw.sonidotreintaynueve,1);
    }
    public void getSonidos40(SoundPool sp[],int spRep[]){
        spRep[0] = sp[0].load(this,R.raw.sonidocuarenta,1);
        spRep[1] = sp[1].load(this,R.raw.sonidocuarentayuno,1);
        spRep[2] = sp[2].load(this,R.raw.sonidocuarentaydos,1);
        spRep[3] = sp[3].load(this,R.raw.sonidocuarentaytres,1);
        spRep[4] = sp[4].load(this,R.raw.sonidocuarentaycuatro,1);
        spRep[5] = sp[5].load(this,R.raw.sonidocuarentaycinco,1);
        spRep[6] = sp[6].load(this,R.raw.sonidocuarentayseis,1);
        spRep[7] = sp[7].load(this,R.raw.sonidocuarentaysiete,1);
        spRep[8] = sp[8].load(this,R.raw.sonidocuarentayocho,1);
        spRep[9] = sp[9].load(this,R.raw.sonidocuarentaynueve,1);
    }
    public void getSonidos50(SoundPool sp[],int spRep[]){
        spRep[0] = sp[0].load(this,R.raw.sonidocincuenta,1);
        spRep[1] = sp[1].load(this,R.raw.sonidocincuentayuno,1);
        spRep[2] = sp[2].load(this,R.raw.sonidocincuentaydos,1);
        spRep[3] = sp[3].load(this,R.raw.sonidocincuentaytres,1);
        spRep[4] = sp[4].load(this,R.raw.sonidocincuentaycuatro,1);
        spRep[5] = sp[5].load(this,R.raw.sonidocincuentaycinco,1);
        spRep[6] = sp[6].load(this,R.raw.sonidocincuentayseis,1);
        spRep[7] = sp[7].load(this,R.raw.sonidocincuentaysiete,1);
        spRep[8] = sp[8].load(this,R.raw.sonidocincuentayocho,1);
        spRep[9] = sp[9].load(this,R.raw.sonidocincuentaynueve,1);
    }
    public void getSonidos60(SoundPool sp[],int spRep[]){
        spRep[0] = sp[0].load(this,R.raw.sonidosesenta,1);
        spRep[1] = sp[1].load(this,R.raw.sonidosesentayuno,1);
        spRep[2] = sp[2].load(this,R.raw.sonidosesentaydos,1);
        spRep[3] = sp[3].load(this,R.raw.sonidosesentaytres,1);
        spRep[4] = sp[4].load(this,R.raw.sonidosesentaycuatro,1);
        spRep[5] = sp[5].load(this,R.raw.sonidosesentaycinco,1);
        spRep[6] = sp[6].load(this,R.raw.sonidosesentayseis,1);
        spRep[7] = sp[7].load(this,R.raw.sonidosesentaysiete,1);
        spRep[8] = sp[8].load(this,R.raw.sonidosesentayocho,1);
        spRep[9] = sp[9].load(this,R.raw.sonidosesentaynueve,1);
    }
    public void getSonidos70(SoundPool sp[],int spRep[]){
        spRep[0] = sp[0].load(this,R.raw.sonidosetenta,1);
        spRep[1] = sp[1].load(this,R.raw.sonidosetentayuno,1);
        spRep[2] = sp[2].load(this,R.raw.sonidosetentaydos,1);
        spRep[3] = sp[3].load(this,R.raw.sonidosetentaytres,1);
        spRep[4] = sp[4].load(this,R.raw.sonidosetentaycuatro,1);
        spRep[5] = sp[5].load(this,R.raw.sonidosetentaycinco,1);
        spRep[6] = sp[6].load(this,R.raw.sonidosetentayseis,1);
        spRep[7] = sp[7].load(this,R.raw.sonidosetentaysiete,1);
        spRep[8] = sp[8].load(this,R.raw.sonidosetentayocho,1);
        spRep[9] = sp[9].load(this,R.raw.sonidosetentaynueve,1);
    }
    public void getSonidos80(SoundPool sp[],int spRep[]){
        spRep[0] = sp[0].load(this,R.raw.sonidoochenta,1);
        spRep[1] = sp[1].load(this,R.raw.sonidoochentayuno,1);
        spRep[2] = sp[2].load(this,R.raw.sonidoochentaydos,1);
        spRep[3] = sp[3].load(this,R.raw.sonidoochentaytres,1);
        spRep[4] = sp[4].load(this,R.raw.sonidoochentaycuatro,1);
        spRep[5] = sp[5].load(this,R.raw.sonidoochentaycinco,1);
        spRep[6] = sp[6].load(this,R.raw.sonidoochentayseis,1);
        spRep[7] = sp[7].load(this,R.raw.sonidoochentaysiete,1);
        spRep[8] = sp[8].load(this,R.raw.sonidoochentayocho,1);
        spRep[9] = sp[9].load(this,R.raw.sonidoochentaynueve,1);
    }
    public void getSonidos90(SoundPool sp[],int spRep[]){
        spRep[0] = sp[0].load(this,R.raw.sonidonoventa,1);
        spRep[1] = sp[1].load(this,R.raw.sonidonoventayuno,1);
        spRep[2] = sp[2].load(this,R.raw.sonidonoventaydos,1);
        spRep[3] = sp[3].load(this,R.raw.sonidonoventaytres,1);
        spRep[4] = sp[4].load(this,R.raw.sonidonoventaycuatro,1);
        spRep[5] = sp[5].load(this,R.raw.sonidonoventaycinco,1);
        spRep[6] = sp[6].load(this,R.raw.sonidonoventayseis,1);
        spRep[7] = sp[7].load(this,R.raw.sonidonoventaysiete,1);
        spRep[8] = sp[8].load(this,R.raw.sonidonoventayocho,1);
        spRep[9] = sp[9].load(this,R.raw.sonidonoventaynueve,1);
    }
}