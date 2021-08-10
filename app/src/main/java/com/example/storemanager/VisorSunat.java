package com.example.storemanager;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class VisorSunat extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visor_sunat);

        TextView ruc=(TextView)findViewById(R.id.sunat_ruc);
        TextView periodo=(TextView)findViewById(R.id.sunat_periodo);
        TextView ingresos=(TextView)findViewById(R.id.sunat_ingresos);
        TextView compras=(TextView)findViewById(R.id.sunat_compras);
        TextView categoria=(TextView)findViewById(R.id.sunat_categoria);
        TextView percepcion=(TextView)findViewById(R.id.sunat_percepcion);
        TextView importe=(TextView)findViewById(R.id.sunat_importe);

        Intent intent = getIntent();
        Bundle b =intent.getExtras();
        if(b!=null){
            ruc.setText(b.getString("TIT"));
            periodo.setText(b.getString("DET"));
            /*
            periodo.setText(b.getString("PER"));
            ingresos.setText(b.getString("ING"));
            compras.setText(b.getString("COM"));
            categoria.setText(b.getString("CAT"));
            percepcion.setText(b.getString("PERC"));
            importe.setText(b.getString("IMP"));
            */
        }

    }
}