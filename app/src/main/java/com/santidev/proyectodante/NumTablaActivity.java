package com.santidev.proyectodante;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import static com.santidev.proyectodante.MainActivity.pause;
import static com.santidev.proyectodante.MainActivity.start;

public class NumTablaActivity extends AppCompatActivity {
    private int numero;
    private TextView tv[];
    private TextView tv_titulo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_num_tabla);
       numero = getIntent().getIntExtra("numero",0);
       tv_titulo = findViewById(R.id.txt_tabla_titulo);
       tv = new TextView[10];
       conectarIDNums();
       tv_titulo.setText("Tabla del " + numero);
       setTextTabla();
    }

    private void setTextTabla() {
        for(int i = 0;i < 10;i++){
            tv[i].setText(numero + " x " + (i+1) + " = " + (numero*(i+1)) + " ");
        }
    }

    private void conectarIDNums() {
        tv[0] = findViewById(R.id.tabla_ec_1);
        tv[1] = findViewById(R.id.tabla_ec_2);
        tv[2] = findViewById(R.id.tabla_ec_3);
        tv[3] = findViewById(R.id.tabla_ec_4);
        tv[4] = findViewById(R.id.tabla_ec_5);
        tv[5] = findViewById(R.id.tabla_ec_6);
        tv[6] = findViewById(R.id.tabla_ec_7);
        tv[7] = findViewById(R.id.tabla_ec_8);
        tv[8] = findViewById(R.id.tabla_ec_9);
        tv[9] = findViewById(R.id.tabla_ec_10);
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