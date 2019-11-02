package com.example.cabacalc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class UrgenciaInterior extends AppCompatActivity {

    TextView name, contenido;
    static String Urgenciainterior = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_urgencia_interior);
        Urgenciainterior = "";
        name = (TextView) findViewById(R.id.txtNombre);
        contenido = (TextView) findViewById(R.id.txtContenido);

        Intent intent = getIntent();
        String nombre = intent.getStringExtra(Index.data1);
        name.setText(nombre);
        String dia = intent.getStringExtra(Index.data2);
        String mes = intent.getStringExtra(Index.data3);
        String año = intent.getStringExtra(Index.data4);
        UrgenciaInterior(dia, mes, año);

        contenido.setText(Urgenciainterior);

    }

    public static void UrgenciaInterior(String dia, String mes, String año) {
        int sumaDias = suma(dia);
        int sumaMes = suma(mes);
        int sumaAño = suma(año);

        if (dia.length() > 1) {
            Urgenciainterior += "Día " + dia + " = " + dia.charAt(0) + " + " + dia.charAt(1) + " = " + suma(dia) + "\n";

        } else
            Urgenciainterior += "Día " + dia + "\n";

        if (mes.length() > 1) {
            Urgenciainterior += "Mes " + mes + " = " + mes.charAt(0) + " + " + mes.charAt(1) + " = " + suma(mes) + "\n";
        } else
            Urgenciainterior += "Mes " + mes + "\n";
        Urgenciainterior += "Año " + año + " = " + año.charAt(0) + " + " + dia.charAt(1) + " + " + año.charAt(2) + " + " + año.charAt(3) + " = ";
        String auxAño = "" + sumaAño;
        for (int i = 0; i < auxAño.length(); i++) {
            if (i == auxAño.length() - 1)
                Urgenciainterior += auxAño.charAt(i);
            else
                Urgenciainterior += auxAño.charAt(i) + " + ";
        }
        auxAño = "" + año;
        while (auxAño.length() != 1) {
            auxAño = "" + suma(auxAño);
        }
        Urgenciainterior += " = " + auxAño + "\n" + "Día " + sumaDias + "\nMes " + sumaMes + "\nAño " + auxAño + "\n";

        String aux = "" + sumaDias + sumaMes + sumaAño;
        int auxSum = sumaDias + sumaMes + Integer.parseInt(auxAño);
        Urgenciainterior += auxSum + " = ";

        for (int i = 0; i < ("" + auxSum).length(); i++) {
            if (i == ("" + auxSum).length() - 1)
                Urgenciainterior += ("" + auxSum).charAt(i);
            else
                Urgenciainterior += ("" + auxSum).charAt(i) + " + ";
        }

        while (aux.length() != 1) {
            aux = "" + suma(aux);
        }
        Urgenciainterior += " = " + aux + "\n" + "El arcano " + aux + " del tarot \n";

    }

    public static int suma(String numero) {
        int aux = 0;
        for (int i = 0; i < numero.length(); i++) {
            aux += Integer.parseInt(String.valueOf(numero.charAt(i)));
        }
        return aux;
    }

}
