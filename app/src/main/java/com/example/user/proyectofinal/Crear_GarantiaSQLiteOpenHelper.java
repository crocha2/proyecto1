package com.example.user.proyectofinal;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by user on 22/5/2017.
 */

public class Crear_GarantiaSQLiteOpenHelper extends SQLiteOpenHelper {
    private String sql = "CREATE TABLE garantias(rma text, cliente text, telefono text, correo text, equipo text, modelo text, serie text, fecha text)";
    static int version=6;
    public Crear_GarantiaSQLiteOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory) {
        super(context, name, factory,version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS garantias");
        db.execSQL(sql);
    }
}
