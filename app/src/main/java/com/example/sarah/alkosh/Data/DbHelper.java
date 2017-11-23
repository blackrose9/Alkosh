package com.example.sarah.alkosh.Data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Sarah on 11/23/2017.
 */

public class DbHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "waitlist.db";
    private static final int DATABASE_VERSION = 1;

    // constructor
    public DbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    // override onCreate to create actual database
    public void onCreate(SQLiteDatabase sqLiteDatabase){

        final String SQL_CREATE_CUSTOMER_ORDER_TABLE = "CREATE TABLE " +
                MyTables.CustomerOrders.TABLE_NAME + "(" +
                MyTables.CustomerOrders._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                MyTables.CustomerOrders.COLUMN_ORDER_DESC + " TEXT NOT NULL, " +
                MyTables.CustomerOrders.COLUMN_ORDER_ITEMS + " TEXT NOT NULL, " +
                MyTables.CustomerOrders.COLUMN_SUPPLIER + " TEXT NOT NULL" +
                ");";

        final String SQL_CREATE_SUPPLIER_ORDER_TABLE = "CREATE TABLE " +
                MyTables.CustomerOrders.TABLE_NAME + "(" +
                MyTables.CustomerOrders._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                MyTables.CustomerOrders.COLUMN_ORDER_DESC + " TEXT NOT NULL, " +
                MyTables.CustomerOrders.COLUMN_ORDER_ITEMS + " TEXT NOT NULL, " +
                MyTables.CustomerOrders.COLUMN_SUPPLIER + " TEXT NOT NULL" +
                ");";

        // Execute query
        sqLiteDatabase.execSQL(SQL_CREATE_CUSTOMER_ORDER_TABLE);
        sqLiteDatabase.execSQL(SQL_CREATE_SUPPLIER_ORDER_TABLE);
    }

    // override upgrade method -- for future upgrades
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1){
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + MyTables.CustomerOrders.TABLE_NAME);
        onCreate(sqLiteDatabase);
    }
}


