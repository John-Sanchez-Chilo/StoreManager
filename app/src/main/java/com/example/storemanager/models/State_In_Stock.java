package com.example.storemanager.models;

public class State_In_Stock extends State {
    State_In_Stock(Producto_Muestra context) {
        super(context);
    }

    @Override
    public void Handle() {
        context.changeState(new State_Not_Stock(context));
    }
}
