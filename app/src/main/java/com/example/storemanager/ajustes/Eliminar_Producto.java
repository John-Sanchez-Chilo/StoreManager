package com.example.storemanager.ajustes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.storemanager.R;
import com.example.storemanager.ajustes.Ajustes;
import com.example.storemanager.database.DatabaseAccess;

public class Eliminar_Producto extends AppCompatActivity {

    private EditText et_id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eliminar_producto);

        et_id=(EditText)findViewById(R.id.eliminar_producto_id);
    }

    public void moveToAjustes(View view){
        Intent anterior= new Intent(this, Ajustes.class);
        startActivity(anterior);
    }

    public void aceptar(View view){
        String string_id=et_id.getText().toString();
        if(!string_id.isEmpty()){
            int id=Integer.parseInt(string_id);

            DatabaseAccess databaseAccess=DatabaseAccess.getInstance(getApplicationContext());
            databaseAccess.open();
            databaseAccess.deleteProductById(id);
            databaseAccess.close();
            Intent anterior= new Intent(this, Ajustes.class);
            startActivity(anterior);
        }
        else{
            Toast.makeText(this, "No ha introducido el id", Toast.LENGTH_SHORT).show();
        }
    }
}