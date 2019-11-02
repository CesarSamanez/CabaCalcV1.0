package com.example.cabacalc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class TonicaDelDia extends AppCompatActivity {

    TextView name, contenido;
    static String[] meses = {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto"
            , "Setiembre", "Octubre", "Noviembre", "Diciembre"};
    static String Tonicadeldia;
    static String Urgenciainterior = "";
    static String Tonicafundamental = "";
    static String nombre, dia, mes, año;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tonica_del_dia);

        Urgenciainterior = "";
        Tonicafundamental = "";


        name = (TextView) findViewById(R.id.txtNombre);
        contenido = (TextView) findViewById(R.id.txtContenido);

        Intent intent = getIntent();
        nombre = intent.getStringExtra(Index.data1);
        name.setText(nombre);
        dia = intent.getStringExtra(Index.data2);
        mes = intent.getStringExtra(Index.data3);
        año = intent.getStringExtra(Index.data4);
        UrgenciaInterior(dia, mes, año);
        TonicaFundamental(nombre);
        TonicaDelDia();
        Tonicadeldia = TonicaDelDia() + " TÓNICA DEL DIA " + dia + " de " + meses[Integer.parseInt(mes) - 1] + " del " + año;
        contenido.setText(Tonicadeldia);
    }

    public static int UrgenciaInterior(String dia, String mes, String año) {
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

        return Integer.parseInt(aux);
    }

    public static int suma(String numero) {
        int aux = 0;
        for (int i = 0; i < numero.length(); i++) {
            aux += Integer.parseInt(String.valueOf(numero.charAt(i)));
        }
        return aux;
    }


    public static int TonicaFundamental(String nombre) {
        String tamaños = "";
        Tonicafundamental += UrgenciaInterior(dia, mes, año) + " : Urgencia Interior\n";
        int sumaCabalistica = 0;
        int index = 0;
        for (int i = 0; i < nombre.length(); i++) {
            Tonicafundamental += nombre.charAt(i) + " ";
            if (i == nombre.length() - 1) {
                String aux = nombre.substring(index);
                tamaños += aux.length();
                sumaCabalistica += aux.length();
                break;
            }
            if (nombre.charAt(i) == ' ') {
                String aux = nombre.substring(index, i);
                tamaños += aux.length() + " + ";
                index = i + 1;
                sumaCabalistica += aux.length();
            }
        }
        Tonicafundamental += "\n";

        int auxIndex = 1;
        for (int i = 0; i < nombre.length(); i++) {

            if (nombre.charAt(i) == ' ') {
                Tonicafundamental += "  ";
                auxIndex = 1;
            } else {
                Tonicafundamental += auxIndex + " ";
                auxIndex++;
            }
        }
        String aux = "" + sumaCabalistica;

        if (aux.length() > 1)
            Tonicafundamental += "\n" + tamaños + " = " + aux + " = ";
        else
            Tonicafundamental += "\n" + tamaños + " = " + aux;

        for (int i = 0; i < aux.length(); i++) {
            if (i == aux.length() - 1)
                Tonicafundamental += aux.charAt(i);
            else
                Tonicafundamental += aux.charAt(i) + " + ";
        }


        while (aux.length() != 1) {
            aux = "" + suma("" + sumaCabalistica);
        }
        Tonicafundamental += " = " + aux;

        Tonicafundamental += "\n" + aux + " + " + UrgenciaInterior(dia, mes, año) + "(Urgencia Interior)" + " = ";
        int total = Integer.parseInt(aux) + UrgenciaInterior(dia, mes, año);
        String res = "" + total;
        Tonicafundamental += res + " = ";
        for (int i = 0; i < res.length(); i++) {
            if (i == res.length() - 1)
                Tonicafundamental += res.charAt(i);
            else
                Tonicafundamental += res.charAt(i) + " + ";
        }

        while (res.length() != 1) {
            res = "" + suma(res);
        }

        Tonicafundamental += " = " + res + "\n" + res + ": TÓNICA FUNDAMENTAL";

        return Integer.parseInt(res);
    }

    public static int TonicaDelDia() {

        String tonicaDia = "" + (TonicaFundamental(nombre) + UrgenciaInterior(dia, mes, año));
        int aux = 0;
        while (tonicaDia.length() != 1) {
            aux = suma(tonicaDia);
            tonicaDia = "" + aux;
        }
        return Integer.parseInt(tonicaDia);
    }
}
