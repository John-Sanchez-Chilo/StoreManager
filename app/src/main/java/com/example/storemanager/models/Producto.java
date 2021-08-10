package com.example.storemanager.models;

import com.example.storemanager.Product;

public class Producto extends Item{
    protected String nombre;
    protected String marca;
    protected String tamano;
    protected int units_pack;


    public Producto(String nombre, String marca, String tamano, int pack) {
        this.nombre = nombre;
        this.marca = marca;
        this.tamano = tamano;
        this.units_pack = pack;

    }

    public String getNombre() {
        return nombre;
    }

    public String getMarca() {
        return marca;
    }

    public String getTamano() {
        return tamano;
    }

    public int getUnits_pack() {
        return units_pack;
    }



    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setTamano(String tamano) {
        this.tamano = tamano;
    }

    public void setUnits_pack(int units_pack) {
        this.units_pack = units_pack;
    }


}
