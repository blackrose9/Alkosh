package com.example.sarah.alkosh.Data;

import android.provider.BaseColumns;
import android.widget.ImageView;

/**
 * Created by Sarah on 11/23/2017.
 */

public class MyTables {
    public static final class CustomerOrders implements BaseColumns {
        public static final String TABLE_NAME = "orders";
        public static ImageView IMAGE_VIEW;
        public static final String COLUMN_SUPPLIER = "supplier";
        public static final String COLUMN_ORDER_DESC = "orderdesc";
        public static final String COLUMN_ORDER_ITEMS = "orderitems";
    }

    public static final class SupplierOrders implements BaseColumns {
        public static final String TABLE_NAME = "supporders";
        public static final String COLUMN_ORDER_DESC = "supporderdesc";
        public static final String COLUMN_ORDER_ITEMS = "supporderitems";
        public static final String COLUMN_CUSTOMER = "customer";
    }
}
