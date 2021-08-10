package com.example.storemanager.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.storemanager.R;
import com.example.storemanager.models.Producto_Venta;

import java.util.ArrayList;

public class Adaptador_Recycler_Producto extends RecyclerView.Adapter<Adaptador_Recycler_Producto.ViewHolderProducts> implements View.OnClickListener {

    ArrayList<Producto_Venta> listProducts;
    private View.OnClickListener listener;

    public Adaptador_Recycler_Producto(ArrayList<Producto_Venta> listProducts){
        this.listProducts=listProducts;
    }


    @Override
    public ViewHolderProducts onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_item_producto_vendido,null,false);

        view.setOnClickListener(this);
        return new ViewHolderProducts(view);
    }

    @Override
    public void onBindViewHolder(Adaptador_Recycler_Producto.ViewHolderProducts holder, int position) {
        holder.asignarDatos(listProducts.get(position));
    }

    @Override
    public int getItemCount() {
        return listProducts.size();
    }


    public void setOnClickListener(View.OnClickListener listener){
        this.listener=listener;
    }


    @Override
    public void onClick(View view) {
        if(listener!=null){
            listener.onClick(view);
        }
    }

    public class ViewHolderProducts extends RecyclerView.ViewHolder {

        TextView brand_content;
        TextView amount_size ;
        TextView unitary_price;
        TextView amount;
        TextView total_price;

        public ViewHolderProducts(View itemView) {
            super(itemView);
            brand_content =(TextView) itemView.findViewById(R.id.item_producto_vendido_brand_content);
            amount_size =(TextView) itemView.findViewById(R.id.item_producto_vendido_amount_size);
            unitary_price =(TextView) itemView.findViewById(R.id.item_producto_vendido_unitary_price);
            amount =(TextView) itemView.findViewById(R.id.item_producto_vendido_amount);
            total_price=(TextView) itemView.findViewById(R.id.item_producto_vendido_total_price);
        }

        public void asignarDatos(Producto_Venta s) {
            brand_content.setText("   "+s.getNombre()+" - "+s.getMarca());
            amount_size.setText("   "+s.getTamano()+"-"+s.getUnits_pack());
            unitary_price.setText("   "+String.valueOf(s.getPrecio()));
            amount.setText("   "+s.getCantidad()+"");
            float total=s.getCantidad()*s.getPrecio();
            total_price.setText("   "+String.valueOf(total));
        }
    }
}
