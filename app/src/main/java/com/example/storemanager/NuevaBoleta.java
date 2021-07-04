package com.example.storemanager;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class NuevaBoleta extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nueva_boleta);
    }

    //Metodo para Cancelar y regresar al main
    public void cancelarBoleta(View view){
        Intent anterior= new Intent(this,MainActivity.class);
        startActivity(anterior);
    }
}