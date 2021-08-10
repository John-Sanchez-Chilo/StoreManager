package com.example.storemanager.models;

public class State_Not_Stock extends State{
    State_Not_Stock(Producto_Muestra context) {
        super(context);
    }

    @Override
    public void Handle() {
        context.changeState(new State_In_Stock(context));
    }
}
