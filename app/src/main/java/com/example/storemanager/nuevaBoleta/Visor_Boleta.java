 package com.example.storemanager.nuevaBoleta;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.storemanager.Product;
import com.example.storemanager.R;
import com.example.storemanager.adapters.Adaptador_Lista_Boleta_Producto;
import com.example.storemanager.database.AdminSQLiteOpenHelperProducts;
import com.example.storemanager.models.Boleta_Muestra;
import com.example.storemanager.models.Fecha;
import com.example.storemanager.models.Producto_Venta;

import java.util.ArrayList;

 public class Visor_Boleta extends AppCompatActivity {

    TextView nombre,fecha, precio_total;
    ArrayList<Product> listProducts;
     ArrayList<Integer> lista_cantidades;

    ListView lista_productos;

     //declaraciones para la base de datos
     AdminSQLiteOpenHelperProducts admin;
     SQLiteDatabase BaseDeDatos;
     ArrayList<Producto_Venta> lista_productos_venta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visor_boleta);

        nombre=(TextView)findViewById(R.id.visor_boleta_nombre);
        fecha=(TextView)findViewById(R.id.visor_boleta_fecha);
        precio_total=(TextView)findViewById(R.id.visor_boleta_total);

        Bundle b=getIntent().getExtras();

        if(b!=null){
            String string_nombre =b.getString("NOMBRE");
            String string_fecha =b.getString("FECHA");
            String string_codigos_productos =b.getString("CODIGOS");
            String string_cantidades =b.getString("CANTIDADES");

            float total=0;

            admin= new AdminSQLiteOpenHelperProducts(this);//este es el usado

            BaseDeDatos=admin.getWritableDatabase();

            listProducts=new ArrayList<Product>();
            Cursor cursor;

            //separar los codigos para  ponerlos en un array de enteros
            String tmp="";
            int con1=0;
            int con2=0;
            ArrayList<Integer> lista_codigos=new ArrayList<Integer>();
            for(int i=0;i<string_codigos_productos.length();i++){
                if(string_codigos_productos.charAt(i) != '-'){
                    con2++;
                }else{
                    tmp=string_codigos_productos.substring(con1, con2);
                    lista_codigos.add(Integer.parseInt(tmp));
                    con2++;
                    con1=con2;
                }

            }

            //separa lca ncatidades para pnerlos en un array de enteros
            tmp="";
            con1=0;
            con2=0;
            lista_cantidades=new ArrayList<Integer>();
            for(int i=0;i<string_cantidades.length();i++){
                if(string_codigos_productos.charAt(i) != '-'){
                    con2++;
                }else{
                    tmp=string_cantidades.substring(con1, con2);
                    lista_cantidades.add(Integer.parseInt(tmp));
                    con2++;
                    con1=con2;
                }

            }

            for(int i=0;i<lista_codigos.size();i++){
                try{
                    cursor=BaseDeDatos.rawQuery("SELECT NOMBRE, MARCA, TAMANO, PACKETE, PRECIO_VENTA FROM PRODUCTOS1 WHERE CODIGO="+lista_codigos.get(i),null);

                    int id;
                    String name;
                    String brand;
                    String size;
                    int pack;
                    float precio;
                    if(cursor.moveToFirst()){
                        id=lista_codigos.get(i);
                        name=cursor.getString(0);
                        brand=cursor.getString(1);
                        size=cursor.getString(2);
                        pack=cursor.getInt(3);
                        precio=cursor.getFloat(4);
                        Product p=new Product(id,name,brand, size, pack, precio);
                        Producto_Venta producto_venta=new Producto_Venta(id, name, brand,size, pack,precio,lista_cantidades.get(i));
                        total+=p.getPrice();
                        listProducts.add(p);
                        lista_productos_venta.add(producto_venta);


                    }
                    else {
                        Toast.makeText(this, "En visor boleta hay falla", Toast.LENGTH_SHORT).show();

                    }
                }catch (Exception e){
                    //Toast.makeText(this, "Exception en visor boleta", Toast.LENGTH_SHORT).show();
                }
            }
            BaseDeDatos.close();

            Boleta_Muestra boleta=new Boleta_Muestra( string_nombre,new Fecha(string_fecha),lista_productos_venta);

            nombre.setText(string_nombre);
            fecha.setText(string_fecha);
            precio_total.setText(total+"");
        }


        lista_productos=(ListView)findViewById(R.id.visor_boleta_listview);
        lista_productos.setAdapter(new Adaptador_Lista_Boleta_Producto(this, listProducts,lista_cantidades));

    }



}