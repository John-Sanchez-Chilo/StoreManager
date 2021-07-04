package com.example.storemanager;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Ajustes extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ajustes);
    }

    public void moveToNuevoProducto(View view){
        Intent formPedido= new Intent(this,NuevoProducto.class);
        startActivity(formPedido);
    }
}