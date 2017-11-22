package com.example.sarah.alkosh.Customer;

//import android.app.Fragment;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.sarah.alkosh.R;
import com.google.firebase.auth.FirebaseAuth;

/**
 * Created by sarah on 11/6/2017.
 */

public class HomeFragment extends Fragment {
    private static final String TAG = "Home";

    private Button homeBtn;
    private Button btnLogOut;
    private FirebaseAuth mFirebaseAuth;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.homefragment,container,false);


        initViews(view);


        btnLogOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mFirebaseAuth.signOut();
            }
        });

        return view;


    }


    private void initViews(View view) {
        btnLogOut=(Button)view.findViewById(R.id.logoutbtn);
        mFirebaseAuth = FirebaseAuth.getInstance();
    }
}
