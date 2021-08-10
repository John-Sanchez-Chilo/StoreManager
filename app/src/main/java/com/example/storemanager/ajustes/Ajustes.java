package com.example.storemanager.ajustes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.storemanager.R;

public class Ajustes extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ajustes);
    }
    public void moveToCambiarDatos(View view){
        Intent formPedido= new Intent(this, CambiarDatos.class);
        startActivity(formPedido);
    }
    public void moveToNuevoProducto(View view){
        Intent formPedido= new Intent(this, NuevoProducto.class);
        startActivity(formPedido);
    }
    public void moveToEliminarProducto(View view){
        Intent formPedido= new Intent(this, Eliminar_Producto.class);
        startActivity(formPedido);
    }
}