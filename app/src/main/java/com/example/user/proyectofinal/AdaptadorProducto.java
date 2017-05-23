package com.example.user.proyectofinal;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by user on 22/5/2017.
 */

public class AdaptadorProducto extends BaseAdapter {
    private Context contexto;
    private ArrayList<Producto> productos;

    public AdaptadorProducto(Context contexto, ArrayList<Producto> productos){
        this.contexto = contexto;
        this.productos = productos;
    }

    @Override
    public int getCount() {
        return productos.size();
    }

    @Override
    public Object getItem(int position) {
        return productos.get(position);
    }

    @Override
    public long getItemId(int position) {
        return Long.parseLong(productos.get(position).getSerie());
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        TextView cajaserie,cajaModelo,cajaDescripcion, cajaCliente;
        ImageView foto;
        LayoutInflater inflater;
        View itemView;

        inflater = (LayoutInflater)contexto.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        itemView = inflater.inflate(R.layout.item_producto,null);

        cajaserie= (TextView)itemView.findViewById(R.id.txtSerieP);
        cajaModelo=(TextView)itemView.findViewById(R.id.txtSeriePro);
        cajaDescripcion=(TextView)itemView.findViewById(R.id.txtDescripcionP);
        cajaCliente=(TextView)itemView.findViewById(R.id.txtClienteP);
        foto = (ImageView)itemView.findViewById(R.id.imgFoto);

        foto.setImageResource(Integer.parseInt(productos.get(position).getFoto()));
        cajaModelo.setText(productos.get(position).getModelo());
        cajaserie.setText(productos.get(position).getSerie());
        cajaDescripcion.setText(productos.get(position).getDescripcion());
        cajaCliente.setText(productos.get(position).getDescripcion());

        return itemView;
    }
}
