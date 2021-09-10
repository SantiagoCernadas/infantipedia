package com.example.proyectodante;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.proyectodante.PlaysActivity.PalabraPlayActivity;

public class AbecedarioActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_abecedario);
    }

    public void teclaPresionada(View view){
        switch (view.getId()){
            case R.id.button_a:
                startLetraActivity("A");
                break;
            case R.id.button_b:
                startLetraActivity("B");
                break;
            case R.id.button_c:
                startLetraActivity("C");
                break;
            case R.id.button_d:
                startLetraActivity("D");
                break;

            case R.id.button_e:
                startLetraActivity("E");
                break;

            case R.id.button_f:
                startLetraActivity("F");
                break;

            case R.id.button_g:
                startLetraActivity("G");
                break;

            case R.id.button_h:
                startLetraActivity("H");
                break;

            case R.id.button_i:
                startLetraActivity("I");
                break;

            case R.id.button_j:
                startLetraActivity("J");
                break;

            case R.id.button_k:
                startLetraActivity("K");
                break;

            case R.id.button_L:
                startLetraActivity("L");
                break;

            case R.id.button_m:
                startLetraActivity("M");
                break;

            case R.id.button_n:
                startLetraActivity("N");
                break;

            case R.id.button_ñ:
                startLetraActivity("Ñ");
                break;

            case R.id.button_o:
                startLetraActivity("O");
                break;

            case R.id.button_p:
                startLetraActivity("P");
                break;

            case R.id.button_q:
                startLetraActivity("Q");
                break;

            case R.id.button_r:
                startLetraActivity("R");
                break;

            case R.id.button_s:
                startLetraActivity("S");
                break;

            case R.id.button_t:
                startLetraActivity("T");
                break;

            case R.id.button_u:
                startLetraActivity("U");
                break;

            case R.id.button_v:
                startLetraActivity("V");
                break;

            case R.id.button_w:
                startLetraActivity("W");
                break;

            case R.id.button_x:
                startLetraActivity("X");
                break;

            case R.id.button_y:
                startLetraActivity("Y");
                break;
            case R.id.button_z:
                startLetraActivity("Z");
                break;
            default:
                startLetraActivity("ERROR");
                break;
        }
    }

    public void startLetraActivity(String letra){
        Intent i = new Intent(this,LetraActivity.class);
        i.putExtra("letra",letra);
        startActivity(i);
    }

    public void jugarPalabra(View view){
        Intent i = new Intent(this, PalabraPlayActivity.class);
        startActivity(i);
    }
}