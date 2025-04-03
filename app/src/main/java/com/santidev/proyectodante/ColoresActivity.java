package com.santidev.proyectodante;

import static com.santidev.proyectodante.MainActivity.pause;
import static com.santidev.proyectodante.MainActivity.start;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.santidev.proyectodante.PlaysActivity.HowPlayActivity;

public class ColoresActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_colores);
    }

    public void teclaPresionada(View view){
        switch (view.getId()){
            case R.id.button_amarillo:
                startColorActivity("Amarillo","#FFEB3B"
                        ,"Jirafa","Sol","Banana",
                        R.drawable.jejjirafa,R.drawable.sejsol,R.drawable.imgbanana
                        , R.raw.audioamarillo);
                break;
            case R.id.button_celeste:
                startColorActivity("Celeste","#00BCD4"
                        ,"Ballena","Agua","Iglú",
                        R.drawable.bejballena,R.drawable.aejagua,R.drawable.iejiglu
                        , R.raw.audioceleste);
                break;
            case R.id.button_rojo:
                startColorActivity("Rojo","#DA0000"
                        ,"Manzana","Cangrejo","Corazón",
                        R.drawable.mejmanzana,R.drawable.imagencangrejo,R.drawable.imagencorazon
                        , R.raw.audiorojo);
                break;
            case R.id.button_verde:
                startColorActivity("Verde","#8BC34A"
                        ,"Rana","Serpiente","Sandia",
                        R.drawable.rejrana,R.drawable.sejserpiente,R.drawable.sejsandia
                        , R.raw.audioverde);
                break;
            case R.id.button_naranja:
                startColorActivity("Naranja","#FF9800"
                        ,"Naranja","Zanahoria","Calabaza",
                        R.drawable.nejnaranja,R.drawable.zejzanahoria,R.drawable.imagencalabaza
                        , R.raw.audionaranjacolor);
                break;
            case R.id.button_negro:
                startColorActivity("Negro","#000000"
                        ,"Araña","Gato","Sombrero",
                        R.drawable.eneejarana,R.drawable.imagengatonegro,R.drawable.imagensombrero
                        , R.raw.audionegro);
                break;
            case R.id.button_blanco:
                startColorActivity("Blanco","#FFFFFF"
                        ,"Fantasma","Oveja","Papel",
                        R.drawable.fejfantasma,R.drawable.oejoveja,R.drawable.papel
                        , R.raw.audioblanco);
                break;
            case R.id.button_marron:
                startColorActivity("Marron","#6C3B2A"
                        ,"Arbol","Oso","Perro",
                        R.drawable.aejarbol,R.drawable.oejoso,R.drawable.imagenperro
                        , R.raw.audiomarron);
                break;
            case R.id.button_rosa:
                startColorActivity("Rosa","#FF0080"
                        ,"Cerdo","Helado","Dona",
                        R.drawable.imagencerdo,R.drawable.imagenheladorosa,R.drawable.imagendona
                        , R.raw.audiorosa);
                break;
            case R.id.button_azul:
                startColorActivity("Azul" ,"#0037A4"
                        ,"Dado","Delfin","Helicoptero",
                        R.drawable.dejdado,R.drawable.dejdelfin,R.drawable.hejhelicoptero
                        , R.raw.audioazul);
                break;
            case R.id.button_morado:
                startColorActivity("Morado","#673AB7"
                        ,"Uva","Berenjena","Pulpo",
                        R.drawable.uejuva,R.drawable.imagenberenjena,R.drawable.imagenpulpo
                        , R.raw.audiomorado);
                break;
            default:
                Toast.makeText(this,"Color no encontrado.",Toast.LENGTH_SHORT).show();
                break;
        }
    }

    public void startColorActivity(String color, String colorHex,
                                   String nombre1, String nombre2, String nombre3
                                    , int idImg1, int idImg2, int idImg3,
                                   int audio){

        Intent i = new Intent(this,ColorActivity.class);
        i.putExtra("color",color);
        i.putExtra("colorHex",colorHex);

        i.putExtra("nombre1",nombre1);
        i.putExtra("nombre2",nombre2);
        i.putExtra("nombre3",nombre3);

        i.putExtra("idImg1",idImg1);
        i.putExtra("idImg2",idImg2);
        i.putExtra("idImg3",idImg3);
        i.putExtra("audio",audio);

        startActivity(i);
    }

    public void howPlayActivity(View view){
        Intent i = new Intent(this, HowPlayActivity.class);
        i.putExtra("titulo","¿Que color?");
        i.putExtra("descripcion","Un objeto, varios colores. ¡Solo uno es correcto!");
        i.putExtra("idimg1",R.drawable.palabraplayej1);
        i.putExtra("idimg2",R.drawable.palabraplayej2);
        startActivity(i);
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