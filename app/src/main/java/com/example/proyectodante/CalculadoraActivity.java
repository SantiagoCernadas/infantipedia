package com.example.proyectodante;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

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
        if(txtNum1.getText().toString().equals("")){
            asignarNumero(txtNum1,idNum);
        }
        else if(txtNum2.getText().toString().equals("") && !txtSigno.getText().toString().equals("")){
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
            txtNum2.setText("");
        }
        else if(!txtSigno.getText().toString().equals("")){
            txtSigno.setText("");
        }
        else if(!txtNum1.getText().toString().equals("")){
            txtNum1.setText("");
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
        switch (idNum){
            case R.id.button_num1:
                tv.setText("1");
                break;
            case R.id.button_num2:
                tv.setText("2");
                break;
            case R.id.button_num3:
                tv.setText("3");
                break;
            case R.id.button_num4:
                tv.setText("4");
                break;
            case R.id.button_num5:
                tv.setText("5");
                break;
            case R.id.button_num6:
                tv.setText("6");
                break;
            case R.id.button_num7:
                tv.setText("7");
                break;
            case R.id.button_num8:
                tv.setText("8");
                break;
            case R.id.button_num9:
                tv.setText("9");
                break;
            case R.id.button_num0:
                tv.setText("0");
                break;
            default:
                tv.setText("ERROR");
                break;
        }
    }
}