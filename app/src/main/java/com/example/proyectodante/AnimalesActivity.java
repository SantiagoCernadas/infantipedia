package com.example.proyectodante;


import androidx.appcompat.app.AppCompatActivity;

import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import static com.example.proyectodante.MainActivity.pause;
import static com.example.proyectodante.MainActivity.start;


public class AnimalesActivity extends AppCompatActivity {
    private  SoundPool[] sp;
    private int [] sonido_reproduccion;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animales);
        sp = new SoundPool[18];
        sonido_reproduccion = new int[18];
        asignar_sonidos(sp,sonido_reproduccion);
    }

    public void sonidoAnimal(View view){


        switch (view.getId()){
            case R.id.sonido_ballena:
                reproducirSonido(0);
                break;
            case R.id.sonido_caballo:
                reproducirSonido(1);
                break;
            case R.id.sonido_cerdo:
                reproducirSonido(2);
                break;
            case R.id.sonido_delfin:
                reproducirSonido(3);
                break;
            case R.id.sonido_elefante:
                reproducirSonido(4);
                break;
            case R.id.sonido_foca:
                reproducirSonido(5);
                break;
            case R.id.sonido_gallina:
                reproducirSonido(6);
                break;
            case R.id.sonido_gato:
                reproducirSonido(7);
                break;
            case R.id.sonido_leon:
                reproducirSonido(8);
                break;
            case R.id.sonido_lobo:
                reproducirSonido(9);
                break;
            case R.id.sonido_oso:
                reproducirSonido(10);
                break;
            case R.id.sonido_oveja:
                reproducirSonido(11);
                break;
            case R.id.sonido_pato:
                reproducirSonido(12);
                break;
            case R.id.sonido_perro:
                reproducirSonido(13);
                break;
            case R.id.sonido_rana:
                reproducirSonido(14);
                break;
            case R.id.sonido_serpiente:
                reproducirSonido(15);
                break;
            case R.id.sonido_vaca:
                reproducirSonido(16);
                break;
            default:
                Toast.makeText(this, "proximamente", Toast.LENGTH_SHORT).show();
                break;
        }
    }
    public void asignar_sonidos(SoundPool[]spref, int[] sonidos_reproduccionref){

        for(int i = 0; i < spref.length;i++){
            spref[i] = new SoundPool(1,AudioManager.STREAM_MUSIC,1);
        }

        int ruta = 0;
        //ballena
        sonidos_reproduccionref[ruta] = spref[ruta].load(this,R.raw.sonidoballena,1);
        //caballo
        ruta += 1;
        sonidos_reproduccionref[ruta] = spref[ruta].load(this,R.raw.sonidocaballo,1);
        //Cerdo
        ruta += 1;
        sonidos_reproduccionref[ruta] = spref[ruta].load(this,R.raw.sonidocerdo,1);
        //Delfin
        ruta += 1;
        sonidos_reproduccionref[ruta] = spref[ruta].load(this,R.raw.sonidodelfin,1);
        //elefante
        ruta += 1;
        sonidos_reproduccionref[ruta] = spref[ruta].load(this,R.raw.sonidoelefante,1);
        //foca
        ruta += 1;
        sonidos_reproduccionref[ruta] = spref[ruta].load(this,R.raw.sonidofoca,1);
        //gallina
        ruta += 1;
        sonidos_reproduccionref[ruta] = spref[ruta].load(this,R.raw.sonidogallina,1);
        //gato
        ruta += 1;
        sonidos_reproduccionref[ruta] = spref[ruta].load(this,R.raw.sonidogato,1);
        //leon
        ruta += 1;
        sonidos_reproduccionref[ruta] = spref[ruta].load(this,R.raw.sonidoleon,1);
        //lobo
        ruta += 1;
        sonidos_reproduccionref[ruta] = spref[ruta].load(this,R.raw.sonidolobo,1);
        //oso
        ruta += 1;
        sonidos_reproduccionref[ruta] = spref[ruta].load(this,R.raw.sonidooso,1);
        //oveja
        ruta += 1;
        sonidos_reproduccionref[ruta] = spref[ruta].load(this,R.raw.sonidooveja,1);
        //pato
        ruta += 1;
        sonidos_reproduccionref[ruta] = spref[ruta].load(this,R.raw.sonidopato,1);
        //perro
        ruta += 1;
        sonidos_reproduccionref[ruta] = spref[ruta].load(this,R.raw.sonidoperro,1);
        //rana
        ruta += 1;
        sonidos_reproduccionref[ruta] = spref[ruta].load(this,R.raw.sonidorana,1);
        //serpiente
        ruta += 1;
        sonidos_reproduccionref[ruta] = spref[ruta].load(this,R.raw.sonidoserpiente,1);
        //vaca
        ruta += 1;
        sonidos_reproduccionref[ruta] = spref[ruta].load(this,R.raw.sonidovaca,1);
    }

    public void reproducirSonido(int ruta){
        sp[ruta].play(sonido_reproduccion[ruta],1,1,1,0,1);
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