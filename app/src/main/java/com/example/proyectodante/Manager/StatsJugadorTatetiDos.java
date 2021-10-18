package com.example.proyectodante.Manager;

import android.widget.TextView;

public class StatsJugadorTatetiDos extends StatsJugadorTateti{
    private String signo;
    private String stringColor;
    private int tableroJugador;
    private int linea;
    private String nombre;

    public String getSigno() {
        return signo;
    }

    public void setSigno(String signo) {
        this.signo = signo;
    }

    public String getStringColor() {
        return stringColor;
    }

    public void setStringColor(String stringColor) {
        this.stringColor = stringColor;
    }

    public int getTableroJugador() {
        return tableroJugador;
    }

    public void setTableroJugador(int tableroJugador) {
        this.tableroJugador = tableroJugador;
    }

    public int getLinea() {
        return linea;
    }

    public void setLinea(int linea) {
        this.linea = linea;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public StatsJugadorTatetiDos(TextView puntosMsg, String signo, String color, int tableroJugador, int linea, String nombre) {
        super(puntosMsg);
        this.signo = signo;
        stringColor = color;
        this.tableroJugador = tableroJugador;
        this.linea = linea;
        this.nombre = nombre;
    }
}
