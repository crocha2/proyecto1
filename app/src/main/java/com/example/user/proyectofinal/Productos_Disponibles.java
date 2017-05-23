package com.example.user.proyectofinal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Productos_Disponibles extends AppCompatActivity {

    private ListView opciones;
    private String[] opc;
    private ArrayAdapter adapter;
    private Intent i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_productos__disponibles);

        opciones = (ListView)findViewById(R.id.lsProductosDisponibles);
        opc = getResources().getStringArray(R.array.productos);
        adapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,opc);
        opciones.setAdapter(adapter);

        opciones.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0:
                        i = new Intent(Productos_Disponibles.this,Ingreso_Producto.class);
                        startActivity(i);
                        break;
                    case 1:
                        i = new Intent(Productos_Disponibles.this,Lista_Productos.class);
                        startActivity(i);
                        break;
                }
            }
        });
    }
}
