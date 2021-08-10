package com.example.storemanager.models;

public class Producto_Venta {
    private int id;
    private String nombre;
    private String marca;
    private String tamano;
    private int units_pack;
    private float precio;
    private int cantidad;
    private boolean isChecked=false;

    /*
    public Producto_Venta(String nombre, String marca, String tamano, int pack, float precio, int cantidad) {
        super(nombre, marca, tamano, pack);
        this.precio=precio;
        this.cantidad=cantidad;
    }

     */
    public Producto_Venta(int id,String nombre, String marca, String tamano, int pack, float precio, int cantidad) {
        //super(nombre, marca, tamano, pack);

        this.nombre=nombre;
        this.marca=marca;
        this.tamano=tamano;
        this.units_pack=pack;


        this.id=id;
        this.precio=precio;
        this.cantidad=cantidad;
    }

    //nuevos getter y setter


    public boolean isChecked() {
        return isChecked;
    }

    public void setChecked(boolean checked) {
        isChecked = checked;
    }

    public int getId() {
        return id;
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

    //antiguos

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public float getPrecioTotal(){
        return getPrecio()*getCantidad();
    }
}
