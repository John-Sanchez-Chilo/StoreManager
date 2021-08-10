package com.example.storemanager.models;

import com.example.storemanager.Product;

import java.util.ArrayList;

public class Boleta_antigua {
    private boolean isChecked;
    private int id;
    private static int idSiguiente=2;

    private String  name;
    private String date;
    private String codigos_productos;
    private String cantidades_productos;
    private ArrayList<Product> products;
    public Boleta_antigua(int _id, String _name, String _fecha, ArrayList<Product> _products){
        isChecked=false;
        this.id=_id;
        this.name=_name;
        this.date=_fecha;
        this.products=_products;
    }

    public Boleta_antigua(int _id, String _name, String _fecha){
        isChecked=false;
        this.id=_id;
        this.name=_name;
        this.date=_fecha;

    }

    public Boleta_antigua(int _id, String _name, String _fecha, String _codigos, String _cantidades){
        isChecked=false;
        this.id=_id;
        this.name=_name;
        this.date=_fecha;
        this.codigos_productos=_codigos;
        this.cantidades_productos=_cantidades;

    }

    public Boleta_antigua(String _name, String _fecha, String _codigos, String _cantidades){
        isChecked=false;
        this.id=idSiguiente;//estas dos lineas  es para manejar el id de forma automatica
        idSiguiente++;
        this.name=_name;
        this.date=_fecha;
        this.codigos_productos=_codigos;
        this.cantidades_productos=_cantidades;

    }

    public String getCodigos_productos() {
        return codigos_productos;
    }

    public String getCantidades_productos() {
        return cantidades_productos;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDate() {
        return date;
    }

    public float getTotalPrice(){
        float con=0;
        for(int i=0;i<products.size();i++){
            con+=products.get(i).getPrice();
        }
        return con;
    }
    public int getTotalProducts(){
        return products.size();
    }
}
