package com.example.user.proyectofinal;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

/**
 * Created by user on 22/5/2017.
 */

public class Datos {

    public static ArrayList<Crea_Garantia> traerGarantia(Context contexto){
        ArrayList<Crea_Garantia> garantia = new ArrayList<>();

        SQLiteDatabase db;
        String sql, rma, cliente, telefono, correo, equipo, modelo, serie, fecha;
        Crea_Garantia g;

        Crear_GarantiaSQLiteOpenHelper aux = new Crear_GarantiaSQLiteOpenHelper(contexto,"DBgarantias",null);
        db = aux.getReadableDatabase();

        sql ="select * from garantias";
        Cursor c = db.rawQuery(sql,null);

        if(c.moveToFirst()){
            do{
                rma = c.getString(0);
                cliente = c.getString(1);
                telefono =c.getString(2);
                correo = c.getString(3);
                equipo = c.getString(4);
                modelo = c.getString(5);
                serie = c.getString(6);
                fecha = c.getString(7);
                g = new Crea_Garantia(rma, cliente, telefono, correo, equipo, modelo, serie, fecha);
                garantia.add(g);

            }while (c.moveToNext());
        }
        db.close();

        return garantia;
    }

    public static Crea_Garantia buscarGarantia(Context contexto, String rm){

        //Declarar variables
        SQLiteDatabase db;
        String sql, rma, cliente, telefono, correo, equipo, modelo, serie, fecha;
        Crea_Garantia g=null;
        //Abrir conexión de lectura
        Crear_GarantiaSQLiteOpenHelper aux = new Crear_GarantiaSQLiteOpenHelper(contexto,"DBgarantias",null);
        db = aux.getReadableDatabase();

        //Cursor
        sql ="select * from garantias where rma ='"+rm+"'";
        Cursor c = db.rawQuery(sql,null);

        //Recorrido del cursor
        if(c.moveToFirst()){
            rma = c.getString(0);
            cliente = c.getString(1);
            telefono =c.getString(2);
            correo = c.getString(3);
            equipo = c.getString(4);
            modelo = c.getString(5);
            serie = c.getString(6);
            fecha = c.getString(7);
            g = new Crea_Garantia(rma, cliente, telefono, correo, equipo, modelo, serie, fecha);
        }
        db.close();
        return g;
    }


    public static ArrayList<Producto> traerProducto(Context contexto){
        ArrayList<Producto> producto = new ArrayList<>();

        SQLiteDatabase db;
        String sql, foto, serie, modelo, descripcion, cliente;
        Producto p;

        ProductoSQLiteOpenHelper aux = new ProductoSQLiteOpenHelper(contexto,"DBgarantias",null,6);
        db = aux.getReadableDatabase();

        sql ="select * from productos";
        Cursor c = db.rawQuery(sql,null);

        if(c.moveToFirst()){
            do{
                foto = c.getString(0);
                serie = c.getString(1);
                modelo = c.getString(2);
                descripcion = c.getString(3);
                cliente = c.getString(4);

                p = new Producto(foto, serie, modelo, descripcion, cliente);
                producto.add(p);

            }while (c.moveToNext());
        }
        db.close();

        return producto;
    }

    public static Producto buscarProducto(Context contexto, String ser){

        //Declarar variables
        SQLiteDatabase db;
        String sql, foto, serie, modelo, descripcion, cliente;
        Producto p=null;
        //Abrir conexión de lectura
        ProductoSQLiteOpenHelper aux = new ProductoSQLiteOpenHelper(contexto,"DBgarantias",null,6);
        db = aux.getReadableDatabase();

        //Cursor
        sql ="select * from productos where serie ='"+ser+"'";
        Cursor c = db.rawQuery(sql,null);

        //Recorrido del cursor
        if(c.moveToFirst()){
            foto = c.getString(0);
            serie = c.getString(1);
            modelo = c.getString(2);
            descripcion = c.getString(3);
            cliente = c.getString(4);
            p = new Producto(foto, serie, modelo, descripcion, cliente);
        }
        db.close();
        return p;
    }

}
