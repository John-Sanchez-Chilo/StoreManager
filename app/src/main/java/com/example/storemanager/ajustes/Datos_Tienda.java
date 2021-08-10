package com.example.storemanager.ajustes;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.example.storemanager.R;
import com.example.storemanager.models.Propietario;
import com.example.storemanager.models.Tienda;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Datos_Tienda extends AppCompatActivity {

    TextView tv_nombre_tienda,tv_ubicacion,tv_dueño,tv_telefono,tv_ruc,tv_categoria;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datos_tienda);

        tv_nombre_tienda=(TextView)findViewById(R.id.datos_tienda_nombre_tienda);
        tv_ubicacion=(TextView)findViewById(R.id.datos_tienda_ubicacion);
        tv_dueño=(TextView)findViewById(R.id.datos_tienda_dueno);
        tv_telefono=(TextView)findViewById(R.id.datos_tienda_telefono);
        tv_ruc=(TextView)findViewById(R.id.datos_tienda_ruc);
        tv_categoria=(TextView)findViewById(R.id.datos_tienda_categoria);

        String archivos[]=fileList();
        if (ArchivoExiste(archivos, "bitacora.txt")){
            try{
                InputStreamReader archivo=  new InputStreamReader(openFileInput("bitacora.txt"));
                BufferedReader br=new BufferedReader(archivo);
                String linea=br.readLine();
                ArrayList<String> bitacora=new ArrayList<String>();

                while(linea!=null){
                    bitacora.add(linea);
                    linea= br.readLine();
                }
                int telefono=Integer.parseInt(bitacora.get(3));
                long ruc=Long.parseLong(bitacora.get(4));
                int categoria=Integer.parseInt(bitacora.get(5));

                Tienda t=new Tienda(bitacora.get(0),bitacora.get(1));
                Propietario p=new Propietario(bitacora.get(2),telefono,ruc,categoria);

                tv_nombre_tienda.setText(t.getNombre());
                tv_ubicacion.setText(t.getUbicacion());
                tv_dueño.setText(p.getNombre());
                tv_telefono.setText(p.getTelefono()+"");
                tv_ruc.setText(p.getRuc()+"");
                tv_categoria.setText(p.getCategoria()+"");

                br.close();
                archivo.close();

                //lo q haras con el string alacenado en bitacoraCompleta
            }catch (Exception e){

            }
        }
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