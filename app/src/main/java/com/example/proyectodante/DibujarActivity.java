package com.example.proyectodante;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;

public class DibujarActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Dibujar dibujar = new Dibujar(this);
        setContentView(dibujar);

    }

    class Dibujar extends View {
        float x,y;
        int opc;
        Paint paint = new Paint();
        Path path = new Path();
        public Dibujar(Context context){
            super(context);

            paint.setStyle(Paint.Style.STROKE);
            paint.setStrokeWidth(10);
            paint.setColor(Color.BLACK);
        }

        protected void onDraw(Canvas canvas){
            if(opc == 1){
                path.moveTo(x,y);
            }
            if(opc == 2){
                path.lineTo(x,y);
            }
            canvas.drawPath(path,paint);
        }

        public boolean onTouchEvent(MotionEvent event){
            int action = event.getAction();
            x =  event.getX();
            y = event.getY();
            if(action == MotionEvent.ACTION_DOWN){
                opc = 1;
            }
            if(action == MotionEvent.ACTION_MOVE){
                opc = 2;
            }
            invalidate();
            return true;
        }
    }
}