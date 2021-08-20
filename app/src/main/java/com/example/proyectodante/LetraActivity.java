package com.example.proyectodante;

import android.os.Bundle;
import android.provider.Settings;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class LetraActivity extends AppCompatActivity {

    private TextView titulo,tv1,tv2,tv3;
    private ImageView img1,img2,img3;

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
                break;
            case "B":
                tv1.setText("Barco");
                img1.setImageResource(R.drawable.bejbarco);
                tv2.setText("Ballena");
                img2.setImageResource(R.drawable.bejballena);
                tv3.setText("Bicicleta");
                img3.setImageResource(R.drawable.bejbicicleta);
                break;
            case "C":
                tv1.setText("Casa");
                img1.setImageResource(R.drawable.cejcasa);
                tv2.setText("Caramelo");
                img2.setImageResource(R.drawable.cejcaramelo);
                tv3.setText("Castillo");
                img3.setImageResource(R.drawable.cejcastillo);
                break;
            case "D":
                tv1.setText("Dado");
                img1.setImageResource(R.drawable.dejdado);
                tv2.setText("Delfin");
                img2.setImageResource(R.drawable.dejdelfin);
                tv3.setText("Dinosaurio");
                img3.setImageResource(R.drawable.dejdinosaurio);
                break;
            case "E":
                tv1.setText("Elefante");
                img1.setImageResource(R.drawable.eejelefante);
                tv2.setText("Estrella");
                img2.setImageResource(R.drawable.eejestrella);
                tv3.setText("Escalera");
                img3.setImageResource(R.drawable.eejescalera);
                break;
            case "F":
                tv1.setText("Fantasma");
                img1.setImageResource(R.drawable.fejfantasma);
                tv2.setText("Flor");
                img2.setImageResource(R.drawable.fejflor);
                tv3.setText("Fruta");
                img3.setImageResource(R.drawable.fejfruta);
                break;
            case "G":
                tv1.setText("Gato");
                img1.setImageResource(R.drawable.gejgato);
                tv2.setText("Gallina");
                img2.setImageResource(R.drawable.gejgallina);
                tv3.setText("Globo");
                img3.setImageResource(R.drawable.gejglobo);
                break;
            case "H":
                tv1.setText("Hamburguesa");
                img1.setImageResource(R.drawable.hejhamburguesa);
                tv2.setText("Helado");
                img2.setImageResource(R.drawable.hejhelado);
                tv3.setText("Helicóptero");
                img3.setImageResource(R.drawable.hejhelicoptero);
                break;
            case "I":
                tv1.setText("Indio");
                img1.setImageResource(R.drawable.iejindio);
                tv2.setText("Isla");
                img2.setImageResource(R.drawable.iejisla);
                tv3.setText("Iglú");
                img3.setImageResource(R.drawable.iejiglu);
                break;
            case "J":
                tv1.setText("Jirafa");
                img1.setImageResource(R.drawable.jejjirafa);
                tv2.setText("Jugo");
                img2.setImageResource(R.drawable.jejjugo);
                tv3.setText("Juguete");
                img3.setImageResource(R.drawable.jejjuguete);
                break;
            case "K":
                tv1.setText("Kiwi");
                img1.setImageResource(R.drawable.kejkiwi);
                tv2.setText("Koala");
                img2.setImageResource(R.drawable.kejkoala);
                tv3.setText("Ketchup");
                img3.setImageResource(R.drawable.kejketchup);
                break;
            case "L":
                tv1.setText("Leche");
                img1.setImageResource(R.drawable.lejleche);
                tv2.setText("Leon");
                img2.setImageResource(R.drawable.lejleon);
                tv3.setText("Libro");
                img3.setImageResource(R.drawable.lejlibro);
                break;
            case "M":
                tv1.setText("Manzana");
                tv2.setText("Mapa");
                tv3.setText("Mesa");
                setImagenes(R.drawable.mejmanzana,R.drawable.mejmapa,R.drawable.mejmesa);
                break;
            case "N":
                tv1.setText("Naranja");
                tv2.setText("Niño y Niña");
                tv3.setText("Nieve");
                setImagenes(R.drawable.nejnaranja,R.drawable.nejninioyninia,R.drawable.nejnieve);
                break;
            case "Ñ":
                tv1.setText("Ñandu");
                tv2.setText("Ñoquis");
                tv3.setText("araÑa (contiene Ñ)");
                setImagenes(R.drawable.enejnandu,R.drawable.eneejnoquis,R.drawable.eneejarana);
                break;
            case "O":
                tv1.setText("Oso");
                tv2.setText("Oreja");
                tv3.setText("Oveja");
                setImagenes(R.drawable.oejoso,R.drawable.oejoreja,R.drawable.oejoveja);
                break;
            case "P":
                tv1.setText("Pera");
                tv2.setText("Pez");
                tv3.setText("Pelota");
                setImagenes(R.drawable.pejpera,R.drawable.pejpez,R.drawable.pejpelota);
                break;
            case "Q":
                tv1.setText("Queso");
                tv2.setText("Quimica");
                tv3.setText("Quesadilla");
                setImagenes(R.drawable.qejqueso,R.drawable.qejquimica,R.drawable.qejquesadilla);
                break;
            case "R":
                tv1.setText("Rana");
                tv2.setText("Rio");
                tv3.setText("Rueda");
                setImagenes(R.drawable.rejrana,R.drawable.rejrio,R.drawable.rejrueda);
                break;
            case "S":
                tv1.setText("Sandia");
                tv2.setText("Serpiente");
                tv3.setText("Sol");
                setImagenes(R.drawable.sejsandia,R.drawable.sejserpiente,R.drawable.sejsol);
                break;
            case "T":
                tv1.setText("Taza");
                tv2.setText("Tigre");
                tv3.setText("Titere");
                setImagenes(R.drawable.tejtaza,R.drawable.tejtigre,R.drawable.tejtitere);
                break;
            case "U":
                tv1.setText("Uña");
                tv2.setText("Uva");
                tv3.setText("Unicornio");
                setImagenes(R.drawable.uejuna,R.drawable.uejuva,R.drawable.uejunicornio);
                break;
            case "V":
                tv1.setText("Vaca");
                tv2.setText("Vela");
                tv3.setText("Volcan");
                setImagenes(R.drawable.vejvaca,R.drawable.vejvela,R.drawable.vejvolcan);
                break;
            case "W":
                tv1.setText("Waterpolo");
                tv2.setText("Waffle");
                tv3.setText("Wi-Fi");
                setImagenes(R.drawable.wejwaterpolo,R.drawable.wejwaffle,R.drawable.wejwifi);

                break;
            case "X":
                tv1.setText("Xilofono");
                tv2.setText("taXi (contiene X)");
                tv3.setText("eXtraterrestre (contiene X)");
                setImagenes(R.drawable.xejxilofono,R.drawable.xejtaxi,R.drawable.xejextraterrestre);
                break;
            case "Y":
                tv1.setText("Yoyo");
                tv2.setText("Yogurt");
                tv3.setText("Yoga");
                setImagenes(R.drawable.yejyoyo,R.drawable.yejyogurt,R.drawable.yejyoga);
                break;
            case "Z":
                tv1.setText("Zapato");
                tv2.setText("Zanahoria");
                tv3.setText("Zorro");
                setImagenes(R.drawable.zejzapato,R.drawable.zejzanahoria,R.drawable.zejzorro);
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

}