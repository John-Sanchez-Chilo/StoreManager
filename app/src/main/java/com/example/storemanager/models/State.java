package com.example.storemanager.models;

public abstract class State {
    protected Producto_Muestra context;

    State(Producto_Muestra context){
        this.context=context;
    }
    public void  setContext(Producto_Muestra context){
        this.context=context;
    }

    public abstract void Handle();
}
