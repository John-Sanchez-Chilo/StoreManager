package com.example.storemanager.models;

public class Propietario {
    private String nombre;
    private int telefono;
    private long ruc;
    private int categoria;

    public Propietario(String nombre, int telefono, long ruc, int categoria) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.ruc = ruc;
        this.categoria = categoria;
    }

    public String getNombre() {
        return nombre;
    }

    public int getTelefono() {
        return telefono;
    }

    public long getRuc() {
        return ruc;
    }

    public int getCategoria() {
        return categoria;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public void setRuc(long ruc) {
        this.ruc = ruc;
    }

    public void setCategoria(int categoria) {
        this.categoria = categoria;
    }
}
