package com.example.storemanager;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import com.example.storemanager.adapters.Adaptador_Lista_Producto;
import com.example.storemanager.database.AdminSQLiteOpenHelperProducts;
import com.example.storemanager.database.DatabaseAccess;
import com.example.storemanager.models.Producto_Muestra;

import java.util.ArrayList;

public class Productos extends AppCompatActivity {

    ListView lista_productos;
    ArrayList<Producto_Muestra> listaProductos;
    //declaraciones para la base de datos
    AdminSQLiteOpenHelperProducts admin;
    SQLiteDatabase BaseDeDatos;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_productos);

        lista_productos=(ListView)findViewById(R.id.lista_productos);
        listaProductos=new ArrayList<Producto_Muestra>();

        DatabaseAccess databaseAccess=DatabaseAccess.getInstance(getApplicationContext());
        databaseAccess.open();
        listaProductos=databaseAccess.getListaProducto_Muestra();
        databaseAccess.close();

        Adaptador_Lista_Producto adapter= new Adaptador_Lista_Producto(this,listaProductos);
        lista_productos.setAdapter(adapter);
    }
}