package com.example.dell.inventoryappstage1;

import android.net.Uri;
import android.provider.BaseColumns;

public final class InventoryContract {
    public static final String CONTENT_AUTHORITY = "com.example.dell.inventoryappstage1";
    public static final Uri BASE_CONTENT_URL = Uri.parse("content://"+ CONTENT_AUTHORITY);
    public static final String PATH_PRODUCTS = "products";

    public static final class InventoryEntry implements BaseColumns {
        public static final String TABLE_NAME = "products"; //Table name
        public static  final String _ID = BaseColumns._ID; //columnId
        public static final String COLUMN_PRODUCT_NAME = "name"; //name of the product
        public static final String COLUMN_PRODUCT_PRICE = "price"; //price of the product
        public static final String COLUMN_PRODUCT_QUANTITIY = "quantity";
        public static final String COLUMN_SUPPLIER_NAME = "supplier";
        public static final String COLUMN_SUPPLIER_PHONE = "phone";

        public static final Uri CONTENT_URI = Uri.withAppendedPath(BASE_CONTENT_URL,PATH_PRODUCTS);

    }
}
