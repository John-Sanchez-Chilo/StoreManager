package com.example.storemanager.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.storemanager.models.Boleta_antigua;
import com.example.storemanager.R;

import java.util.ArrayList;

public class Adaptador_Lista_Boleta extends BaseAdapter {

    Context context;

    ArrayList<Boleta_antigua> listaBoletasOficial;
    private static LayoutInflater inflater=null;

    public Adaptador_Lista_Boleta(Context _context, ArrayList<Boleta_antigua> _listBoletaAntiguas){
        this.context=_context;
        this.listaBoletasOficial= _listBoletaAntiguas;

        inflater=(LayoutInflater)context.getSystemService(context.LAYOUT_INFLATER_SERVICE);

    }


    @Override
    public int getCount() {
        return listaBoletasOficial.size();
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
        final View vista=inflater.inflate(R.layout.listview_item_boleta,null);

        TextView numero =(TextView) vista.findViewById(R.id.item_boleta_numero);
        TextView nombre =(TextView) vista.findViewById(R.id.item_boleta_nombre);
        TextView fecha =(TextView) vista.findViewById(R.id.item_boleta_fecha);


        numero.setText(listaBoletasOficial.get(i).getId()+"");
        nombre.setText(listaBoletasOficial.get(i).getName());
        fecha.setText(listaBoletasOficial.get(i).getDate());

        return vista;
    }
}
