package com.example.sarah.alkosh.Supplier;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.sarah.alkosh.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEventsLogger;

public class SupplierActivity extends AppCompatActivity {
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference("supplier");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_supplier);

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        setupViewPager(mViewPager);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);


//        Supplier supplier1 = new Supplier("Test1","clothing", 2);
//        Supplier supplier2 = new Supplier("Test2","clothing", 5);
//
//        myRef.push().setValue(supplier1);
//        myRef.push().setValue(supplier2);
    }

//    for the page layout
    private SectionsPageAdapter mSectionsPagerAdapter;
    private ViewPager mViewPager;

    private void setupViewPager(ViewPager viewPager){
        SectionsPageAdapter adapter = new SectionsPageAdapter(getSupportFragmentManager());
        adapter.addFragment(new SupplierPageFragment(), "MY PAGE");
        adapter.addFragment(new SupplierOrderFragment(), "ORDERS");
        viewPager.setAdapter(adapter);
    }
}
