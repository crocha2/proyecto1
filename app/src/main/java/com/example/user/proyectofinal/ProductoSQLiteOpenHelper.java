package com.example.user.proyectofinal;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by user on 22/5/2017.
 */

public class ProductoSQLiteOpenHelper extends SQLiteOpenHelper {
    private String sql = "CREATE TABLE productos(foto text, serie text, modelo text, descripcion text, cliente text)";

    public ProductoSQLiteOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS productos");
        db.execSQL(sql);
    }
}
