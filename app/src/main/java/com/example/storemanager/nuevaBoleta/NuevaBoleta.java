package com.example.storemanager.nuevaBoleta;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.storemanager.R;
import com.example.storemanager.adapters.Adaptador_Recycler_Producto;
import com.example.storemanager.database.AdminSQLiteOpenHelperProducts;
import com.example.storemanager.database.DatabaseAccess;
import com.example.storemanager.menus.MainActivity;
import com.example.storemanager.models.Boleta_antigua;
import com.example.storemanager.models.Producto_Venta;

import java.util.ArrayList;

public class NuevaBoleta extends AppCompatActivity {

    ArrayList<Producto_Venta> listProducts;
    RecyclerView recyclerView;
    EditText et_name,et_fecha;

    //declaraciones para la base de datos
    AdminSQLiteOpenHelperProducts admin;
    SQLiteDatabase BaseDeDatos;

    private int id_nueva_boleta;
    //declraciones para recibir datos
    ArrayList<Integer> newProductsId;
    ArrayList<Integer> newProductsAmount;
    Bundle bundle;
    String d1="creacion";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nueva_boleta);

        recyclerView=(RecyclerView) findViewById(R.id.recycler_products);
        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));

        //para los id de las boletas
        SharedPreferences preferences=getSharedPreferences("boletas", Context.MODE_PRIVATE);
        id_nueva_boleta=preferences.getInt("boletas_id",1);

        //para recibir los productos seleccionados
        newProductsId=new ArrayList<Integer>();
        newProductsAmount=new ArrayList<Integer>();

        bundle=getIntent().getExtras();

        if(bundle!=null){

            newProductsId=bundle.getIntegerArrayList("selectedProductsID");
            newProductsAmount=bundle.getIntegerArrayList("selectedProductsAmount");

        }

        DatabaseAccess databaseAccess=DatabaseAccess.getInstance(getApplicationContext());
        databaseAccess.open();

        listProducts=new ArrayList<Producto_Venta>();
        Producto_Venta p;


        for(int i=0;i<newProductsId.size();i++){
            p=databaseAccess.getProducto_VentaById(newProductsId.get(i));
            listProducts.add(p);

        }
        databaseAccess.close();
        Adaptador_Recycler_Producto adapter= new Adaptador_Recycler_Producto(listProducts);
        recyclerView.setAdapter(adapter);
        et_name=(EditText)findViewById(R.id.nueva_boleta_nombre);
        et_fecha=(EditText)findViewById(R.id.nueva_boleta_fecha);

    }

    //Metodo para Cancelar y regresar al main
    public void cancelarBoleta(View view){
        Intent anterior= new Intent(this, MainActivity.class);
        startActivity(anterior);
    }
    public void añadirProducto(View view){
        Intent venta= new Intent(this, Activity_Producto_Venta.class);
        startActivity(venta);
    }
    public void aceptarBoleta(View view){


        AdminSQLiteOpenHelperProducts admin=new AdminSQLiteOpenHelperProducts(this);
        SQLiteDatabase db=admin.getWritableDatabase();

        String name=et_name.getText().toString().trim();
        String fecha=et_fecha.getText().toString().trim();
        String productos="";
        String cantidades="";

        for(int i=0;i<listProducts.size();i++){
            productos+=listProducts.get(i).getId();
            productos+="-";
            cantidades+=listProducts.get(i).getCantidad()+"";
            cantidades+="-";
        }

        if(!name.isEmpty() && !fecha.isEmpty() && listProducts.size()>0){
            Boleta_antigua p= new Boleta_antigua(name, fecha, productos, cantidades);
            ContentValues content=new ContentValues();
            content.put("CODIGO",id_nueva_boleta);
            content.put("NOMBRE",name);
            content.put("FECHA",fecha);
            content.put("PRODUCTOS",productos);
            content.put("CANTIDADES",cantidades);

            db.insert("BOLETAS",null,content);

            et_name.setText("");
            et_fecha.setText("");

            Toast.makeText(this, "Boleta guardada", Toast.LENGTH_LONG).show();

        }else{
            if(listProducts.size()==0){
                Toast.makeText(this, "No ha ordenado ningun producto", Toast.LENGTH_LONG).show();
                Toast.makeText(this, "No se pudo guardar una boleta vacía", Toast.LENGTH_LONG).show();
            }else{
                Toast.makeText(this, "No lleno todos los campos", Toast.LENGTH_LONG).show();
                Toast.makeText(this, "No se pudo guardar la boleta", Toast.LENGTH_LONG).show();
            }
        }
        db.close();


        //para el id ;usando shared preferences
        SharedPreferences  preferencias=getSharedPreferences("boletas", Context.MODE_PRIVATE);
        SharedPreferences.Editor obj_editor=preferencias.edit();
        id_nueva_boleta++;//aqui aumentamos para cambiar el id
        obj_editor.putInt("boletas_id", id_nueva_boleta);
        obj_editor.commit();


        Intent main=new Intent(this, MainActivity.class);
        startActivity(main);
    }

}