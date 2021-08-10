package com.example.storemanager.models;

public class Item {
    protected int id;
    private static int idSiguiente=1;
    protected boolean isChecked=false;

    public Item(){
        id=idSiguiente;
        idSiguiente++;
    }

    public int getId() {
        return id;
    }

    public boolean isChecked() {
        return isChecked;
    }

    public void setChecked(boolean checked) {
        isChecked = checked;
    }
}

