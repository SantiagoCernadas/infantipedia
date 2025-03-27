package com.santidev.proyectodante;

import static com.santidev.proyectodante.MainActivity.pause;
import static com.santidev.proyectodante.MainActivity.start;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class ColoresActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_colores);
    }

    public void teclaPresionada(View view){
        switch (view.getId()){
            case R.id.button_amarillo:
                startLetraActivity("amarillo");
                break;
            default:
                startLetraActivity("ERROR");
                break;
        }
    }

    public void startLetraActivity(String color){
        Intent i = new Intent(this,LetraActivity.class);
        i.putExtra("color",color);
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