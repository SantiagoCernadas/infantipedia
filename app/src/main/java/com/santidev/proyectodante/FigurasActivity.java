package com.santidev.proyectodante;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.santidev.proyectodante.PlaysActivity.HowPlayActivity;

import static com.santidev.proyectodante.MainActivity.pause;
import static com.santidev.proyectodante.MainActivity.start;

public class FigurasActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_figuras);
    }

    public void howPlayActivity(View view){
        Intent i = new Intent(this, HowPlayActivity.class);
        i.putExtra("titulo","En su lugar");
        i.putExtra("descripcion","Arrastra la figura hacia su lugar indicado!");
        i.putExtra("idimg1",R.drawable.figuraplayej1);
        i.putExtra("idimg2",R.drawable.figuraplayej2);
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