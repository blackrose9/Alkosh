package com.example.sarah.alkosh;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.sarah.alkosh.Customer.CustomerActivity;

public class SupplierList extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_supplier_list);
    }

    public void supplpage(View view){
        Intent intent = new Intent(this, CustomerActivity.class);
        startActivity(intent);
    }

}
