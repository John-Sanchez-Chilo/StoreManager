package com.example.storemanager.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.storemanager.R;

public class Adaptador_Lista_Sunat extends BaseAdapter {


    private static LayoutInflater inflater=null;
    Context context;
    String [][] datos;

    public Adaptador_Lista_Sunat(Context context, String[][] datos){
        this.context=context;
        this.datos=datos;
        inflater=(LayoutInflater)context.getSystemService(context.LAYOUT_INFLATER_SERVICE);

    }

    @Override
    public int getCount() {
        return 4;
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
        final View vista=inflater.inflate(R.layout.elemento_pago_sunat,null);

        TextView id =(TextView) vista.findViewById(R.id.elem_sunat_id);
        TextView fecha =(TextView) vista.findViewById(R.id.elem_sunat_fecha);

        id.setText(datos[i][0]);
        fecha.setText(datos[i][1]);

        return vista;
    }
}
