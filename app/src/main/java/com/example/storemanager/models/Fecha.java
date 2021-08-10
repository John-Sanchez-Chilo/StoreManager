package com.example.storemanager.models;

import java.util.ArrayList;

public class Fecha {
    private int day;
    private int month;
    private int year;

    public Fecha(int day, int month, int year) {
        if(isCorrect(day, month, year)){
            this.day = day;
            this.month = month;
            this.year = year;
        }
        this.day = 1;
        this.month = 1;
        this.year = 2021;
    }

    public Fecha(String date) {
        String tmp="";
        ArrayList<Integer> apoyo=new ArrayList<Integer>();
        String [] helper=date.split("/");
        int day=Integer.parseInt(helper[0]);
        int month=Integer.parseInt(helper[1]);
        int year=Integer.parseInt(helper[2]);

        /*
        int con1=0;
        int con2=0;
        for(int i=0;i<date.length();i++){
            if(date.charAt(i) != '/'){
                con2++;
            }
            else{
                tmp=date.substring(con1,con2);
                apoyo.add(Integer.parseInt(tmp));
                con1=con2;
            }
        }

         */
        if(isCorrect(day, month, year)){
            this.day = day;
            this.month = month;
            this.year = year;
        }
        this.day = 1;
        this.month = 1;
        this.year = 2021;
    }

    private boolean isCorrect(int day, int month, int year){
        int [] dias={31,28,31,30,31,30,31,31,30,31,30,31};
        if(month>12){
            return false;
        }
        if(day>dias[month-1]){
            if(month==2 && day==29){
                return true;
            }
            return false;
        }
        return true;
    }
    private boolean esBisiesto() {
        return (year % 4 == 0);
    }

    public int getDay() {
        return day;
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String toString(){
        String date=String.valueOf(getDay())+"/"+String.valueOf(getMonth())+"/"+String.valueOf(getYear());
        return date;
    }
}
