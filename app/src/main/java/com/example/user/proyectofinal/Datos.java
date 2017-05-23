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

        Crear_GarantiaSQLiteOpenHelper aux = new Crear_GarantiaSQLiteOpenHelper(contexto,"DBgarantias",null,7);
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
        Crear_GarantiaSQLiteOpenHelper aux = new Crear_GarantiaSQLiteOpenHelper(contexto,"DBgarantias",null,7);
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

}
