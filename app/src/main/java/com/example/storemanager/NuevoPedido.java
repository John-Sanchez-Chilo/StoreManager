package com.example.storemanager;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.storemanager.menus.MainActivity;

public class NuevoPedido extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nuevo_pedido);
    }
    //metodo para cancelar el pedido
    public void cancelarPedido(View view){
        Intent anterior= new Intent(this, MainActivity.class);
        startActivity(anterior);
    }
}