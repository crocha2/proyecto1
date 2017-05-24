package com.example.user.proyectofinal;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by user on 22/5/2017.
 */

public class Crea_Garantia {

    private String rma;
    private String cliente;
    private String telefono;
    private String correo;
    private String equipo;
    private String modelo;
    private String serie;
    private String fecha;

    public Crea_Garantia(String rma, String cliente, String telefono, String correo, String equipo, String modelo, String serie, String fecha) {
        this.rma = rma;
        this.cliente = cliente;
        this.telefono = telefono;
        this.correo = correo;
        this.equipo = equipo;
        this.modelo = modelo;
        this.serie = serie;
        this.fecha = fecha;
    }

    public String getRma() {
        return rma;
    }

    public void setRma(String rma) {
        this.rma = rma;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getEquipo() {
        return equipo;
    }

    public void setEquipo(String equipo) {
        this.equipo = equipo;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public void guardar(Context contexto){
        //declarar las variables
        SQLiteDatabase db;
        String sql;

        //Abrir la conexion de base datos en modo escritura
        Crear_GarantiaSQLiteOpenHelper  aux = new Crear_GarantiaSQLiteOpenHelper(contexto,"DBgarantias",null);
        db = aux.getWritableDatabase();

        //insertar forma 1
        sql = "INSERT INTO garantias values('"+this.getRma()+"','"+this.getCliente()+"','"+this.getTelefono()+"','"+this.getCorreo()+"','"+this.getEquipo()+"','"+this.getModelo()+"','"+this.getSerie()+"','"+this.getFecha()+"')";

        db.execSQL(sql);
        db.close();

    }

    public void modificar(Context contexto){
        //declarar las variables
        SQLiteDatabase db;
        String sql;

        //Abrir la conexion de base datos en modo escritura
        Crear_GarantiaSQLiteOpenHelper  aux = new Crear_GarantiaSQLiteOpenHelper(contexto,"DBgarantias",null);
        db = aux.getWritableDatabase();

        //insertar forma 1
        sql = "UPDATE garantias SET rma='"+this.getRma()+"', cliente='"+this.getCliente()+"', telefono='"+this.getTelefono()+"', " + "correo='" +this.getCorreo()+"', " + "equipo='" +this.getEquipo()+"', " + "modelo='" +this.getModelo()+"', " + "serie='" +this.getSerie()+"', " + "fecha='" +this.getFecha()+ "' where rma ='"+this.getRma()+"'";

        db.execSQL(sql);

        //cerrar conexion
        db.close();

    }

    public void eliminar(Context contexto){
        //declarar las variables
        SQLiteDatabase db;
        String sql;

        //Abrir la conexion de base datos en modo escritura
        Crear_GarantiaSQLiteOpenHelper  aux = new Crear_GarantiaSQLiteOpenHelper(contexto,"DBgarantias",null);
        db = aux.getWritableDatabase();

        sql = "DELETE FROM garantias where rma='"+this.getRma()+"'";
        db.execSQL(sql);
        db.close();

    }




}
