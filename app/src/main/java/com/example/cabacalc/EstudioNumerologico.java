package com.example.cabacalc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class EstudioNumerologico extends AppCompatActivity {

    Button verArcanos, verArcanos1;
    TextView txtNombre1, txtfecha1, txtUrgenciaInterior1, txtTonicaFundamental1, txtCabalaAño1, txtTonicaDelDia1;

    static String nombre, dia, mes, año;
    static String cabalaDelAño = "";
    static String Urgenciainterior = "";
    static String Tonicafundamental = "";
    static String[] meses = {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto"
            , "Setiembre", "Octubre", "Noviembre", "Diciembre"};
    static String Tonicadeldia = "";
    static String fechaAux = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_estudio_numerologico);
        cabalaDelAño = "";
        Urgenciainterior = "";
        Tonicafundamental = "";
        Intent intent = getIntent();
        nombre = intent.getStringExtra(Index.data1);
        dia = intent.getStringExtra(Index.data2);
        mes = intent.getStringExtra(Index.data3);
        año = intent.getStringExtra(Index.data4);

        fechaAux = "" + dia + " de " + meses[Integer.parseInt(mes) - 1] + " del " + año;

        txtNombre1 = (TextView) findViewById(R.id.nombre);
        txtfecha1 = (TextView) findViewById(R.id.fecha);
        txtUrgenciaInterior1 = (TextView) findViewById(R.id.urgenciainterior);
        txtTonicaFundamental1 = (TextView) findViewById(R.id.tonicafundamental);
        txtTonicaDelDia1 = (TextView) findViewById(R.id.tonicadeldia);
        txtCabalaAño1 = (TextView) findViewById(R.id.cabaladelaño);
        verArcanos = (Button) findViewById(R.id.btnVerArcanos);
        verArcanos1 = (Button) findViewById(R.id.btnVerArcanos1);

        verArcanos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mostrar(v);
            }
        });


        verArcanos1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mostrar(v);
            }
        });

        //  Urgenciainterior = "";

        TonicaFundamental(nombre);
        txtUrgenciaInterior1.setText(Urgenciainterior);

        TonicaDelDia();
        Tonicadeldia = TonicaDelDia() + " TÓNICA DEL DIA " + dia + " de " + meses[Integer.parseInt(mes) - 1] + " del " + año;
        CabalaDelAño();


        txtNombre1.setText(nombre);
        txtfecha1.setText(fechaAux);
        txtTonicaFundamental1.setText(Tonicafundamental);
        txtTonicaDelDia1.setText(Tonicadeldia);
        txtCabalaAño1.setText(cabalaDelAño);


    }

    public void mostrar(View view) {
        Intent intent = new Intent(this, SignificadoDeLosNumeros.class);
        startActivity(intent);
    }

    public static int UrgenciaInterior(String dia, String mes, String año) {
        int sumaDias = suma(dia);
        int sumaMes = suma(mes);
        int sumaAño = suma(año);

        if (dia.length() > 1) {
            Urgenciainterior = "Día " + dia + " = " + dia.charAt(0) + " + " + dia.charAt(1) + " = " + suma(dia) + "\n";

        } else
            Urgenciainterior = "Día " + dia + "\n";

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

    public static int sumaTodo(String año) {
        int suma = 0;

        for (int i = 0; i < año.length(); i++) {
            suma += Integer.parseInt(String.valueOf(año.charAt(i)));
        }
        return suma;
    }


    public static void CabalaDelAño() {
        int fecha1, fecha2;
        fecha1 = Integer.parseInt(año) + sumaTodo(año);
        int aux1 = sumaTodo("" + fecha1);
        cabalaDelAño += "ver arcano " + aux1 + "\n";
        String sum1 = "" + aux1;
        int sum = 0;
        while (sum1.length() != 1) {
            sum = suma(sum1);
            sum1 = "" + sum;
        }
        cabalaDelAño += "ver arcano " + sum + "\n";
        fecha2 = Integer.parseInt("" + fecha1) + sumaTodo("" + fecha1);
        int aux2 = sumaTodo("" + fecha2);
        cabalaDelAño += "ver arcano " + aux2 + "\n";
        String sum2 = "" + aux2;
        int sum3 = 0;
        while (sum2.length() != 1) {
            sum3 = suma(sum2);
            sum2 = "" + sum3;
        }
        cabalaDelAño += "ver arcano " + sum3 + "\n";

        int fecha3 = Integer.parseInt("" + fecha2) + sumaTodo("" + fecha2);
        int aux3 = sumaTodo("" + fecha3);
        String sum4 = "" + aux3;
        int sum5 = 0;
        while (sum4.length() != 1) {
            sum5 = suma(sum4);
            sum4 = "" + sum5;
        }
        cabalaDelAño += "Cabala: " + sum5;
    }

}


