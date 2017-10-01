package com.spacemindz.www.spacemindz001;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.widget.LinearLayoutCompat;
import android.telephony.SignalStrength;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sponch on 2017/09/30.
 */

public class DatabaseHandler extends SQLiteOpenHelper {

    //Database version
    private static final int DATABASE_VERION = 1;

    //Database Name
    private static final String DATABASE_NAME = "SpaceMindZ";
    private static final String TABLE_ITEMS = "item_table";

    //Item table Colums names
    private static final String KEY_ID = "item_id";
    private static final String KEY_ITEM_NAME = "item_name";
    private static final String KEY_ITEM_PRICE = "item_price";
    private static final String KEY_ITEM_RATING = "item_rating";
    private static final String KEY_ITEM_SELLERID = "seller_id";

    public DatabaseHandler(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERION);
    }

    //Creating Tables
    @Override
    public void onCreate(SQLiteDatabase db)
    {
        String CREATE_ITEM_TABLE = "CREATE TABLE " + TABLE_ITEMS + "("
                + KEY_ID + " INTEGER PRIMARY KEY," + KEY_ITEM_NAME + " TEXT,"
                + KEY_ITEM_PRICE + " NUMBER," + KEY_ITEM_RATING + " NUMBER,"
                + KEY_ITEM_SELLERID + " NUMBER" + ")";
        db.execSQL(CREATE_ITEM_TABLE);
    }

    //Upgrading database

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        //Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_ITEMS);
        onCreate(db);
    }


    //Add new item
    public void addBackEnd(BackEnd backEnd){
        SQLiteDatabase db = getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_ID, backEnd.getItemId());
        values.put(KEY_ITEM_NAME, backEnd.getItemName());
        values.put(KEY_ITEM_PRICE, backEnd.getPrice());
        values.put(KEY_ITEM_RATING, backEnd.getRating());
        values.put(KEY_ITEM_SELLERID, backEnd.getSellerId());

        //Insert the row
        db.insert(TABLE_ITEMS, null, values);
        db.close(); // closing the database connection
    }

    //getting single contact
    public BackEnd getBackEnd(int id){
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_ITEMS, new String[] {KEY_ID,
                KEY_ITEM_NAME,KEY_ITEM_PRICE,KEY_ITEM_RATING, KEY_ITEM_SELLERID} , KEY_ID + "=?",
                new String[]{ String.valueOf(id)}, null, null, null, null);
        if (cursor != null)
        {
            cursor.moveToFirst();
        }

        BackEnd backEnd = new BackEnd(Integer.parseInt(cursor.getString(0)),
                cursor.getString(1),  Double.parseDouble(cursor.getString(2)), Integer.parseInt(cursor.getString(3)),Integer.parseInt(cursor.getString(4)));


        //return backend
        return backEnd;
    }

    //Getting All Contacts
    public List<BackEnd> getWholeBack(){
        List<BackEnd> itemList = new ArrayList<BackEnd>();

        //select all query
        String selectQuery = "SELECT * FROM " + TABLE_ITEMS;

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        //looping through
        if (cursor.moveToFirst()){
            do{
                BackEnd item = new BackEnd();
                item.setItemId(Integer.parseInt(cursor.getString(0)));
                item.setItemName(cursor.getString(1));
                item.setItemPrice(Double.parseDouble(cursor.getString(2)));
                item.setRating(Integer.parseInt(cursor.getString(3)));
                item.setSellerId(Integer.parseInt(cursor.getString(4)));
            }while (cursor.moveToFirst());
        }

        //return items
        return itemList;
    }



    //updating Items
    public int updateContact(BackEnd backEnd){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_ID, backEnd.getItemId());
        values.put(KEY_ITEM_NAME, backEnd.getItemName());
        values.put(KEY_ITEM_PRICE, backEnd.getPrice());
        values.put(KEY_ITEM_RATING, backEnd.getRating());
        values.put(KEY_ITEM_SELLERID, backEnd.getSellerId());

        return db.update(TABLE_ITEMS, values, KEY_ID +  " =?",
                new String[]{String.valueOf(backEnd.getItemId())});
    }

    //Deleting single items
    public void deleteItem(BackEnd backEnd){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_ITEMS, KEY_ID + " = ?",
                new String[]{String.valueOf(backEnd.getItemId())});
                db.close();
    }


    //Getng contacts Count
    public int getItemCount(){
        String countQuery = "SELECT * FROM " + TABLE_ITEMS;
        SQLiteDatabase  db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        cursor.close();

        //return cout
        return cursor.getCount();
    }
}
