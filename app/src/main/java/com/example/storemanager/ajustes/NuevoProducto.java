package com.example.storemanager.ajustes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.storemanager.R;
import com.example.storemanager.ajustes.Ajustes;
import com.example.storemanager.database.AdminSQLiteOpenHelperProducts;
import com.example.storemanager.models.Producto_Muestra;

public class NuevoProducto extends AppCompatActivity {

    private EditText et_nombre, et_marca, et_medicion, et_pack,et_precio_compra, et_precio, et_maxcantidad, et_actual_pack,et_actual_unit ;
    private Spinner spinner;
    private int id_nuevo_producto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nuevo_producto);

        et_nombre=(EditText)findViewById(R.id.nuevo_producto_nombre);
        et_marca=(EditText)findViewById(R.id.nuevo_producto_marca);
        et_medicion=(EditText)findViewById(R.id.nuevo_producto_tamano);
        et_pack=(EditText)findViewById(R.id.nuevo_producto_pack);
        et_precio_compra=(EditText)findViewById(R.id.nuevo_producto_precio_compra);
        et_precio=(EditText)findViewById(R.id.nuevo_producto_precio);
        et_maxcantidad=(EditText)findViewById(R.id.nuevo_producto_cantidad_maxima);
        et_actual_pack=(EditText)findViewById(R.id.nuevo_producto_cantidad_actual_pack);
        et_actual_unit=(EditText)findViewById(R.id.nuevo_producto_actual_unit);
        spinner=(Spinner)findViewById(R.id.nuevo_producto_spinner);

        String opciones[]={"g","Kg","ml","L"};

        ArrayAdapter<String> adapter= new ArrayAdapter<String >(this, android.R.layout.simple_spinner_item,opciones);
        spinner.setAdapter(adapter);

        SharedPreferences preferences=getSharedPreferences("datos", Context.MODE_PRIVATE);
        id_nuevo_producto=preferences.getInt("mail",1);

    }

    public void moveToAjustes(View view){
        Intent anterior= new Intent(this, Ajustes.class);
        startActivity(anterior);
    }
    public void Registrar(View view){


        AdminSQLiteOpenHelperProducts admin=new AdminSQLiteOpenHelperProducts(this);//este es el usado

        SQLiteDatabase db=admin.getWritableDatabase();

        String nombre=et_nombre.getText().toString();
        String marca=et_marca.getText().toString();
        String medicion=et_medicion.getText().toString();
        String seleccion_medicion=spinner.getSelectedItem().toString();
        if(!medicion.isEmpty()){
            medicion=medicion+seleccion_medicion;
        }
        String string_pack=et_pack.getText().toString();
        String string_precio_compra=et_precio_compra.getText().toString();
        String string_precio_venta=et_precio.getText().toString();
        String string_maxcantidad=et_maxcantidad.getText().toString();
        String string_actual_pack=et_actual_pack.getText().toString();
        String string_actual_unit=et_actual_unit.getText().toString();





        if(!nombre.isEmpty() && !marca.isEmpty() && !medicion.isEmpty() && !string_pack.isEmpty() && !string_precio_compra.isEmpty() &&!string_precio_venta.isEmpty() && !string_maxcantidad.isEmpty() && !string_actual_pack.isEmpty() && !string_actual_unit.isEmpty() ){
            //se debe psar a los valores como se encuentra en la base de datos
            int pack=Integer.parseInt(string_pack);
            float precio_compra=Float.parseFloat(string_precio_compra);
            float precio_venta=Float.parseFloat(string_precio_venta);
            int max_packetes=Integer.parseInt(string_maxcantidad);
            int actual_pack=Integer.parseInt(string_actual_pack);
            int actual_unit=Integer.parseInt(string_actual_unit);

            if(precio_compra>precio_venta){
                Toast.makeText(this, "Precio de compra no puede ser mayor al de venta", Toast.LENGTH_SHORT).show();
            }else if(actual_pack>max_packetes){
                Toast.makeText(this, "Cantidad actual de packetes no puede ser mayor a la cantidad maxima", Toast.LENGTH_SHORT).show();
            }else{
                Producto_Muestra p=new Producto_Muestra(id_nuevo_producto,nombre, marca, medicion, pack, precio_compra,precio_venta,max_packetes, actual_pack, actual_unit);

                ContentValues content=new ContentValues();
                //content.put("",);
                content.put("CODIGO",p.getId());
                content.put("NOMBRE",p.getNombre());
                content.put("MARCA",p.getMarca());
                content.put("TAMANO",p.getTamano());
                content.put("PACKETE",p.getUnits_pack());
                content.put("PRECIO_COMPRA",p.getPrecio_compra());
                content.put("PRECIO_VENTA",p.getPrecio_venta());
                content.put("MAX_PACKETES",p.getMax_packetes());
                content.put("ACTUAL_PACKETES",p.getCantidad_packetes());
                content.put("ACTUAL_UNIDADES",p.getCantidad_unidades());

                db.insert("PRODUCTOS1",null, content);

                et_nombre.setText("");
                et_marca.setText("");
                et_medicion.setText("");
                et_pack.setText("");
                //et_cantidad.setText("");
                et_maxcantidad.setText("");
                et_precio.setText("");
                Toast.makeText(this, "Guardado del producto completado", Toast.LENGTH_SHORT).show();
            }


        }else{
            Toast.makeText(this, "Llene todos los campos", Toast.LENGTH_SHORT).show();
        }
        db.close();


        SharedPreferences  preferencias=getSharedPreferences("datos", Context.MODE_PRIVATE);
        SharedPreferences.Editor obj_editor=preferencias.edit();
        id_nuevo_producto++;//aqui aumentamos para cambiar el id
        obj_editor.putInt("mail", id_nuevo_producto);
        obj_editor.commit();


        //esto es apra regresar
        Intent anterior= new Intent(this, Ajustes.class);
        startActivity(anterior);
    }
}