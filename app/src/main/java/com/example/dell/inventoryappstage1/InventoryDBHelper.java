package com.example.dell.inventoryappstage1;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class InventoryDBHelper extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "Inventory.db";
    public static final String TEXT_TYPE = " TEXT";
    public static final String INTEGER_TYPE = " INTEGER";
    public static final String COMMA_SEPARATOR = ", ";
    public static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " +
            InventoryContract.InventoryEntry.TABLE_NAME + " (" +
                    InventoryContract.InventoryEntry._ID+ " INTEGER PRIMARY KEY"+COMMA_SEPARATOR +
                    InventoryContract.InventoryEntry.COLUMN_PRODUCT_NAME + TEXT_TYPE + COMMA_SEPARATOR +
                    InventoryContract.InventoryEntry.COLUMN_PRODUCT_PRICE + INTEGER_TYPE + COMMA_SEPARATOR +
                    InventoryContract.InventoryEntry.COLUMN_PRODUCT_QUANTITIY + INTEGER_TYPE + COMMA_SEPARATOR +
                    InventoryContract.InventoryEntry.COLUMN_SUPPLIER_NAME + TEXT_TYPE + COMMA_SEPARATOR +
                    InventoryContract.InventoryEntry.COLUMN_SUPPLIER_PHONE + TEXT_TYPE + " );";
    private static final String SQL_DELETE_ENTRIES = "DROP TABLE IF EXISTS" + InventoryContract.InventoryEntry.TABLE_NAME;
    public InventoryDBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
             db.execSQL(SQL_CREATE_ENTRIES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL(SQL_DELETE_ENTRIES);
            onCreate(db);
    }

    public void onDowngrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        onUpgrade(sqLiteDatabase, oldVersion, newVersion);
    }
}
