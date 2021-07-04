package com.example.storemanager;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class comprasFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.comprasfragment,null);
    }
    //no funciona darle evento al boton desde la clase fragment
    /*
    public void nuevaBoleta(View view){
        Intent formBoleta= new Intent(this,NuevaBoleta.class)
        startActivity(formBoleta);
    }
    */
}
