package com.example.sarah.alkosh;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.sarah.alkosh.Customer.CustomerActivity;
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
    }
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
        public void gotoCustomer(View view){
            Intent intent = new Intent(this, CustomerActivity.class);
            startActivity(intent);
        }
        public void gotoSupplier(View view){
            Intent intent = new Intent(this, SupplierActivity.class);
            startActivity(intent);
        }
}

