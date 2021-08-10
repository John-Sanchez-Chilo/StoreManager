package com.example.storemanager.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.storemanager.Product;
import com.example.storemanager.R;

import java.util.ArrayList;

public class Adaptador_Lista_Boleta_Producto extends BaseAdapter {

    private static LayoutInflater inflater=null;
    Context context;

    ArrayList<Product> listproducts;
    ArrayList<Integer> cantidades;

    public Adaptador_Lista_Boleta_Producto(Context context, ArrayList<Product> _listproducts,ArrayList<Integer> _cantidades){
        this.context=context;
        this.listproducts=_listproducts;
        this.cantidades=_cantidades;
        inflater=(LayoutInflater)context.getSystemService(context.LAYOUT_INFLATER_SERVICE);

    }
    @Override
    public int getCount() {
        return listproducts.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int i, View convertView, ViewGroup parent) {
        final View vista=inflater.inflate(R.layout.listview_item_boleta_producto,null);

        TextView name_brand =(TextView) vista.findViewById(R.id.item_boleta_producto_nombre_marca);
        TextView tamaño =(TextView) vista.findViewById(R.id.item_boleta_producto_tamano);
        TextView pack =(TextView) vista.findViewById(R.id.item_boleta_producto_packete);
        TextView price=(TextView)vista.findViewById(R.id.item_boleta_producto_precio);
        TextView amount =(TextView) vista.findViewById(R.id.item_boleta_producto_cantidad);
        TextView total_price=(TextView)vista.findViewById(R.id.item_boleta_producto_precio_total);

        name_brand.setText("   "+listproducts.get(i).getName()+" "+listproducts.get(i).getBrand());
        tamaño.setText("   "+listproducts.get(i).getSize()+"");
        pack.setText("   [1 - "+listproducts.get(i).getPack()+" ]");
        price.setText("   "+listproducts.get(i).getPrice()+"");

        amount.setText(cantidades.get(i)+"");
        total_price.setText((listproducts.get(i).getPrice()*cantidades.get(i))+"");

        return vista;
    }
}
