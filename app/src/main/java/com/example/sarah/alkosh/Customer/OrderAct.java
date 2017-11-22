package com.example.sarah.alkosh.Customer;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.sarah.alkosh.ChatAct;
import com.example.sarah.alkosh.R;
import com.example.sarah.alkosh.Customer.CustomerActivity;

public class OrderAct extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

//        FloatingActionButton fabChat = (FloatingActionButton) findViewById(R.id.fabChat);
//        fabChat.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Chat with the Supplier", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
////                Intent chat = new Intent(this, CustomerActivity.class);
////                startActivity(chat);
//            }
//        });

    }
    public void gotoChat(View view){
        Snackbar.make(view, "Chat with the Supplier", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
        Intent intent = new Intent(this, ChatAct.class);
        startActivity(intent);
    }

    //needs to check if customer has any orders
    //if (orders = null){
    //  *display original "add orders" page
    //} else {
    //  *display all customers orders with the option to add or minus the items ordered.
    //}

    //*should these be two different activities?

}
