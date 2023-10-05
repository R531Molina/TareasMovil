package com.example.tareamovil1;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Calculadora extends AppCompatActivity {

    EditText txt1, txt2;
    Button btnSumar, btnRestar, btnMultiplicar, btnDividir;
    TextView lblRespuesta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txt1 = findViewById(R.id.txt1);
        txt2 = findViewById(R.id.txt2);
        btnSumar = findViewById(R.id.btnSumar);
        btnRestar = findViewById(R.id.btnRestar);
        btnMultiplicar = findViewById(R.id.btnMultiplicar);
        btnDividir = findViewById(R.id.btnDividir);
        lblRespuesta = findViewById(R.id.lblrespuesta);


        btnSumar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                calcular("+");
            }
        });

        btnRestar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                calcular("-");
            }
        });

        btnMultiplicar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                calcular("*");
            }
        });

        btnDividir.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                calcular("/");
            }
        });
    }

    private void calcular(String operador) {
        try {
            double num1 = Double.parseDouble(txt1.getText().toString());
            double num2 = Double.parseDouble(txt2.getText().toString());
            double resultado = 0;

            switch (operador) {
                case "+":
                    resultado = num1 + num2;
                    break;
                case "-":
                    resultado = num1 - num2;
                    break;
                case "*":
                    resultado = num1 * num2;
                    break;
                case "/":
                    if (num2 != 0) {
                        resultado = num1 / num2;
                    } else {
                        lblRespuesta.setText("Error: División por cero.");
                        return;
                    }
                    break;
            }

            lblRespuesta.setText("Resultado: " + resultado); // Cambio del nombre de resultadoTextView
        } catch (NumberFormatException e) {
            lblRespuesta.setText("Error: Ingrese números válidos."); // Cambio del nombre de resultadoTextView
        }
    }
}