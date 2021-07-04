package com.example.storemanager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private TextView compras, boletas,pedidos,sunat;
    private PagerViewAdapter pagerViewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        compras=findViewById(R.id.compras);
        boletas=findViewById(R.id.boletas);
        pedidos=findViewById(R.id.pedidos);
        sunat=findViewById(R.id.sunat);
        viewPager=findViewById(R.id.FragmentContainer);

        compras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewPager.setCurrentItem(0);
            }
        });
        boletas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewPager.setCurrentItem(1);
            }
        });
        pedidos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewPager.setCurrentItem(2);
            }
        });
        sunat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewPager.setCurrentItem(3);
            }
        });

        pagerViewAdapter=new PagerViewAdapter(getSupportFragmentManager());
        viewPager.setAdapter(pagerViewAdapter);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                onChangeTab(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });


    }
    //esto es del menu de  izquieda a derecha
    private void onChangeTab(int position) {
        if(position==0){
            compras.setTextSize(20);
            boletas.setTextSize(15);
            pedidos.setTextSize(15);
            sunat.setTextSize(15);
        }
        if(position==1){
            compras.setTextSize(15);
            boletas.setTextSize(20);
            pedidos.setTextSize(15);
            sunat.setTextSize(15);
        }
        if(position==2){
            compras.setTextSize(15);
            boletas.setTextSize(15);
            pedidos.setTextSize(20);
            sunat.setTextSize(15);
        }
        if(position==3){
            compras.setTextSize(15);
            boletas.setTextSize(15);
            pedidos.setTextSize(15);
            sunat.setTextSize(20);
        }
    }


    //esto es delmenu de tres puntitos de la parte derecha
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.overflow,menu);
        return super.onCreateOptionsMenu(menu);
    }


    //metodo para el boton nueva boleta

    public void nuevaBoleta(View view){
        Intent formBoleta= new Intent(this,NuevaBoleta.class);
        startActivity(formBoleta);
    }
    //metodo para el boton nuevo pedido
    public void nuevoPedido(View view){
        Intent formPedido= new Intent(this,NuevoPedido.class);
        startActivity(formPedido);
    }
    //metodo para el boton de productos
    public void moveToProductos(View view){
        Intent formPedido= new Intent(this,Productos.class);
        startActivity(formPedido);
    }


    //metodo para el boton de ajustes del main
    public void moveToAjustes(View view){
        Intent formPedido= new Intent(this,Ajustes.class);
        startActivity(formPedido);
    }

    //metodo para adignarle funciones correspondientes a las opciones
    public boolean onOptionsItemSelected(MenuItem  item){
        int id=item.getItemId();
        if(id==R.id.item1){
            Toast.makeText(this,"Opcion 1",Toast.LENGTH_SHORT).show();
        }
        else if(id==R.id.item2){
            //Toast.makeText(this,"Ajustes",Toast.LENGTH_SHORT).show();
            //esats dos lineas es para aabrir el activity de ajustes
            Intent formPedido= new Intent(this,Ajustes.class);
            startActivity(formPedido);
        }
        return super.onOptionsItemSelected(item);
    }
    /*modificandomodificandomodificandomodificandomodificando*/
}