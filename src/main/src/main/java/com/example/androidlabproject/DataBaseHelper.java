package com.example.androidlabproject;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class DataBaseHelper extends android.database.sqlite.SQLiteOpenHelper{

    public DataBaseHelper(Context context, String name,
                          SQLiteDatabase.CursorFactory factory, int version)
    { super(context, name, factory, version); }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE Categories(ID LONG PRIMARY KEY,NAME TEXT)");
        sqLiteDatabase.execSQL("CREATE TABLE Properties(ID LONG PRIMARY KEY,TITLE TEXT, TYPE TEXT, PRICE INT, LOCATION TEXT, AREA TEXT, BEDROOMS INT, BATHROOMS INT, IMAGE TEXT, DESCRIPTION TEXT)");
    }

    public void insertCategorie(Categorie categorie) {
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("ID", categorie.getId());
        contentValues.put("NAME", categorie.getName());
        sqLiteDatabase.insert("Categories", null, contentValues);
    }

    public Cursor getAllCategorie() {
        SQLiteDatabase sqLiteDatabase = getReadableDatabase();
        return sqLiteDatabase.rawQuery("SELECT * FROM Categories", null);
    }

    public void insertPropertie(Propertie propertie)
    {
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put("ID", propertie.getId());
        contentValues.put("TITLE", propertie.getTitle());
        contentValues.put("TYPE", propertie.getType());
        contentValues.put("PRICE", propertie.getPrice());
        contentValues.put("LOCATION", propertie.getLocation());
        contentValues.put("AREA", propertie.getArea());
        contentValues.put("BEDROOMS", propertie.getBedrooms());
        contentValues.put("BATHROOMS", propertie.getBathrooms());
        contentValues.put("IMAGE", propertie.getImage_url());
        contentValues.put("DESCRIPTION", propertie.getDescription());

        sqLiteDatabase.insert("Properties", null, contentValues);
    }

    public Cursor getAllProperties()
    {
        SQLiteDatabase sqLiteDatabase = getReadableDatabase();
        return sqLiteDatabase.rawQuery("SELECT * FROM Properties", null);
    }
}
