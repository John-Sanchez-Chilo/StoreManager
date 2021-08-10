package com.example.storemanager.models;

public class Producto_Muestra extends Producto {
    private State state;
    private float precio_compra;
    private float precio_venta;
    private int cantidad_packetes;
    private int cantidad_unidades;
    private int max_packetes;
    public Producto_Muestra(String nombre, String marca, String tamano, int pack, float precio_compra, float precio_venta,int max_packetes, int cantidad_packetes, int cantidad_unidades) {
        super(nombre, marca, tamano, pack);
        this.precio_compra=precio_compra;
        this.precio_venta=precio_venta;
        this.max_packetes=max_packetes;
        this.cantidad_packetes=cantidad_packetes;
        this.cantidad_unidades=cantidad_unidades;
        if(this.cantidad_packetes!=0 && this.cantidad_unidades!=0){
            this.state=  new State_In_Stock(this);
        }else{
            this.state=new State_Not_Stock(this);
        }
    }

    public Producto_Muestra(int id,String nombre, String marca, String tamano, int pack, float precio_compra, float precio_venta,int max_packetes, int cantidad_packetes, int cantidad_unidades) {
        super(nombre, marca, tamano, pack);
        this.id=id;
        this.precio_compra=precio_compra;
        this.precio_venta=precio_venta;
        this.max_packetes=max_packetes;
        this.cantidad_packetes=cantidad_packetes;
        this.cantidad_unidades=cantidad_unidades;
        if(this.cantidad_packetes!=0 && this.cantidad_unidades!=0){
            this.state=  new State_In_Stock(this);
        }else{
            this.state=new State_Not_Stock(this);
        }
    }

    public float getPrecio_compra() {
        return precio_compra;
    }

    public float getPrecio_venta() {
        return precio_venta;
    }

    public int getCantidad_packetes() {
        return cantidad_packetes;
    }

    public int getCantidad_unidades() {
        return cantidad_unidades;
    }

    public int getMax_packetes() {
        return max_packetes;
    }


    public void setPrecio_compra(float precio_compra) {
        this.precio_compra = precio_compra;
    }

    public void setPrecio_venta(float precio_venta) {
        this.precio_venta = precio_venta;
    }

    public void setCantidad_packetes(int cantidad_packetes) {
        this.cantidad_packetes = cantidad_packetes;
    }

    public void setCantidad_unidades(int cantidad_unidades) {
        this.cantidad_unidades = cantidad_unidades;
    }

    public void setMax_packetes(int max_packetes) {
        this.max_packetes = max_packetes;
    }

    //no se para q pueden ser stas dos funciones, son las creadas del state hecho en c++ no en  java
    public void TransitionTo(State state){
        this.state=state;
        this.state.setContext(this);
    }
    public void Request(){
        this.state.Handle();
    }


    public void changeState(State state){
        this.state=state;
    }
}
