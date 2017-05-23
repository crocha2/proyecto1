package com.example.user.proyectofinal;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class Lista_Productos extends AppCompatActivity {

    private ListView lstPersonalizado;
    private ArrayList<Producto> productos;
    private AdaptadorProducto adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista__productos);
        lstPersonalizado = (ListView)findViewById(R.id.lsListadoProductos);
        productos = Datos.traerProducto(getApplicationContext());
        adapter = new AdaptadorProducto(getApplicationContext(),productos);
        lstPersonalizado.setAdapter(adapter);

    }
}
