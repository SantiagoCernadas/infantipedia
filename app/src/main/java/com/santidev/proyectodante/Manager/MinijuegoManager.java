package com.santidev.proyectodante.Manager;

import android.widget.Button;
import android.widget.TextView;

public class MinijuegoManager {
    private int vidas,puntos,pistas;
    private TextView vidasTxt,puntosTxt,txtPista,txtCantPistas;
    private Button pista;

    public MinijuegoManager(int vidas, int puntos, int pistas
                            ,TextView vidasTxt, TextView puntosTxt,
                            TextView txtPista, TextView txtCantPistas, Button pista) {
        this.vidas = vidas;
        this.puntos = puntos;
        this.pistas = pistas;
        this.vidasTxt = vidasTxt;
        this.puntosTxt = puntosTxt;
        this.txtPista = txtPista;
        this.txtCantPistas = txtCantPistas;
        this.pista = pista;

        txtPista.setText("");
        pista.setEnabled(true);
        txtCantPistas.setText(String.valueOf(pistas));

        puntosTxt.setText("Puntos = " + puntos + " ");
        vidasTxt.setText("Vidas = " + vidas);
        txtCantPistas.setText(String.valueOf(pistas));
    }

    public int getVidas() {
        return vidas;
    }

    public void setVidas(int vidas) {
        this.vidas = vidas;
    }

    public int getPuntos() {
        return puntos;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

    public int getPistas() {
        return pistas;
    }

    public void setPistas(int pistas) {
        this.pistas = pistas;
    }

    public TextView getVidasTxt() {
        return vidasTxt;
    }

    public void setVidasTxt(TextView vidasTxt) {
        this.vidasTxt = vidasTxt;
    }

    public TextView getPuntosTxt() {
        return puntosTxt;
    }

    public void setPuntosTxt(TextView puntosTxt) {
        this.puntosTxt = puntosTxt;
    }

    public TextView getTxtPista() {
        return txtPista;
    }

    public void setTxtPista(TextView txtPista) {
        this.txtPista = txtPista;
    }

    public TextView getTxtCantPistas() {
        return txtCantPistas;
    }

    public void setTxtCantPistas(TextView txtCantPistas) {
        this.txtCantPistas = txtCantPistas;
    }

    public Button getPista() {
        return pista;
    }

    public void setPista(Button pista) {
        this.pista = pista;
    }

    public void sumarPunto(){
        puntos++;
        puntosTxt.setText("Puntos = " + puntos + " ");
    }

    public void restarVida(){
        vidas--;
        vidasTxt.setText("Vidas = " + vidas);
    }

    public void sumarPista(){
        pistas++;
        txtCantPistas.setText(String.valueOf(pistas));
        txtPista.setText("+1 pista!");
    }

    public void restarPísta(){
        pistas--;
        txtCantPistas.setText(String.valueOf(pistas));
    }

    public boolean sinVidas(){
        return vidas < 1;
    }


}
