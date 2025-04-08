package com.santidev.proyectodante.Manager;

import static com.santidev.proyectodante.Manager.Colores.*;

import android.widget.ImageView;

import com.santidev.proyectodante.R;

public class ColorManagerPlay {
    private final int CANT_OBJETOS = 22;

    private int[] idImagenes = new int[]{
            R.drawable.jejjirafa,
            R.drawable.sejsol,
            R.drawable.imgbanana,
            R.drawable.aejagua,
            R.drawable.mejmanzana,
            R.drawable.imagencangrejo,
            R.drawable.imagencorazon,
            R.drawable.rejrana,
            R.drawable.sejserpiente,
            R.drawable.sejsandia,
            R.drawable.nejnaranja,
            R.drawable.zejzanahoria,
            R.drawable.imagencalabaza,
            R.drawable.eneejarana,
            R.drawable.fejfantasma,
            R.drawable.oejoveja,
            R.drawable.papel,
            R.drawable.nejnieve,
            R.drawable.oejoso,
            R.drawable.imagencerdo,
            R.drawable.uejuva,
            R.drawable.imagenberenjena,
    };

    private Colores[] nombreColor = new Colores[]{
            AMARILLO,
            AMARILLO,
            AMARILLO,
            CELESTE,
            ROJO,
            ROJO,
            ROJO,
            VERDE,
            VERDE,
            VERDE,
            NARANJA,
            NARANJA,
            NARANJA,
            NEGRO,
            BLANCO,
            BLANCO,
            BLANCO,
            BLANCO,
            MARRON,
            ROSA,
            MORADO,
            MORADO
    };

    public int getCANT_OBJETOS() {
        return CANT_OBJETOS;
    }

    public int[] getIdImagenes() {
        return idImagenes;
    }

    public void setIdImagenes(int[] idImagenes) {
        this.idImagenes = idImagenes;
    }

    public Colores[] getNombreColor() {
        return nombreColor;
    }

    public void setNombreColor(Colores[] nombreColor) {
        this.nombreColor = nombreColor;
    }

    public int getIdAleatorio(){
        return (int)(Math.random()*CANT_OBJETOS+0);
    }

}
