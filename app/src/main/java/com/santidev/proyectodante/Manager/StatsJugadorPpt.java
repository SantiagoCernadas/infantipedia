package com.santidev.proyectodante.Manager;

import android.widget.ImageView;
import android.widget.TextView;

public class StatsJugadorPpt {
    private int opcion;
    private int puntos;
    private ImageView imagen;
    private TextView texto;

    public int getOpcion() {
        return opcion;
    }

    public void setOpcion(int opcion) {
        this.opcion = opcion;
    }

    public int getPuntos() {
        return puntos;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

    public ImageView getImagen() {
        return imagen;
    }

    public void setImagen(ImageView imagen) {
        this.imagen = imagen;
    }

    public TextView getTexto() {
        return texto;
    }

    public void setTexto(TextView texto) {
        this.texto = texto;
    }
}
