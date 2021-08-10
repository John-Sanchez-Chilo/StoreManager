package com.example.storemanager.models;

import java.util.ArrayList;

public class Boleta_Muestra {

    private String name;
    private Fecha fecha;
    private ArrayList<Producto_Venta> lista_producto_venta;
    public Boleta_Muestra(String name,Fecha fecha, ArrayList<Producto_Venta> lista_producto_venta ){
        this.name=name;
        this.fecha=fecha;
        this.lista_producto_venta=lista_producto_venta;
    }

    public Boleta_Muestra(String name,Fecha fecha, String string_codigos_productos,String string_cantidades ){
        this.name=name;
        this.fecha=fecha;

        ArrayList<Producto_Venta> lista_productoVenta=new ArrayList<Producto_Venta>();

        String tmp="";
        int con1=0;
        int con2=0;
        ArrayList<Integer> lista_codigos=new ArrayList<Integer>();
        for(int i=0;i<string_codigos_productos.length();i++){
            if(string_codigos_productos.charAt(i) != '-'){
                con2++;
            }else{
                tmp=string_codigos_productos.substring(con1, con2);
                lista_codigos.add(Integer.parseInt(tmp));
                con2++;
                con1=con2;
            }

        }

        //separa lca ncatidades para pnerlos en un array de enteros
        tmp="";
        con1=0;
        con2=0;
        ArrayList<Integer> lista_cantidades;
        lista_cantidades=new ArrayList<Integer>();
        for(int i=0;i<string_cantidades.length();i++){
            if(string_codigos_productos.charAt(i) != '-'){
                con2++;
            }else{
                tmp=string_cantidades.substring(con1, con2);
                lista_cantidades.add(Integer.parseInt(tmp));
                con2++;
                con1=con2;
            }

        }
        /*
        for(int i=0;i<lista_codigos.size();i++){
            Producto_Venta p=new Producto_Venta(lista_codigos.get(i),);
            lista_productoVenta.add(p);
        }

         */

        //this.lista_producto_venta=lista_producto_venta;
    }

    public String getName() {
        return name;
    }

    public Fecha getFecha() {
        return fecha;
    }
    public String getStringFecha() {
        return fecha.toString();
    }

    public ArrayList<Producto_Venta> getLista_producto_venta() {
        return lista_producto_venta;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setFecha(Fecha fecha) {
        this.fecha = fecha;
    }

    public void setLista_producto_venta(ArrayList<Producto_Venta> lista_producto_venta) {
        this.lista_producto_venta = lista_producto_venta;
    }

    public float getPrecioTotal(){
        float  con=0;
        for(int i=0;i<lista_producto_venta.size();i++){
            con+=lista_producto_venta.get(i).getPrecioTotal();
        }
        return con;
    }
}
