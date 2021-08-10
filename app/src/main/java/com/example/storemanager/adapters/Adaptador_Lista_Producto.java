package com.example.storemanager.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.storemanager.R;
import com.example.storemanager.models.Producto_Muestra;

import java.util.ArrayList;

public class Adaptador_Lista_Producto extends BaseAdapter {

    private static LayoutInflater inflater=null;
    Context context;
    ArrayList<Producto_Muestra> products;

    public Adaptador_Lista_Producto(Context context, ArrayList<Producto_Muestra> products){
        this.context=context;
        this.products=products;
        inflater=(LayoutInflater)context.getSystemService(context.LAYOUT_INFLATER_SERVICE);

    }

    @Override
    public int getCount() {
        return products.size();
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
        final View vista=inflater.inflate(R.layout.listview_item_producto_muestra,null);

        TextView name_brand =(TextView) vista.findViewById(R.id.name_brand);
        TextView size_pack =(TextView) vista.findViewById(R.id.size_pack);
        TextView buy_price =(TextView) vista.findViewById(R.id.buy_price);
        TextView price=(TextView)vista.findViewById(R.id.price);
        TextView max_amount =(TextView) vista.findViewById(R.id.max);
        TextView actual_pack=(TextView)vista.findViewById(R.id.actual_pack);
        TextView actual_unit=(TextView)vista.findViewById(R.id.actual_unit);


        name_brand.setText("ID:"+products.get(i).getId()+" - "+products.get(i).getNombre()+" "+products.get(i).getMarca());
        size_pack.setText(products.get(i).getTamano()+" - [1x"+products.get(i).getUnits_pack()+"]");
        max_amount.setText("Max pack: "+products.get(i).getMax_packetes());
        buy_price.setText("Precio compra: S/ "+products.get(i).getPrecio_compra());
        price.setText("Precio venta: S/ "+products.get(i).getPrecio_venta());
        actual_pack.setText("Actual pack: "+products.get(i).getCantidad_packetes());
        actual_unit.setText("Actual Unit: "+products.get(i).getCantidad_unidades());

        return vista;
    }
}
