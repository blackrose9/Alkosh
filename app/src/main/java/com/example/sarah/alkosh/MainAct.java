package com.example.sarah.alkosh;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.support.annotation.NonNull;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.sarah.alkosh.Customer.CustomerActivity;
import com.example.sarah.alkosh.Data.DbHelper;
import com.example.sarah.alkosh.Data.MyTables;
import com.example.sarah.alkosh.Supplier.SupplierActivity;
import com.example.sarah.alkosh.Customer.HomeFragment;
import com.example.sarah.alkosh.Customer.OrdersFragment;
import com.firebase.ui.auth.AuthUI;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Arrays;


public class MainAct extends AppCompatActivity {
    private static final String TAG = "MainAct";

    public static final int RC_SIGN_IN = 1;

    //    Firebase variables
    private FirebaseDatabase mFirebaseDatabase;
    private DatabaseReference mMessagesDatabaseReference;
    private ChildEventListener mChildEventListener;
    private FirebaseAuth mFirebaseAuth;
    private FirebaseAuth.AuthStateListener mAuthStateListener;

    private Button btnLogOut;

    private String mUsername;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "onCreate: Starting");

//        Login methods here ....

//        Firebase components initialization
//        mFirebaseDatabase = FirebaseDatabase.getInstance();
//        mFirebaseAuth = FirebaseAuth.getInstance();
//
//        mMessagesDatabaseReference = mFirebaseDatabase.getReference().child("messages");
//
//        mAuthStateListener = new FirebaseAuth.AuthStateListener() {
//            @Override
//            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
//                FirebaseUser user = firebaseAuth.getCurrentUser();
//                if (user != null){
//                    //user is signed in
//                    Toast.makeText(MainAct.this, "You are now signed in. Welcome!", Toast.LENGTH_SHORT).show();
//                    onSignedInInitialize(user.getDisplayName());
//                } else {
//                    //user is signed out
//
//                    startActivityForResult(
//                            AuthUI.getInstance()
//                                    .createSignInIntentBuilder()
//                                    .setIsSmartLockEnabled(false)
//                                    .setAvailableProviders(
//                                            Arrays.asList(new AuthUI.IdpConfig.Builder(AuthUI.EMAIL_PROVIDER).build(),
//                                                    new AuthUI.IdpConfig.Builder(AuthUI.GOOGLE_PROVIDER).build()))
//                                    .build(),
//                            RC_SIGN_IN);
//                }
//            }
//        };
//    }
//
//
//    @Override
//    protected void onPause(){
//        super.onPause();
//        //if (mAuthStateListener != null) {
//            mFirebaseAuth.removeAuthStateListener(mAuthStateListener);
////            mFirebaseAuth.signOut();
//        //}
//        //mSectionsPagerAdapter.clear()
//    }
//    @Override
//    protected void onResume(){
//        super.onResume();
//        mFirebaseAuth.addAuthStateListener(mAuthStateListener);
//    }
//
//    private void onSignedInInitialize(String username){
//        mUsername = username;
//    }

//!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! //
//        SQLite methods here ...
        RecyclerView waitlistRecyclerView;
        // Set local attributes to corresponding views
        waitlistRecyclerView = (RecyclerView) this.findViewById(R.id.all_guests_list_view);
        mNewCustomerEditText = (EditText) this.findViewById(R.id.person_name_edit_text);
        mModelNameEditText = (EditText) this.findViewById(R.id.model_name_edit_text);

        // Set layout for the RecyclerView, because it's a list we are using the linear layout
        waitlistRecyclerView.setLayoutManager(new LinearLayoutManager(this));


        // Create data.WaitlistDbHelper instance
        DbHelper dbHelper = new DbHelper(this);
        mDB = dbHelper.getWritableDatabase();
        // Get all guest info from the database and save in a cursor
        Cursor cursor = getAllCustomers();
        // Create an adapter for that cursor to display the data
        mAdapter = new OrderListAdapter(this, cursor);

        waitlistRecyclerView.setAdapter(mAdapter);
        // item touch helper for delete actions
        new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT){
            // override on move
            @Override
            public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target){
                return false;
            }
            @Override
            public void onSwiped(RecyclerView.ViewHolder viewHolder, int swipeDir){
                // ID of the item being swiped
                long id = (long) viewHolder.itemView.getTag();
                // remove from DB
                removeCustomer(id);
                // refresh list
                mAdapter.swapCursor(getAllCustomers());




            }
        }).attachToRecyclerView(waitlistRecyclerView);


    }//end of onCreate

        public void gotoCustomer(View view){
            Intent intent = new Intent(this, CustomerActivity.class);
            startActivity(intent);
        }
        public void gotoSupplier(View view){
            Intent intent = new Intent(this, SupplierActivity.class);
            startActivity(intent);
        }


//    ............................................................. //
//    SQLite DataBase and it's components  here //
//Add to waitlist
    public void addToOrderList(View view){
    // if edit texts are empty, do nothing
    if(mNewCustomerEditText.getText().length() == 0 || mModelNameEditText.getText().length() == 0){
        return;
    }

    addNewCustomer(mNewCustomerEditText.getText().toString(), mModelNameEditText.getText().toString());
    mAdapter.swapCursor(getAllCustomers());

    mNewCustomerEditText.getText().clear();
    mModelNameEditText.getText().clear();


}
    // add new customer method
    public long addNewCustomer(String name, String model){
        ContentValues cv = new ContentValues();
        cv.put(MyTables.CustomerOrders.COLUMN_ORDER_DESC, name);
        cv.put(MyTables.CustomerOrders.COLUMN_ORDER_ITEMS, model);
        return mDB.insert(MyTables.CustomerOrders.TABLE_NAME, null, cv);
    }

    // private method that returns all customers
    private Cursor getAllCustomers(){
        return mDB.query(
                MyTables.CustomerOrders.TABLE_NAME,
                null,
                null,
                null,
                null,
                null,
                MyTables.CustomerOrders.COLUMN_SUPPLIER
        );
    }

    public boolean removeCustomer(long id){
        return mDB.delete(MyTables.CustomerOrders.TABLE_NAME,MyTables.CustomerOrders._ID + "=" +id, null) > 0;

    }

}

