package com.example.storemanager.database;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class AdminSQLiteOpenHelperProducts extends SQLiteOpenHelper{

    private static final String DATABASE_NAME="TIENDA1.db";
    private static final int DATABASE_VERSION=1;


    public AdminSQLiteOpenHelperProducts(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }



    @Override
    public void onCreate(SQLiteDatabase db) {
        //para la creacion de la tabla PRODUCTOS
        StringBuilder sb=new StringBuilder();
        sb.append("CREATE TABLE IF NOT EXISTS PRODUCTOS1(");
        sb.append("CODIGO INT PRIMARY KEY, ");
        sb.append("NOMBRE VARCHAR(50), ");
        sb.append("MARCA VARCHAR(100) NOT NULL, ");
        sb.append("TAMANO VARCHAR(50) NOT NULL,");
        sb.append("PACKETE INT DEFAULT 1,");
        sb.append("PRECIO_COMPRA NUMERIC(3,2),");
        sb.append("PRECIO_VENTA NUMERIC(3,2), ");
        sb.append("MAX_PACKETES INT DEFAULT 1,");
        sb.append("ACTUAL_PACKETES INT DEFAULT 0,");
        sb.append("ACTUAL_UNIDADES INT DEFAULT 0)");
        sb.append(";");


        StringBuilder bo=new StringBuilder();
        bo.append("CREATE TABLE IF NOT EXISTS BOLETAS(");
        bo.append("CODIGO INT PRIMARY KEY, ");
        bo.append("NOMBRE VARCHAR(50), ");
        bo.append("FECHA VARCHAR(100) NOT NULL, ");
        bo.append("PRODUCTOS VARCHAR(500) NOT NULL,");
        bo.append("CANTIDADES VARCHAR(500) NOT NULL)");
        bo.append(";");

        db.execSQL(sb.toString());

        db.execSQL(bo.toString());
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }


}
