package com.example.storemanager.menus;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.storemanager.R;
import com.example.storemanager.VisorSunat;
import com.example.storemanager.adapters.Adaptador_Lista_Sunat;

import java.util.ArrayList;
import java.util.Arrays;



public class sunatFragment<i> extends Fragment {
    @Nullable

    ListView lista_sunat;
    String [][] datos = {
            {"id","fecha"},{"1","may-2021"},{"2","june-2021"},{"3","july-2021"}
    };

    int lista[];
    String [] nombre={"john", "Edson", "Sanchez ", "Chilo"};
    ArrayList<String> nombres = new ArrayList<String>(Arrays.asList(nombre));



    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.sunatfragment,null);


    }
    @Override
    public void onActivityCreated(Bundle state){
        super.onActivityCreated(state);
        lista_sunat=(ListView)getView().findViewById(R.id.lista_sunat);
        lista_sunat.setAdapter(new Adaptador_Lista_Sunat(getActivity().getApplicationContext(),datos));

        lista_sunat.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id){
                Intent visorDetalles=new Intent(view.getContext(), VisorSunat.class);
                visorDetalles.putExtra("TIT", datos[position][0]);
                visorDetalles.putExtra("DET", datos[position][1]);
                startActivity(visorDetalles);
            }
        });

    }
}
