package com.example.user.proyectofinal;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.util.ArrayList;

public class Lista_Garantias extends AppCompatActivity {

    private TableLayout tabla;
    private ArrayList<Crea_Garantia> garantias;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista__garantias);

        tabla = (TableLayout)findViewById(R.id.tblGarantias);
        garantias = Datos.traerGarantia(getApplicationContext());

        for (int i = 0; i <garantias.size() ; i++) {
            TableRow fila = new TableRow(this);
            TextView c1 = new TextView(this);
            TextView c2 = new TextView(this);
            TextView c3 = new TextView(this);
            TextView c4 = new TextView(this);
            TextView c5 = new TextView(this);
            TextView c6 = new TextView(this);
            TextView c7 = new TextView(this);
            TextView c8 = new TextView(this);
            TextView c9 = new TextView(this);


            c1.setText(""+(i+1));
            c2.setText(garantias.get(i).getRma());
            c3.setText(garantias.get(i).getCliente());
            c4.setText(garantias.get(i).getTelefono());
            c5.setText(garantias.get(i).getCorreo());
            c6.setText(garantias.get(i).getEquipo());
            c7.setText(garantias.get(i).getModelo());
            c8.setText(garantias.get(i).getSerie());
            c9.setText(garantias.get(i).getFecha());

            fila.addView(c1);
            fila.addView(c2);
            fila.addView(c3);
            fila.addView(c4);
            fila.addView(c5);
            fila.addView(c6);
            fila.addView(c7);
            fila.addView(c8);
            fila.addView(c9);

            tabla.addView(fila);
        }
    }
}
