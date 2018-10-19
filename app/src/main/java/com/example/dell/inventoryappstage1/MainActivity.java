package com.example.dell.inventoryappstage1;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
     InventoryDBHelper dbHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dbHelper  = new InventoryDBHelper(this);
        SQLiteDatabase db = dbHelper.getWritableDatabase();


        saveProduct(db);
        readProduct();


    }
    private void saveProduct(SQLiteDatabase db){
        ContentValues values1 = new ContentValues();
        //Item no 1
        values1.put(InventoryContract.InventoryEntry.COLUMN_PRODUCT_NAME,"BOOK");
        values1.put(InventoryContract.InventoryEntry.COLUMN_PRODUCT_PRICE, 130);
        values1.put(InventoryContract.InventoryEntry.COLUMN_PRODUCT_QUANTITIY,11);
        values1.put(InventoryContract.InventoryEntry.COLUMN_SUPPLIER_NAME,"RAMESH");
        values1.put(InventoryContract.InventoryEntry.COLUMN_SUPPLIER_PHONE,"889879704");
        db.insert(InventoryContract.InventoryEntry.TABLE_NAME,null,values1);

        ContentValues values2  = new ContentValues();
        values2.put(InventoryContract.InventoryEntry.COLUMN_PRODUCT_NAME,"Wallet");
        values2.put(InventoryContract.InventoryEntry.COLUMN_PRODUCT_PRICE, 225);
        values2.put(InventoryContract.InventoryEntry.COLUMN_PRODUCT_QUANTITIY,3);
        values2.put(InventoryContract.InventoryEntry.COLUMN_SUPPLIER_NAME,"RIHAN");
        values2.put(InventoryContract.InventoryEntry.COLUMN_SUPPLIER_PHONE,"8835354704");
        db.insert(InventoryContract.InventoryEntry.TABLE_NAME,null,values2);


    }
    private void readProduct() {
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        String sortOrder = InventoryContract.InventoryEntry._ID + " DESC";

        Cursor cursor = db.query(InventoryContract.InventoryEntry.TABLE_NAME,null,null,null,null,null,sortOrder);
       while (cursor.moveToNext()){
           String name = cursor.getString(
                   cursor.getColumnIndexOrThrow(InventoryContract.InventoryEntry.COLUMN_PRODUCT_NAME)
           );
           Log.i(TAG, "readProduct: "+name);
       }
       cursor.close();
    }

}
