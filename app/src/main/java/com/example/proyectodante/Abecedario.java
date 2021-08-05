package com.example.proyectodante;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class Abecedario extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_abecedario);
    }

    public void teclaPresionada(View view){
        switch (view.getId()){
            case R.id.button_a:
                getToastMessage("a");
                break;

            case R.id.button_b:
                getToastMessage("b");
                break;
            case R.id.button_c:
                Toast.makeText(this,"c",Toast.LENGTH_SHORT).show();
                break;
            case R.id.button_d:
                break;

            case R.id.button_e:
                break;

            case R.id.button_f:
                break;

            case R.id.button_g:
                break;

            case R.id.button_h:
                break;

            case R.id.button_i:
                break;

            case R.id.button_j:
                break;

            case R.id.button_k:
                break;

            case R.id.button_L:
                break;

            case R.id.button_m:
                break;

            case R.id.button_n:
                break;

            case R.id.button_ñ:
                break;

            case R.id.button_o:
                break;

            case R.id.button_p:
                break;

            case R.id.button_q:
                break;

            case R.id.button_r:
                break;

            case R.id.button_s:
                break;

            case R.id.button_t:
                break;

            case R.id.button_u:
                break;

            case R.id.button_v:
                break;

            case R.id.button_w:
                break;

            case R.id.button_x:
                break;

            case R.id.button_y:
                break;
            case R.id.button_z:
                break;
            default:
                getToastMessage("Error Inesperado.");
                break;
        }
    }

    public void getToastMessage(String msg){
        Toast.makeText(this, msg , Toast.LENGTH_SHORT).show();
    }
}