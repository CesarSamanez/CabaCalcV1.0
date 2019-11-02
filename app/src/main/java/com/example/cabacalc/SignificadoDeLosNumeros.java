package com.example.cabacalc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class SignificadoDeLosNumeros extends AppCompatActivity {

    TextView contenido;
    static String Significadodelosnumeros = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_significado_de_los_numeros);
        Significadodelosnumeros = "";

        contenido = (TextView) findViewById(R.id.txtContenido);
        SignificadoDeNumeros();
        contenido.setText(Significadodelosnumeros);

    }

    public static void SignificadoDeNumeros() {

        Significadodelosnumeros = "ARCANO 0-1\n" +
                "EL MAGO:\n" +
                "EL HOMBRE:\n" +
                "\"Espada. Voluntad. Poder\".\n" +
                "\n" +
                "ARCANO 2\n" +
                "LA SACERDOTISA:\n" +
                "LA MUJER del MAGO:\n" +
                "\"Ciencia Oculta. Favorable\".\n" +
                "\n" +
                "ARCANO 3\n" +
                "LA EMPERATRIZ:\n" +
                "LA MADRE DIVINA:\n" +
                "\"Producción Material y Espiritual\".\n" +
                "\n" +
                "ARCANO 4\n" +
                "EL EMPERADOR:\n" +
                "\"Mando. Progreso. Éxito. Misericordia\".\n" +
                "\n" +
                "ARCANO 5\n" +
                "EL JERARCA:\n" +
                "EL RIGOR, LA LEY:\n" +
                "\"El Karma. Marte. Guerra\".\n" +
                "\n" +
                "ARCANO 6\n" +
                "LA INDECISIÓN:\n" +
                "EL ENAMORADO:\n" +
                "\"Victoria. Buena Suerte\".\n" +
                "\n" +
                "ARCANO 7\n" +
                "EL TRIUNFO:\n" +
                "EL CARRO de GUERRA:\n" +
                "\"Guerras. Luchas. Expiación. Dolor. Amargura\".\n" +
                "\n" +
                "ARCANO 8\n" +
                "LA JUSTICIA:\n" +
                "EL ARCANO de JOB:\n" +
                "\"Sufrimientos. Pruebas. Dolor\".\n" +
                "\n" +
                "ARCANO 9\n" +
                "EL EREMITA:\n" +
                "LA INICIACIÓN:\n" +
                "\"Soledad. Sufrimientos\".\n" +
                "\n" +
                "ARCANO 10\n" +
                "LA RETRIBUCIÓN:\n" +
                "LA RUEDA de la FORTUNA:\n" +
                "\"Buenos negocios. Cambios\".\n" +
                "\n" +
                "ARCANO 11\n" +
                "LA PERSUASIÓN:\n" +
                "EL LEÓN DOMADO:\n" +
                "\"Favorece la Ley. Que no haya temor. Marte\".\n" +
                "\n" +
                "ARCANO 12\n" +
                "EL APOSTOLADO:\n" +
                "EL SACRIFICIO:\n" +
                "\"Pruebas y dolor. Arcano A.Z.F. nos saca del dolor\".\n" +
                "\n" +
                "ARCANO 13\n" +
                "LA INMORTALIDAD:\n" +
                "MUERTE y RESURRECCIÓN:\n" +
                "\"Transformaciones. Indica cambio total\".\n" +
                "\n" +
                "ARCANO 14\n" +
                "LA TEMPERANCIA:\n" +
                "MATRIMONIO ASOCIACIÓN:\n" +
                "\"Larga vida. Estabilidad. No cambio\".\n" +
                "\n" +
                "ARCANO 15\n" +
                "LA PASIÓN:\n" +
                "TIFON BAFOMETO:\n" +
                "\"Fracaso amoroso. Anuncia peligros\".\n" +
                "\n" +
                "ARCANO 16\n" +
                "LA FRAGILIDAD:\n" +
                "LA TORRE FULMINADA:\n" +
                "\"Castigo. Caída terrible. Evítese esta fecha\".\n" +
                "\n" +
                "ARCANO 17\n" +
                "LA ESPERANZA:\n" +
                "LA ESTRELLA de la ESPERANZA:\n" +
                "\"Significa esperanza y espera\".\n" +
                "\n" +
                "ARCANO 18\n" +
                "EL CREPÚSCULO:\n" +
                "ENEMIGOS OCULTOS:\n" +
                "\"Los enemigos ocultos saltan en cualquier momento. Enfermedades. No negocios\".\n" +
                "\n" +
                "ARCANO 19\n" +
                "LA INSPIRACIÓN:\n" +
                "EL SOL RADIANTE:\n" +
                "\"Éxitos. Buena suerte. La Piedra Filosofal\".\n" +
                "\n" +
                "ARCANO 20\n" +
                "LA RESURRECCIÓN:\n" +
                "LA RESURRECCIÓN de los MUERTOS:\n" +
                "\"Cambios favorables, aprovéchelos. Acabar con las debilidades\".\n" +
                "\n" +
                "ARCANO 21\n" +
                "LA TRANSMUTACIÓN:\n" +
                "EL LOCO, LA INSENSATEZ:\n" +
                "\"Desmoralización total para el mal. Llave mágica: Runa Olin. Antítesis, enemigos de Hiram Habif\".\n" +
                "\n" +
                "ARCANO 22\n" +
                "EL REGRESO:\n" +
                "LA VERDAD, LA CORONA de la VIDA:\n" +
                "\"Triunfo. Todo sale bien. Poder. Fuerza. Buena suerte\".";
    }
}
