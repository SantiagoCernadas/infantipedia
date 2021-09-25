package com.example.proyectodante;

import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class LetraActivity extends AppCompatActivity {

    private TextView titulo,tv1,tv2,tv3;
    private ImageView img1,img2,img3;
    private SoundPool sp1,sp2,sp3;
    private int sRep1,sRep2,sRep3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_letra);
        String letraSeleccionada = getIntent().getStringExtra("letra");

        titulo = findViewById(R.id.txt_letra_titulo);
        tv1 = findViewById(R.id.txt_letra_ej1);
        tv2 = findViewById(R.id.txt_letra_ej2);
        tv3 = findViewById(R.id.txt_letra_ej3);
        img1 = findViewById(R.id.img_ej1);
        img2 = findViewById(R.id.img_ej2);
        img3 = findViewById(R.id.img_ej3);


        titulo.setText("Letra " + letraSeleccionada);
        generarActivity(letraSeleccionada);
    }

    public void generarActivity(String letra){
        switch (letra){
            case "A":
                setPalabras("Arbol","Abeja","Agua");
                setImagenes(R.drawable.aejarbol,R.drawable.aejabeja,R.drawable.aejagua);
                setSonidos(R.raw.audioarbol,R.raw.audioabeja,R.raw.audioagua);
                break;
            case "B":
                setPalabras("Barco","Ballena","Bicicleta");
                setImagenes(R.drawable.bejbarco,R.drawable.bejballena,R.drawable.bejbicicleta);
                setSonidos(R.raw.audiobarco,R.raw.audioballena,R.raw.audiobicicleta);
                break;
            case "C":
                tv1.setText("Casa");
                img1.setImageResource(R.drawable.cejcasa);
                tv2.setText("Caramelo");
                img2.setImageResource(R.drawable.cejcaramelo);
                tv3.setText("Castillo");
                img3.setImageResource(R.drawable.cejcastillo);
                setSonidos(R.raw.audiocasa,R.raw.audiocaramelo,R.raw.audiocastillo);
                break;
            case "D":
                tv1.setText("Dado");
                img1.setImageResource(R.drawable.dejdado);
                tv2.setText("Delfín");
                img2.setImageResource(R.drawable.dejdelfin);
                tv3.setText("Dinosaurio");
                img3.setImageResource(R.drawable.dejdinosaurio);
                setSonidos(R.raw.audiodado,R.raw.audiodelfin,R.raw.audiodinosaurio);
                break;
            case "E":
                tv1.setText("Elefante");
                img1.setImageResource(R.drawable.eejelefante);
                tv2.setText("Estrella");
                img2.setImageResource(R.drawable.eejestrella);
                tv3.setText("Escalera");
                img3.setImageResource(R.drawable.eejescalera);
                setSonidos(R.raw.audioelefante,R.raw.audioestrella,R.raw.audioescalera);
                break;
            case "F":
                tv1.setText("Fantasma");
                img1.setImageResource(R.drawable.fejfantasma);
                tv2.setText("Flor");
                img2.setImageResource(R.drawable.fejflor);
                tv3.setText("Frutas");
                img3.setImageResource(R.drawable.fejfruta);
                setSonidos(R.raw.audiofantasma,R.raw.audioflor,R.raw.audiofrutas);
                break;
            case "G":
                tv1.setText("Gato");
                img1.setImageResource(R.drawable.gejgato);
                tv2.setText("Gallina");
                img2.setImageResource(R.drawable.gejgallina);
                tv3.setText("Globo");
                img3.setImageResource(R.drawable.gejglobo);
                setSonidos(R.raw.audiogato,R.raw.audiogallina,R.raw.audioglobo);
                break;
            case "H":
                tv1.setText("Hamburguesa");
                img1.setImageResource(R.drawable.hejhamburguesa);
                tv2.setText("Helado");
                img2.setImageResource(R.drawable.hejhelado);
                tv3.setText("Helicóptero");
                img3.setImageResource(R.drawable.hejhelicoptero);
                setSonidos(R.raw.audiohamgurguesa,R.raw.audiohelado,R.raw.audiohelicoptero);
                break;
            case "I":
                tv1.setText("Indio");
                img1.setImageResource(R.drawable.iejindio);
                tv2.setText("Isla");
                img2.setImageResource(R.drawable.iejisla);
                tv3.setText("Iglú");
                img3.setImageResource(R.drawable.iejiglu);
                setSonidos(R.raw.audioindio,R.raw.audioisla,R.raw.audioiglu);
                break;
            case "J":
                tv1.setText("Jirafa");
                img1.setImageResource(R.drawable.jejjirafa);
                tv2.setText("Jugo");
                img2.setImageResource(R.drawable.jejjugo);
                tv3.setText("Juguetes");
                img3.setImageResource(R.drawable.jejjuguete);
                setSonidos(R.raw.audiojirafa,R.raw.audiojugo,R.raw.audiojuguetes);
                break;
            case "K":
                tv1.setText("Kiwi");
                img1.setImageResource(R.drawable.kejkiwi);
                tv2.setText("Koala");
                img2.setImageResource(R.drawable.kejkoala);
                tv3.setText("Kétchup");
                img3.setImageResource(R.drawable.kejketchup);
                setSonidos(R.raw.audiokiwi,R.raw.audiokoala,R.raw.audioketchup);
                break;
            case "L":
                tv1.setText("Leche");
                img1.setImageResource(R.drawable.lejleche);
                tv2.setText("León");
                img2.setImageResource(R.drawable.lejleon);
                tv3.setText("Libro");
                img3.setImageResource(R.drawable.lejlibro);
                setSonidos(R.raw.audioleche,R.raw.audioleon,R.raw.audiolibro);
                break;
            case "M":
                tv1.setText("Manzana");
                tv2.setText("Mapa");
                tv3.setText("Mesa");
                setImagenes(R.drawable.mejmanzana,R.drawable.mejmapa,R.drawable.mejmesa);
                setSonidos(R.raw.audiomanzana,R.raw.audiomapa,R.raw.audiomesa);
                break;
            case "N":
                tv1.setText("Naranja");
                tv2.setText("Niño y Niña");
                tv3.setText("Nieve");
                setImagenes(R.drawable.nejnaranja,R.drawable.nejninioyninia,R.drawable.nejnieve);
                setSonidos(R.raw.audionaranja,R.raw.audininoynina,R.raw.audionieve);
                break;
            case "Ñ":
                tv1.setText("Ñandú");
                tv2.setText("Ñoquis");
                tv3.setText("araÑa    (contiene Ñ)");
                setImagenes(R.drawable.enejnandu,R.drawable.eneejnoquis,R.drawable.eneejarana);
                setSonidos(R.raw.audionandu,R.raw.audionoquis,R.raw.audioarana);
                break;
            case "O":
                tv1.setText("Oso");
                tv2.setText("Oreja");
                tv3.setText("Oveja");
                setImagenes(R.drawable.oejoso,R.drawable.oejoreja,R.drawable.oejoveja);
                setSonidos(R.raw.audiooso,R.raw.audiooreja,R.raw.audiooveja);
                break;
            case "P":
                tv1.setText("Pera");
                tv2.setText("Pez");
                tv3.setText("Pelota");
                setImagenes(R.drawable.pejpera,R.drawable.pejpez,R.drawable.pejpelota);
                setSonidos(R.raw.audiopera,R.raw.audiopez,R.raw.audiopelota);
                break;
            case "Q":
                tv1.setText("Queso");
                tv2.setText("Química");
                tv3.setText("Quesadilla");
                setImagenes(R.drawable.qejqueso,R.drawable.qejquimica,R.drawable.qejquesadilla);
                setSonidos(R.raw.audioqueso,R.raw.audioquimica,R.raw.audioquesadilla);
                break;
            case "R":
                tv1.setText("Rana");
                tv2.setText("Río");
                tv3.setText("Rueda");
                setImagenes(R.drawable.rejrana,R.drawable.rejrio,R.drawable.rejrueda);
                setSonidos(R.raw.audiorana,R.raw.audiorio,R.raw.audiorueda);
                break;
            case "S":
                tv1.setText("Sandía");
                tv2.setText("Serpiente");
                tv3.setText("Sol");
                setImagenes(R.drawable.sejsandia,R.drawable.sejserpiente,R.drawable.sejsol);
                setSonidos(R.raw.audiosandia,R.raw.audioserpiente,R.raw.audiosol);
                break;
            case "T":
                tv1.setText("Taza");
                tv2.setText("Tigre");
                tv3.setText("Títere");
                setImagenes(R.drawable.tejtaza,R.drawable.tejtigre,R.drawable.tejtitere);
                setSonidos(R.raw.audiotaza,R.raw.audiotigre,R.raw.audiotitere);
                break;
            case "U":
                tv1.setText("Uña");
                tv2.setText("Uva");
                tv3.setText("Unicornio");
                setImagenes(R.drawable.uejuna,R.drawable.uejuva,R.drawable.uejunicornio);
                setSonidos(R.raw.audiouna,R.raw.audiouva,R.raw.audiounicornio);
                break;
            case "V":
                tv1.setText("Vaca");
                tv2.setText("Vela");
                tv3.setText("Volcán");
                setImagenes(R.drawable.vejvaca,R.drawable.vejvela,R.drawable.vejvolcan);
                setSonidos(R.raw.audiovaca,R.raw.audiovela,R.raw.audiovolcan);
                break;
            case "W":
                tv1.setText("Waterpolo");
                tv2.setText("Waffle");
                tv3.setText("Wi-Fi");
                setImagenes(R.drawable.wejwaterpolo,R.drawable.wejwaffle,R.drawable.wejwifi);
                setSonidos(R.raw.audiowaterpolo,R.raw.audiowaffle,R.raw.audiowifi);

                break;
            case "X":
                tv1.setText("Xilófono");
                tv2.setText("taXi (contiene X)");
                tv3.setText("eXtraterrestre (contiene X)");
                setImagenes(R.drawable.xejxilofono,R.drawable.xejtaxi,R.drawable.xejextraterrestre);
                setSonidos(R.raw.audioxilofono,R.raw.audiotaxi,R.raw.audioextraterrestre);
                break;
            case "Y":
                tv1.setText("Yoyo");
                tv2.setText("Yogurt");
                tv3.setText("Yoga");
                setImagenes(R.drawable.yejyoyo,R.drawable.yejyogurt,R.drawable.yejyoga);
                setSonidos(R.raw.audioyoyo,R.raw.audioyogurt,R.raw.audioyoga);
                break;
            case "Z":
                tv1.setText("Zapatos");
                tv2.setText("Zanahoria");
                tv3.setText("Zorro");
                setImagenes(R.drawable.zejzapato,R.drawable.zejzanahoria,R.drawable.zejzorro);
                setSonidos(R.raw.audiozapatos,R.raw.audiozanahoria,R.raw.audiozorro);
                break;
            default:
                tv1.setText("Proximamente");
                tv2.setText("");
                tv3.setText("");
                break;
        }
    }

    public void setPalabras(String palabra1,String palabra2, String palabra3){
        tv1.setText(palabra1);
        tv2.setText(palabra2);
        tv3.setText(palabra3);
    }

    public void setImagenes(int idImg1,int idImg2, int idImg3){
        img1.setImageResource(idImg1);
        img2.setImageResource(idImg2);
        img3.setImageResource(idImg3);
    }
    public void setSonidos(int idSon1,int idSon2, int idSon3){
        sp1 = new SoundPool(1, AudioManager.STREAM_MUSIC,1);
        sp2 = new SoundPool(1, AudioManager.STREAM_MUSIC,1);
        sp3 = new SoundPool(1, AudioManager.STREAM_MUSIC,1);
        sRep1 = sp1.load(this,idSon1,1);
        sRep2 = sp2.load(this,idSon2,1);
        sRep3 = sp3.load(this,idSon3,1);
    }

    public void repSon1(View view){
        sp1.play(sRep1,1,1,1,0,1);
    }
    public void repSon2(View view){
        sp2.play(sRep2,1,1,1,0,1);
    }
    public void repSon3(View view){
        sp3.play(sRep3,1,1,1,0,1);
    }
}