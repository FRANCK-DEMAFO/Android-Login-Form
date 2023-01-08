package com.example.registerform;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class BaseD extends SQLiteOpenHelper {

    public BaseD(Context context) {

        super(context,"addArticle.db",null,1);

    }

    @Override
    public void onCreate(SQLiteDatabase demoryDB) {
        demoryDB.execSQL("create Table produit(libelle String primary key, quantite int, prix double)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase demoryDB, int i, int i1) {
        demoryDB.execSQL("drop Table if exists produit");

    }
}
