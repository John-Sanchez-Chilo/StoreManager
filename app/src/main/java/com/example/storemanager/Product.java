package com.example.storemanager;

import java.io.Serializable;

public class Product implements Serializable {
    private boolean isChecked;
    private String  name;
    private String brand;
    //private float size;
    private String size;
    private int pack;
    private  int amount;
    private int maxAmount;

    private float price;
    private int  earning;
    private int id;

    public Product(){
        isChecked=false;
        name="Gaseosa";
        brand="Coca-Cola";
        //size= (float) 0.335;
        size="355ml";
        pack= 12;
        amount= 5;
        maxAmount=24;
        price=(float)2.5;
    }

    public Product(String _name,String _brand,float _size, int _pack, int _amount, int _maxAmount,float _price){
        isChecked=false;
        name=_name;
        brand=_brand;
        //size=_size;
        size="Prueba";
        pack=_pack;
        amount=_amount;
        maxAmount=_maxAmount;
        price=_price;
    }

    public Product(int _id,String _name,String _brand,String _size, int _pack,float _price){
        id=_id;

        isChecked=false;
        name=_name;
        brand=_brand;
        size=_size;
        pack=_pack;
        amount=1;
        maxAmount=1;
        price=_price;
    }

    public boolean isChecked() {
        return isChecked;
    }

    public void setChecked(boolean checked) {
        isChecked = checked;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public int getPack() {
        return pack;
    }

    public void setPack(int pack) {
        this.pack = pack;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getMaxAmount() {
        return maxAmount;
    }

    public void setMaxAmount(int maxAmount) {
        this.maxAmount = maxAmount;
    }

    public int getEarning() {
        return earning;
    }

    public void setEarning(int earning) {
        this.earning = earning;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public float precioDeVenta(){
        return (float) 1.0;
    }

    public int getId() {
        return id;
    }
}
