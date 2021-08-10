package com.example.storemanager.menus;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
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
import com.example.storemanager.nuevaBoleta.Visor_Boleta;
import com.example.storemanager.adapters.Adaptador_Lista_Boleta;
import com.example.storemanager.database.AdminSQLiteOpenHelperProducts;
import com.example.storemanager.database.DatabaseAccess;
import com.example.storemanager.models.Boleta_antigua;

import java.util.ArrayList;

public class boletasFragment extends Fragment {
    @Nullable

    ListView lista_boletas;
    ArrayList<ArrayList<String>> listBoletas;
    ArrayList<Boleta_antigua> listBoletasOficial;

    //declaraciones para la base de datos
    AdminSQLiteOpenHelperProducts admin;
    SQLiteDatabase BaseDeDatos;


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.boletasfragment,null);
    }
    @Override
    public void onActivityCreated(Bundle state){
        super.onActivityCreated(state);
        lista_boletas=(ListView)getView().findViewById(R.id.boletasfragment_listview);


        //para obtener info de la base de datos
        listBoletas=new ArrayList<ArrayList<String>>();
        listBoletasOficial=new ArrayList<Boleta_antigua>();

        DatabaseAccess databaseAccess=DatabaseAccess.getInstance(getContext());
        databaseAccess.open();
        listBoletasOficial=databaseAccess.getListaBoleta_Antigua();
        databaseAccess.close();


        lista_boletas.setAdapter(new Adaptador_Lista_Boleta(getActivity().getApplicationContext(),listBoletasOficial));


        lista_boletas.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id){
                Intent visorDetalles=new Intent(view.getContext(), Visor_Boleta.class);
                visorDetalles.putExtra("NOMBRE", listBoletasOficial.get(position).getName());
                visorDetalles.putExtra("FECHA", listBoletasOficial.get(position).getDate());
                visorDetalles.putExtra("CODIGOS", listBoletasOficial.get(position).getCodigos_productos());
                visorDetalles.putExtra("CANTIDADES", listBoletasOficial.get(position).getCantidades_productos());
                startActivity(visorDetalles);
            }
        });





    }

}
