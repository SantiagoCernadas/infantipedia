package com.example.proyectodante;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class TablasActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tablas);
    }

    public void numTablaActivity(View view){
        Intent i = new Intent(this,NumTablaActivity.class);
        switch (view.getId()){
            case R.id.tablas_1:
                i.putExtra("numero",1);
                break;
            case R.id.tablas_2:
                i.putExtra("numero",2);
                break;
            case R.id.tablas_3:
                i.putExtra("numero",3);
                break;
            case R.id.tablas_4:
                i.putExtra("numero",4);
                break;
            case R.id.tablas_5:
                i.putExtra("numero",5);
                break;
            case R.id.tablas_6:
                i.putExtra("numero",6);
                break;
            case R.id.tablas_7:
                i.putExtra("numero",7);
                break;
            case R.id.tablas_8:
                i.putExtra("numero",8);
                break;
            case R.id.tablas_9:
                i.putExtra("numero",9);
                break;
            case R.id.tablas_10:
                i.putExtra("numero",10);
                break;
        }
        startActivity(i);
    }
}