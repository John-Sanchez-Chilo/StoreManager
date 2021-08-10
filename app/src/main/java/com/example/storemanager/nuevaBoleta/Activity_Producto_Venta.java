package com.example.storemanager.nuevaBoleta;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.storemanager.R;
import com.example.storemanager.adapters.Adaptador_Recycler_Producto_Venta;
import com.example.storemanager.database.AdminSQLiteOpenHelperProducts;
import com.example.storemanager.database.DatabaseAccess;
import com.example.storemanager.models.Producto_Venta;
import com.example.storemanager.nuevaBoleta.NuevaBoleta;

import java.util.ArrayList;

public class Activity_Producto_Venta extends AppCompatActivity {

    ArrayList<Producto_Venta> listProducts;
    ArrayList<Producto_Venta> selectedProducts;
    RecyclerView recyclerView;
    Button btn;
    //declaraciones para la base de datos
    AdminSQLiteOpenHelperProducts admin;
    SQLiteDatabase BaseDeDatos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_producto_venta);

        btn=(Button)findViewById(R.id.producto_venta_aceptar);
        recyclerView=(RecyclerView) findViewById(R.id.recycler_producto_venta);
        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));

        listProducts=new ArrayList<Producto_Venta>();
        selectedProducts=new ArrayList<Producto_Venta>();

        DatabaseAccess databaseAccess=DatabaseAccess.getInstance(getApplicationContext());
        databaseAccess.open();
        listProducts=databaseAccess.getListaProducto_Venta();
        databaseAccess.close();

        Adaptador_Recycler_Producto_Venta adapter= new Adaptador_Recycler_Producto_Venta(listProducts);
        recyclerView.setAdapter(adapter);

    }

    private void ShowToast(String msg){
        Toast.makeText(this,msg,Toast.LENGTH_SHORT).show();
    }

    public void cancelarProducto(View view){
        Intent anterior= new Intent(this, NuevaBoleta.class);
        startActivity(anterior);
    }

    //metodo para mandar los datos

    public void aceptarProducto(View view){

        String text = "";
        for(int i=0;i<listProducts.size();i++){
            if (listProducts.get(i).isChecked()){
                text += listProducts.get(i).getNombre();
                text+=" ";
                selectedProducts.add(listProducts.get(i));
            }
        }

        if(text==""){
            ShowToast("No selection");
        }
        else{
            ShowToast(text);
        }


        ArrayList<Integer> selectedProductsID=new ArrayList<Integer>();
        ArrayList<Integer> selectedProductsAmount=new ArrayList<Integer>();

        for(int i=0;i<selectedProducts.size();i++){
            selectedProductsID.add(selectedProducts.get(i).getId());
            selectedProductsAmount.add(selectedProducts.get(i).getCantidad());

            Toast.makeText(this, "En producto venta llenado selectedID:"+selectedProducts.get(i).getId(), Toast.LENGTH_SHORT).show();
        }

        Toast.makeText(this, "En producto venta selected:"+selectedProductsID.size(), Toast.LENGTH_SHORT).show();

        Intent i=new Intent(this, NuevaBoleta.class);
        i.putExtra("selectedProductsID", selectedProductsID);
        i.putExtra("selectedProductsAmount", selectedProductsAmount);

        startActivity(i);


    }


}