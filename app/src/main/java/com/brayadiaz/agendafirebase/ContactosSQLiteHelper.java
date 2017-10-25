package com.brayadiaz.agendafirebase;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by braya on 25/10/2017.
 */

public class ContactosSQLiteHelper extends SQLiteOpenHelper {

    String DATA_BASE_NAME = "AgendaBD";
    int DATA_VERSION = 1;

    String sqlCreate="CREATE TABLE contactos(" +
            "id         INTEGER PRIMARY KEY AUTOINCREMENT," + //0
            "name       TEXT," +    //1
            "phone      TEXT," +    //2
            "email      TEXT)";     //3

    public ContactosSQLiteHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(sqlCreate);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS contactos");
        db.execSQL(sqlCreate);

    }
}