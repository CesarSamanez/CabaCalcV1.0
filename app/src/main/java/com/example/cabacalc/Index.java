package com.example.cabacalc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Index extends AppCompatActivity {
    Button btn_developer, btn_estudio, btn_UrgenciaInterior, btn_TonicaFundamental, btn_TonicaDiaria, btn_Acontecimiento, btn_Significado, btn_Cabala;
    public static final String data1 = "nombre";
    public static final String data2 = "dia";
    public static final String data3 = "mes";
    public static final String data4 = "año";

    public static String name, day, month, year;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_index);

        btn_estudio = (Button) findViewById(R.id.buttonEstudio);
        btn_UrgenciaInterior = (Button) findViewById(R.id.buttonUrgenciaInterior);
        btn_TonicaFundamental = (Button) findViewById(R.id.buttonTonicaFundamental);
        btn_TonicaDiaria = (Button) findViewById(R.id.buttonTonicaDia);
        btn_Acontecimiento = (Button) findViewById(R.id.buttonAcontecimientoDia);
        btn_Significado = (Button) findViewById(R.id.buttonSignificadoNumeros);
        btn_Cabala = (Button) findViewById(R.id.buttonCabala);
        btn_developer = (Button) findViewById(R.id.buttonDeveloper);

        Intent intent = getIntent();
        name = intent.getStringExtra(Portada.data1);
        day = intent.getStringExtra(Portada.data2);
        month = intent.getStringExtra(Portada.data3);
        year = intent.getStringExtra(Portada.data4);


        btn_estudio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(Index.this, R.string.msjEstudio, Toast.LENGTH_SHORT).show();
                EstudioNumerologico(view);
            }

        });

        btn_UrgenciaInterior.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(Index.this, R.string.msjUrgenciaInterior, Toast.LENGTH_SHORT).show();
                UrgenciaInterior(view);
            }

        });

        btn_TonicaFundamental.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(Index.this, R.string.msjTonicaFundamental, Toast.LENGTH_SHORT).show();
                TonicaFundamental(view);
            }

        });

        btn_TonicaDiaria.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(Index.this, R.string.msjTonicaDia, Toast.LENGTH_SHORT).show();
                TonicaDelDia(view);
            }

        });

        btn_Acontecimiento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(Index.this, R.string.msjAcontecimientoDia, Toast.LENGTH_SHORT).show();
                AcontecimientoDelDia(view);
            }

        });

        btn_Significado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(Index.this, R.string.msjSignificadoNumeros, Toast.LENGTH_SHORT).show();
                SignificadoDeLosNumeros(view);
            }

        });

        btn_Cabala.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(Index.this, R.string.msjCabala, Toast.LENGTH_SHORT).show();
                CabalaDelAño(view);
            }

        });

        btn_developer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(Index.this, R.string.msjDesarrolador, Toast.LENGTH_SHORT).show();
                showInfoDevelopment(view);
            }

        });

    }

    public void EstudioNumerologico(View view) {
        Intent intent = new Intent(this, EstudioNumerologico.class);
        intent.putExtra(data1, name);
        intent.putExtra(data2, day);
        intent.putExtra(data3, month);
        intent.putExtra(data4, year);
        startActivity(intent);

    }

    public void UrgenciaInterior(View view) {
        Intent intent = new Intent(this, UrgenciaInterior.class);
        intent.putExtra(data1, name);
        intent.putExtra(data2, day);
        intent.putExtra(data3, month);
        intent.putExtra(data4, year);
        startActivity(intent);
    }

    public void TonicaFundamental(View view) {
        Intent intent = new Intent(this, TonicaFundamental.class);
        intent.putExtra(data1, name);
        intent.putExtra(data2, day);
        intent.putExtra(data3, month);
        intent.putExtra(data4, year);
        startActivity(intent);
    }

    public void TonicaDelDia(View view) {
        Intent intent = new Intent(this, TonicaDelDia.class);
        intent.putExtra(data1, name);
        intent.putExtra(data2, day);
        intent.putExtra(data3, month);
        intent.putExtra(data4, year);
        startActivity(intent);
    }

    public void AcontecimientoDelDia(View view) {
        Intent intent = new Intent(this, AcontecimientoDelDia.class);
        intent.putExtra(data1, name);
        intent.putExtra(data2, day);
        intent.putExtra(data3, month);
        intent.putExtra(data4, year);
        startActivity(intent);
    }

    public void SignificadoDeLosNumeros(View view) {
        Intent intent = new Intent(this, SignificadoDeLosNumeros.class);

        intent.putExtra(data1, name);
        intent.putExtra(data2, day);
        intent.putExtra(data3, month);
        intent.putExtra(data4, year);
        startActivity(intent);
    }

    public void CabalaDelAño(View view) {
        Intent intent = new Intent(this, CabalaDelAnio.class);
        intent.putExtra(data1, name);
        intent.putExtra(data2, day);
        intent.putExtra(data3, month);
        intent.putExtra(data4, year);
        startActivity(intent);
    }

    public void showInfoDevelopment(View view) {
        Intent intent = new Intent(this, Developer.class);
        startActivity(intent);
    }

    //Desactivar boton de atras
    @Override
    public void onBackPressed() {
    }
}



