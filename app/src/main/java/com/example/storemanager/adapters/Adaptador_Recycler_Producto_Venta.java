package com.example.storemanager.adapters;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;

import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.storemanager.Product;
import com.example.storemanager.R;
import com.example.storemanager.models.Producto_Venta;

import java.util.ArrayList;

public class Adaptador_Recycler_Producto_Venta extends RecyclerView.Adapter<Adaptador_Recycler_Producto_Venta.ViewHolderProductos_Venta> {

    ArrayList<Product> listProducts;
    ArrayList<Product> selectedItems=new ArrayList<>();
    ArrayList<Producto_Venta> lista_productos_venta;

    public Adaptador_Recycler_Producto_Venta(ArrayList<Producto_Venta> listProducts){
        this.lista_productos_venta=listProducts;
    }


    @Override
    public ViewHolderProductos_Venta onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_item_producto_venta,null,false);

        return new ViewHolderProductos_Venta(view);
    }

    @Override
    public void onBindViewHolder(Adaptador_Recycler_Producto_Venta.ViewHolderProductos_Venta holder, int position) {

        final Producto_Venta product=lista_productos_venta.get(position);

        holder.name_brand.setText("   "+product.getNombre()+" - "+product.getMarca()+" - "+product.getTamano());
        holder.size_pack.setText("     "+product.getTamano()+" - [1-"+product.getUnits_pack()+"]");
        holder.unitary_price.setText("   "+String.valueOf(product.getPrecio()));
        holder.total_price.setText(product.getPrecioTotal()+"");
        holder.amount.setText(product.getCantidad()+"");


        holder.view.setBackgroundColor(product.isChecked()?Color.CYAN:Color.WHITE);
        holder.name_brand.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                product.setChecked(!product.isChecked());
                holder.view.setBackgroundColor(product.isChecked()?Color.CYAN:Color.WHITE);
            }
        });

    }

    @Override
    public int getItemCount() {
        return lista_productos_venta.size();
    }


    public class ViewHolderProductos_Venta extends RecyclerView.ViewHolder {
        private View view;
        TextView name_brand;
        TextView size_pack ;
        TextView unitary_price;
        TextView total_price;
        TextView amount;


        public ViewHolderProductos_Venta(View itemView) {
            super(itemView);
            view=itemView;


            name_brand =(TextView) itemView.findViewById(R.id.producto_venta_name_brand);
            size_pack =(TextView) itemView.findViewById(R.id.producto_venta_size_pack);
            unitary_price =(TextView) itemView.findViewById(R.id.producto_venta_unitary_price);
            total_price=(TextView) itemView.findViewById(R.id.producto_venta_total_price);

            amount=(TextView) itemView.findViewById(R.id.producto_venta_amount);

        }


    }

    public ArrayList<Product> getAll(){
        return listProducts;
    }
    public ArrayList<Product> getSelected(){
        ArrayList<Product> selected = new ArrayList<>();
        for(int i=0;i<selectedItems.size();i++){
            if(listProducts.get(i).isChecked()){
                selected.add(listProducts.get(i));
            }
        }
        return selected;
    }

}
