package com.example.user.proyectofinal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Garantias extends AppCompatActivity {

    private ListView opciones;
    private String[] opc;
    private ArrayAdapter adapter;
    private Intent i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_garantias);

        opciones = (ListView)findViewById(R.id.lsGarantias);
        opc = getResources().getStringArray(R.array.garantias);
        adapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,opc);
        opciones.setAdapter(adapter);

        opciones.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0:
                        i = new Intent(Garantias.this,Ingreso.class);
                        startActivity(i);
                        break;
                    case 1:
                        i = new Intent(Garantias.this,Lista_Garantias.class);
                        startActivity(i);
                        break;
                }
            }
        });
    }
}
