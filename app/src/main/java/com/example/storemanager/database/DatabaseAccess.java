package com.example.storemanager.database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.storemanager.models.Boleta_antigua;
import com.example.storemanager.models.Boleta;
import com.example.storemanager.models.Producto_Muestra;
import com.example.storemanager.models.Producto_Venta;

import java.util.ArrayList;

public class DatabaseAccess {
    private AdminSQLiteOpenHelperProducts openHelper;
    private SQLiteDatabase db;
    private static DatabaseAccess instance;
    Cursor cursor=null;

    private DatabaseAccess(Context context){
        this.openHelper=new AdminSQLiteOpenHelperProducts(context);
    }

    public static DatabaseAccess getInstance(Context context){
        if(instance==null){
            instance=new DatabaseAccess(context);
        }
        return instance;
    }

    public void open(){
        this.db=openHelper.getWritableDatabase();
    }

    public void close(){
        if(db!=null){
            this.db.close();
        }
    }
    

    public ArrayList<String> getProductArrayById(int  id){

        cursor=db.rawQuery("SELECT * FROM PRODUCTOS WHERE CODIGO='"+id+"'",null);

        ArrayList<String> productList=new ArrayList<String>();
        int codigo;
        String nombre;
        String marca;
        String tamano;
        int packete;
        float precio_compra;
        float precio_venta;
        int max_packetes;
        int actual_packetes;
        int actual_units;


        while(cursor.moveToNext()){

            codigo=cursor.getInt(cursor.getColumnIndex("CODIGO"));
            nombre=cursor.getString(cursor.getColumnIndex("NOMBRE"));
            marca=cursor.getString(cursor.getColumnIndex("MARCA"));
            tamano=cursor.getString(cursor.getColumnIndex("TAMANO"));
            packete=cursor.getInt(cursor.getColumnIndex("PACKETE"));
            precio_compra=cursor.getFloat(cursor.getColumnIndex("PRECIO_COMPRA"));
            precio_venta=cursor.getFloat(cursor.getColumnIndex("PRECIO_VENTA"));
            max_packetes=cursor.getInt(cursor.getColumnIndex("MAX_PACKETES"));
            actual_packetes=cursor.getInt(cursor.getColumnIndex("ACTUAL_PACKETES"));
            actual_units=cursor.getInt(cursor.getColumnIndex("ACTUAL_UNIDADES"));


            String string_codigo=String.valueOf(codigo);
            productList.add(string_codigo);
            productList.add(nombre);
            productList.add(marca);
            productList.add(tamano);
            String string_pack=String.valueOf(packete);
            productList.add(string_pack);
            String string_precio_compra=String.valueOf(precio_compra);
            productList.add(string_precio_compra);
            String string_precio_venta=String.valueOf(precio_venta);
            productList.add(string_precio_venta);
            String string_max_packetes=String.valueOf(max_packetes);
            productList.add(string_max_packetes);
            String string_actual_packetes=String.valueOf(actual_packetes);
            productList.add(string_actual_packetes);
            String string_actual_units=String.valueOf(actual_units);
            productList.add(string_actual_units);

        }
        return productList;
    }

    public Producto_Muestra getProducto_MuestraById(int  id){

        cursor=db.rawQuery("SELECT * FROM PRODUCTOS WHERE CODIGO='"+id+"'",null);

        int codigo;
        String nombre;
        String marca;
        String tamano;
        int packete;
        float precio_compra;
        float precio_venta;
        int max_packetes;
        int actual_packetes;
        int actual_units;


        while(cursor.moveToNext()){

            codigo=cursor.getInt(cursor.getColumnIndex("CODIGO"));
            nombre=cursor.getString(cursor.getColumnIndex("NOMBRE"));
            marca=cursor.getString(cursor.getColumnIndex("MARCA"));
            tamano=cursor.getString(cursor.getColumnIndex("TAMANO"));
            packete=cursor.getInt(cursor.getColumnIndex("PACKETE"));
            precio_compra=cursor.getFloat(cursor.getColumnIndex("PRECIO_COMPRA"));
            precio_venta=cursor.getFloat(cursor.getColumnIndex("PRECIO_VENTA"));
            max_packetes=cursor.getInt(cursor.getColumnIndex("MAX_PACKETES"));
            actual_packetes=cursor.getInt(cursor.getColumnIndex("ACTUAL_PACKETES"));
            actual_units=cursor.getInt(cursor.getColumnIndex("ACTUAL_UNIDADES"));
            Producto_Muestra p=new Producto_Muestra(nombre,marca,tamano,packete,precio_compra,precio_venta,max_packetes,actual_packetes,actual_units);
            return p;

        }
        return null;
    }

    public Producto_Venta getProducto_VentaById(int  id){
        //c=db.rawQuery("SELECT NOMBRE FROM PRODUCTOS WHERE CODIGO='"+id+"'",new String[]{});
        //cursor=db.rawQuery("SELECT * FROM PRODUCTOS WHERE CODIGO='"+id+"'",null);
        cursor=db.rawQuery("SELECT CODIGO, NOMBRE, MARCA, TAMANO, PACKETE, PRECIO_VENTA FROM PRODUCTOS1 WHERE CODIGO="+id,null);

        int codigo;
        String nombre;
        String marca;
        String tamano;
        int packete;
        float precio_venta;


        if(cursor.moveToFirst()){
            codigo=cursor.getInt(0);
            nombre=cursor.getString(1);
            marca=cursor.getString(2);
            tamano=cursor.getString(3);
            packete=cursor.getInt(4);
            precio_venta=cursor.getFloat(5);
            Producto_Venta p=new Producto_Venta(codigo,nombre,marca,tamano,packete,precio_venta,1);
            return p;
        }

        return null;

    }

    public void deleteProductById(int id){
        int cantidad=db.delete("PRODUCTOS1", "CODIGO="+id,null);
    }

    public ArrayList<Producto_Muestra> getListaProducto_Muestra(){

        cursor=db.rawQuery("SELECT * FROM PRODUCTOS1",null);

        int codigo;
        String nombre;
        String marca;
        String tamano;
        int packete;
        float precio_compra;
        float precio_venta;
        int max_packetes;
        int actual_packetes;
        int actual_units;

        ArrayList<Producto_Muestra> lista_producto_muestra=new ArrayList<Producto_Muestra>();


        if(cursor.getCount()>0){
            cursor.moveToFirst();

            do{
                codigo=cursor.getInt(cursor.getColumnIndex("CODIGO"));
                nombre=cursor.getString(cursor.getColumnIndex("NOMBRE"));
                marca=cursor.getString(cursor.getColumnIndex("MARCA"));
                tamano=cursor.getString(cursor.getColumnIndex("TAMANO"));
                packete=cursor.getInt(cursor.getColumnIndex("PACKETE"));
                precio_compra=cursor.getFloat(cursor.getColumnIndex("PRECIO_COMPRA"));
                precio_venta=cursor.getFloat(cursor.getColumnIndex("PRECIO_VENTA"));
                max_packetes=cursor.getInt(cursor.getColumnIndex("MAX_PACKETES"));
                actual_packetes=cursor.getInt(cursor.getColumnIndex("ACTUAL_PACKETES"));
                actual_units=cursor.getInt(cursor.getColumnIndex("ACTUAL_UNIDADES"));
                Producto_Muestra p=new Producto_Muestra(codigo,nombre,marca, tamano, packete, precio_compra,precio_venta,max_packetes,actual_packetes,actual_units);
                lista_producto_muestra.add(p);
            }while(cursor.moveToNext());
        }

        return lista_producto_muestra;
    }

    public ArrayList<Producto_Venta> getListaProducto_Venta(){
        cursor=db.rawQuery("SELECT * FROM PRODUCTOS1",null);

        int codigo;
        String nombre;
        String marca;
        String tamano;
        int packete;
        float precio_venta;

        ArrayList<Producto_Venta> lista_producto_muestra=new ArrayList<Producto_Venta>();


        if(cursor.getCount()>0){
            cursor.moveToFirst();

            do{
                codigo=cursor.getInt(cursor.getColumnIndex("CODIGO"));
                nombre=cursor.getString(cursor.getColumnIndex("NOMBRE"));
                marca=cursor.getString(cursor.getColumnIndex("MARCA"));
                tamano=cursor.getString(cursor.getColumnIndex("TAMANO"));
                packete=cursor.getInt(cursor.getColumnIndex("PACKETE"));
                precio_venta=cursor.getFloat(cursor.getColumnIndex("PRECIO_VENTA"));
                Producto_Venta p=new Producto_Venta(codigo,nombre,marca, tamano, packete, precio_venta,1);
                lista_producto_muestra.add(p);
            }while(cursor.moveToNext());
        }

        return lista_producto_muestra;
    }




    public ArrayList<Boleta_antigua> getListaBoleta_Antigua(){
        //c=db.rawQuery("SELECT NOMBRE FROM PRODUCTOS WHERE CODIGO='"+id+"'",new String[]{});
        cursor=db.rawQuery("SELECT * FROM BOLETAS",null);

        int id;
        String name;
        String fecha;
        //para pasarlo
        String codigos_productos;
        String cantidades;

        ArrayList<Boleta_antigua> listBoletasOficial=new ArrayList<Boleta_antigua>();


        if(cursor.getCount()>0){
            cursor.moveToFirst();

            do{
                id=cursor.getInt(cursor.getColumnIndex("CODIGO"));
                name=cursor.getString(cursor.getColumnIndex("NOMBRE"));
                fecha=cursor.getString(cursor.getColumnIndex("FECHA"));
                //esto es pasarlo al item seleccionado
                codigos_productos=cursor.getString(cursor.getColumnIndex("PRODUCTOS"));
                cantidades=cursor.getString(cursor.getColumnIndex("CANTIDADES"));

                Boleta_antigua p= new Boleta_antigua(id, name, fecha,codigos_productos,cantidades);
                listBoletasOficial.add(p);


            }while(cursor.moveToNext());
        }

        return listBoletasOficial;
    }

    public ArrayList<Boleta> getListaBoleta(){
        cursor=db.rawQuery("SELECT * FROM BOLETAS",null);

        int id;
        String name;
        String fecha;
        //para pasarlo
        String codigos_productos;
        String cantidades;

        ArrayList<Boleta> listBoletasOficial=new ArrayList<Boleta>();


        if(cursor.getCount()>0){
            cursor.moveToFirst();

            do{
                id=cursor.getInt(cursor.getColumnIndex("CODIGO"));
                name=cursor.getString(cursor.getColumnIndex("NOMBRE"));
                fecha=cursor.getString(cursor.getColumnIndex("FECHA"));
                //esto es pasarlo al item seleccionado
                codigos_productos=cursor.getString(cursor.getColumnIndex("PRODUCTOS"));
                cantidades=cursor.getString(cursor.getColumnIndex("CANTIDADES"));

                //Boleta p= new Boleta(id, name, fecha,codigos_productos,cantidades);
                //listBoletasOficial.add(p);


            }while(cursor.moveToNext());
        }

        return listBoletasOficial;
    }




}
