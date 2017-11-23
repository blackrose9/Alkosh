package com.example.sarah.alkosh.Customer;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.sarah.alkosh.R;
import com.example.sarah.alkosh.Customer.OrderAct;

/**
 * Created by sarah on 11/6/2017.
 */

public class OrdersFragment extends Fragment {
    private static final String TAG = "Your Orders";

    private ImageButton addbtn;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.ordersfragment,container,false);
        addbtn = (ImageButton) view.findViewById(R.id.orderbtn);
        addbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(), "You said: BUY!", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getActivity(), OrderAct.class);
                startActivity(intent);
            }
        });

        return view;
    }

//    public void order(View view){
//        Intent intent = new Intent(getActivity(), OrderAct.class);
//        startActivity(intent);
//    }
}
