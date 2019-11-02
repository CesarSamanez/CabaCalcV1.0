package com.example.cabacalc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Portada extends AppCompatActivity {

    Button continuar;
    EditText name, dia, mes, año;
    public static final String data1 = "nombre";
    public static final String data2 = "dia";
    public static final String data3 = "mes";
    public static final String data4 = "año";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_portada);

        continuar = (Button) findViewById(R.id.btnContinuar);
        continuar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                continuar(v);
            }
        });

        name = (EditText) findViewById(R.id.txtName);
        dia = (EditText) findViewById(R.id.txtDia);
        mes = (EditText) findViewById(R.id.txtMes);
        año = (EditText) findViewById(R.id.txtAño);

    }

    public void continuar(View view) {
        if (name.getText().toString().isEmpty() || dia.getText().toString().isEmpty() || mes.getText().toString().isEmpty() || año.getText().toString().isEmpty()) {
            Toast.makeText(this, R.string.error, Toast.LENGTH_SHORT).show();
        } else if (Integer.parseInt(dia.getText().toString()) > 31) {
            Toast.makeText(this, R.string.errorDias, Toast.LENGTH_SHORT).show();
        } else if (Integer.parseInt(mes.getText().toString()) > 12) {
            Toast.makeText(this, R.string.errorMes, Toast.LENGTH_SHORT).show();
        } else if (Integer.parseInt(año.getText().toString()) > 2019 || Integer.parseInt(año.getText().toString()) < 1900) {
            Toast.makeText(this, R.string.errorAño, Toast.LENGTH_SHORT).show();
        } else {

            Intent intent = new Intent(this, Index.class);
            String msjdata1 = name.getText().toString();
            String msjdata2 = dia.getText().toString();
            String msjdata3 = mes.getText().toString();
            String msjdata4 = año.getText().toString();

            intent.putExtra(data1, msjdata1);
            intent.putExtra(data2, msjdata2);
            intent.putExtra(data3, msjdata3);
            intent.putExtra(data4, msjdata4);

            startActivity(intent);
        }
    }

    //Desactivar boton de atras
    @Override
    public void onBackPressed() {
    }

}