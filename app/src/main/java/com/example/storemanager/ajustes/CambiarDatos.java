package com.example.storemanager.ajustes;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.storemanager.R;
import com.example.storemanager.ajustes.Ajustes;
import com.example.storemanager.menus.MainActivity;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class CambiarDatos extends AppCompatActivity {

    EditText et_nombre_tienda,et_ubicacion,et_dueño,et_telefono,et_ruc,et_categoria;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cambiar_datos);

        et_nombre_tienda=(EditText)findViewById(R.id.cambiar_datos_nombre_tienda);
        et_ubicacion=(EditText)findViewById(R.id.cambiar_datos_ubicacion);
        et_dueño=(EditText)findViewById(R.id.cambiar_datos_dueno);
        et_telefono=(EditText)findViewById(R.id.cambiar_datos_telefono);
        et_ruc=(EditText)findViewById(R.id.cambiar_datos_ruc);
        et_categoria=(EditText)findViewById(R.id.cambiar_datos_categoria);


    }
    public void cancelarBoleta(View view){
        Intent anterior= new Intent(this, Ajustes.class);
        startActivity(anterior);
    }

    public void Guardar(View view){
        try{

            ArrayList<String> bitacora=new ArrayList<String>();
            String archivos[]=fileList();
            if (ArchivoExiste(archivos, "bitacora.txt")){
                try{
                    InputStreamReader archivo_input=  new InputStreamReader(openFileInput("bitacora.txt"));
                    BufferedReader br=new BufferedReader(archivo_input);
                    String linea=br.readLine();


                    while(linea!=null){
                        bitacora.add(linea);
                        linea= br.readLine();
                    }

                    br.close();
                    archivo_input.close();

                    //lo q haras con el string alacenado en bitacoraCompleta
                }catch (Exception e){

                }
            }


            OutputStreamWriter archivo = new OutputStreamWriter(openFileOutput("bitacora.txt", Activity.MODE_PRIVATE));
            String nombre_tienda, ubicacion, dueño, telefono, ruc, categoria;
            nombre_tienda=et_nombre_tienda.getText().toString();
            ubicacion=et_ubicacion.getText().toString();
            dueño=et_dueño.getText().toString();
            telefono=et_telefono.getText().toString();
            ruc=et_ruc.getText().toString();
            categoria=et_categoria.getText().toString();



            String fichero="";
            if(!nombre_tienda.isEmpty()){
                fichero+=nombre_tienda+"\n";
            }else{
                fichero+=bitacora.get(0)+"\n";
            }
            if(!ubicacion.isEmpty()){
                fichero+=ubicacion+"\n";
            }else{
                fichero+=bitacora.get(1)+"\n";
            }
            if(!dueño.isEmpty()){
                fichero+=dueño+"\n";
            }else{
                fichero+=bitacora.get(2)+"\n";
            }
            if(!telefono.isEmpty()){
                fichero+=telefono+"\n";
            }else{
                fichero+=bitacora.get(3)+"\n";
            }
            if(!ruc.isEmpty()){
                fichero+=ruc+"\n";
            }else{
                fichero+=bitacora.get(4)+"\n";
            }
            if(!categoria.isEmpty()){
                fichero+=categoria+"\n";
            }else{
                fichero+=bitacora.get(5)+"\n";
            }

            archivo.write(fichero);//ponle aqui lo q va contener cada linea de texto
            archivo.flush();
            archivo.close();
        }catch (IOException e){

        }
        Toast.makeText(this, "Se guardo correctamente",Toast.LENGTH_SHORT).show();

        Intent i= new Intent(this, Ajustes.class);
        startActivity(i);

    }

    private boolean ArchivoExiste(String archivos [], String NombreArchivo){
        for(int i=0;i<archivos.length;i++){
            if(NombreArchivo.equals(archivos[i])){
                return true;
            }
        }
        return false;
    }
}