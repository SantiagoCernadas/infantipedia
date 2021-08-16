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
                tv1.setText("Arbol");
                img1.setImageResource(R.drawable.aejarbol);
                tv2.setText("Abeja");
                img2.setImageResource(R.drawable.aejabeja);
                tv3.setText("Agua");
                img3.setImageResource(R.drawable.aejagua);
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
                tv2.setText("Caramelo");
                tv3.setText("Castillo");
                break;
            case "D":
                tv1.setText("Dado");
                tv2.setText("Delfin");
                tv3.setText("Dinosaurio");
                break;
            case "E":
                tv1.setText("Elefante");
                tv2.setText("Estrella");
                tv3.setText("Escalera");
                break;
            case "F":
                tv1.setText("Fantasma");
                tv2.setText("Flor");
                tv3.setText("Fruta");
                break;
            case "G":
                tv1.setText("Gato");
                tv2.setText("Gallina");
                tv3.setText("Globo");
                break;
            case "H":
                tv1.setText("Hamburguesa");
                tv2.setText("Helado");
                tv3.setText("Hielo");
                break;
            case "I":
                tv1.setText("Indio");
                tv2.setText("Isla");
                tv3.setText("Invierno");
                break;
            case "J":
                tv1.setText("Jirafa");
                tv2.setText("Jugo");
                tv3.setText("Juguete");
                break;
            case "K":
                tv1.setText("Kiwi");
                tv2.setText("Koala");
                tv3.setText("Ketchup");
                break;
            case "L":
                tv1.setText("Leche");
                tv2.setText("Leon");
                tv3.setText("Libro");
                break;
            case "M":
                tv1.setText("Madre");
                tv2.setText("Mapa");
                tv3.setText("Mesa");
                break;
            case "N":
                tv1.setText("Naranja");
                tv2.setText("Niño y Niña");
                tv3.setText("Nieve");
                break;
            case "Ñ":
                tv1.setText("Ñandu");
                tv2.setText("Ñoquis");
                tv3.setText("araÑa (contiene Ñ)");
                break;
            case "O":
                tv1.setText("Oso");
                tv2.setText("Oreja");
                tv3.setText("Oveja");
                break;
            case "P":
                tv1.setText("Pera");
                tv2.setText("Pez");
                tv3.setText("Pelota");
                break;
            case "Q":
                tv1.setText("Queso");
                tv2.setText("Quimica");
                tv3.setText("Quemado");
                break;
            case "R":
                tv1.setText("Rana");
                tv2.setText("Rio");
                tv3.setText("Rueda");
                break;
            case "S":
                tv1.setText("Sandia");
                tv2.setText("Serpiente");
                tv3.setText("Sol");
                break;
            case "T":
                tv1.setText("Taza");
                tv2.setText("Tigre");
                tv3.setText("Titere");
                break;
            case "U":
                tv1.setText("Uña");
                tv2.setText("Uva");
                tv3.setText("Unicornio");
                break;
            case "V":
                tv1.setText("Vaca");
                tv2.setText("Vela");
                tv3.setText("Volcan");
                break;
            case "W":
                tv1.setText("Waterpolo");
                tv2.setText("Waffle");
                tv3.setText("Wi-fi");
                break;
            case "X":
                tv1.setText("Xilofono");
                tv2.setText("taXi (contiene X)");
                tv3.setText("eXtraterrestre (contiene X)");
                break;
            case "Y":
                tv1.setText("Yoyo");
                tv2.setText("Yogurt");
                tv3.setText("Yoga");
                break;
            case "Z":
                tv1.setText("Zapato");
                tv2.setText("Zanahoria");
                tv3.setText("Zorro");
                break;
            default:
                tv1.setText("Proximamente");
                tv2.setText("");
                tv3.setText("");
                break;
        }
    }
}