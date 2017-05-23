package com.example.user.proyectofinal;

/**
 * Created by user on 22/5/2017.
 */

public class Producto {

    private String foto;
    private String serie;
    private String modelo;
    private String Descripcion;

    public Producto(String foto, String serie, String modelo, String descripcion) {
        this.foto = foto;
        this.serie = serie;
        this.modelo = modelo;
        Descripcion = descripcion;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String descripcion) {
        Descripcion = descripcion;
    }
}
