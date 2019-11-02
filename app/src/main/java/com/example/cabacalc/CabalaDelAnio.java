package com.example.cabacalc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class CabalaDelAnio extends AppCompatActivity {

    TextView name, contenido, fecha;
    static String nombre, año;
    static String cabalaDelAño = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cabala_del_anio);
        cabalaDelAño = "";

        Intent intent = getIntent();
        nombre = intent.getStringExtra(Index.data1);
        año = intent.getStringExtra(Index.data4);


        name = (TextView) findViewById(R.id.txtNombre);
        contenido = (TextView) findViewById(R.id.txtContenido);
        fecha = (TextView) findViewById(R.id.txtFecha);

        name.setText(nombre);
        fecha.setText("Fecha de nacimiento " + año);
        CabalaDelAño();
        contenido.setText(cabalaDelAño);
    }

    public static void CabalaDelAño() {
        int fecha1, fecha2;
        fecha1 = Integer.parseInt(año) + sumaTodo(año);
        int aux1 = sumaTodo("" + fecha1);
        cabalaDelAño += "Ver arcano " + aux1 + "\n";
        String sum1 = "" + aux1;
        int sum = 0;
        while (sum1.length() != 1) {
            sum = suma(sum1);
            sum1 = "" + sum;
        }
        cabalaDelAño += "Ver arcano " + sum + "\n";
        fecha2 = Integer.parseInt("" + fecha1) + sumaTodo("" + fecha1);
        int aux2 = sumaTodo("" + fecha2);
        cabalaDelAño += "Ver arcano " + aux2 + "\n";
        String sum2 = "" + aux2;
        int sum3 = 0;
        while (sum2.length() != 1) {
            sum3 = suma(sum2);
            sum2 = "" + sum3;
        }
        cabalaDelAño += "Ver arcano " + sum3 + "\n";

        int fecha3 = Integer.parseInt("" + fecha2) + sumaTodo("" + fecha2);
        int aux3 = sumaTodo("" + fecha3);
        //  System.out.println(fecha3);
        String sum4 = "" + aux3;
        int sum5 = 0;
        while (sum4.length() != 1) {
            sum5 = suma(sum4);
            sum4 = "" + sum5;
        }
        cabalaDelAño += "Cábala: " + sum5;
    }

    public static int sumaTodo(String año) {
        int suma = 0;

        for (int i = 0; i < año.length(); i++) {
            suma += Integer.parseInt(String.valueOf(año.charAt(i)));
        }
        return suma;
    }

    public static int suma(String numero) {
        int aux = 0;
        for (int i = 0; i < numero.length(); i++) {
            aux += Integer.parseInt(String.valueOf(numero.charAt(i)));
        }
        return aux;
    }

}
