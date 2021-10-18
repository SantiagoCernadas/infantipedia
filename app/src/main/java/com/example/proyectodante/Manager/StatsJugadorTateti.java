package com.example.proyectodante.Manager;

import android.widget.TextView;

public class StatsJugadorTateti {
    private int puntos;

    public int getPuntos() {
        return puntos;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

    public TextView getPuntosMsg() {
        return puntosMsg;
    }

    public void setPuntosMsg(TextView puntosMsg) {
        this.puntosMsg = puntosMsg;
    }

    private TextView puntosMsg;

    public StatsJugadorTateti(TextView puntosMsg){
        puntos = 0;
        this.puntosMsg = puntosMsg;
    }
}
