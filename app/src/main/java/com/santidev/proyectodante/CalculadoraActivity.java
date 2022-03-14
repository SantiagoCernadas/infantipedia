package com.santidev.proyectodante;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import static com.santidev.proyectodante.MainActivity.pause;
import static com.santidev.proyectodante.MainActivity.start;

public class CalculadoraActivity extends AppCompatActivity {

    private TextView txtNum1, txtNum2, txtSigno, txtResultado, txtIgual;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculadora);
        txtNum1 = findViewById(R.id.txt_num1);
        txtNum2 = findViewById(R.id.txt_num2);
        txtSigno = findViewById(R.id.txt_signo);
        txtResultado = findViewById(R.id.txt_resultado);
        txtIgual = findViewById(R.id.txt_igual);
        txtNum1.setText("");
        txtNum2.setText("");
    }

    public void calcular(View view){
        if(txtNum1.getText().toString().equals("") || txtNum2.getText().toString().equals("")){
            Toast.makeText(this,"Porfavor ingrese dos numeros.",Toast.LENGTH_SHORT).show();
        }
        else{
            int num1Int = Integer.parseInt(txtNum1.getText().toString());
            int num2Int = Integer.parseInt(txtNum2.getText().toString());
            int resultado;
            if (txtSigno.getText().toString().equals("+")){
                resultado = num1Int + num2Int;
            }
            else if(txtSigno.getText().toString().equals("-")){
                resultado = num1Int - num2Int;
            }
            else{
                resultado = num1Int * num2Int;
            }
            txtIgual.setText("=");
            txtResultado.setText(String.valueOf(resultado));
        }
    }

    public void numPresionado(View view){
        int idNum = view.getId();
        if(txtSigno.getText().toString().equals("")){
            asignarNumero(txtNum1,idNum);
        }
        else if(txtIgual.getText().toString().equals("")){
            asignarNumero(txtNum2,idNum);
        }
    }

    public void asignarSigno(View view) {
        if (!txtNum1.getText().toString().equals("") && txtNum2.getText().toString().equals("")){
            switch (view.getId()){
                case R.id.button_sign_sumar:
                    txtSigno.setText("+");
                    break;
                case R.id.button_sign_restar:
                    txtSigno.setText("-");
                    break;
                case R.id.button_sign_mult:
                    txtSigno.setText("X");
                    break;
            }
        }


    }

    public void Retroceder(View view){

        if(!txtResultado.getText().toString().equals("")){
            txtResultado.setText("");
            txtIgual.setText("");
        }
        else if(!txtNum2.getText().toString().equals("")){
            String numAct = txtNum2.getText().toString();
            txtNum2.setText(numAct.substring(0,numAct.length()-1));
        }
        else if(!txtSigno.getText().toString().equals("")){
            txtSigno.setText("");
        }
        else if(!txtNum1.getText().toString().equals("")){
            String numAct = txtNum1.getText().toString();
            txtNum1.setText(numAct.substring(0,numAct.length()-1));
        }
    }
    public void borrarTodo(View view){
        txtNum1.setText("");
        txtNum2.setText("");
        txtSigno.setText("");
        txtIgual.setText("");
        txtResultado.setText("");
    }

    public void asignarNumero(TextView tv,int idNum){
        String numActual = tv.getText().toString();
        switch (idNum){
            case R.id.button_num1:
                tv.setText(numActual + "1");
                break;
            case R.id.button_num2:
                tv.setText(numActual + "2");
                break;
            case R.id.button_num3:
                tv.setText(numActual + "3");
                break;
            case R.id.button_num4:
                tv.setText(numActual + "4");
                break;
            case R.id.button_num5:
                tv.setText(numActual + "5");
                break;
            case R.id.button_num6:
                tv.setText(numActual + "6");
                break;
            case R.id.button_num7:
                tv.setText(numActual + "7");
                break;
            case R.id.button_num8:
                tv.setText(numActual + "8");
                break;
            case R.id.button_num9:
                tv.setText(numActual + "9");
                break;
            case R.id.button_num0 :
            case R.id.button_num01:
            case R.id.button_num02:
                tv.setText(numActual + "0");
                break;
            default:
                tv.setText("ERROR");
                break;
        }
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