package com.example.sarah.alkosh;

import android.content.Context;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.sarah.alkosh.Data.MyTables;

/**
 * Created by Sarah on 11/23/2017.
 */

public class OrderListAdapter extends RecyclerView.Adapter<OrderListAdapter.CustomerViewHolder> {
    private Context mContext;

    // count of items
    private Cursor mCursor;

    public OrderListAdapter(Context context, Cursor cursor){
        this.mContext=context;
        this.mCursor = cursor;
    }

    @Override
    public CustomerViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        // Get RecyclerView item layout
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View view = inflater.inflate(R.layout.ordersfragment, parent, false);
        return new CustomerViewHolder(view);
    }
    public void onBindViewHolder(CustomerViewHolder holder, int position){
        if(!mCursor.moveToPosition(position))
            return;
        // get name of customer
        String name = mCursor.getString(mCursor.getColumnIndex(MyTables.CustomerOrders.COLUMN_ORDER_DESC));

        // get name of the model
        String model = mCursor.getString(mCursor.getColumnIndex(MyTables.CustomerOrders.COLUMN_SUPPLIER));

        long id = mCursor.getLong(mCursor.getColumnIndex(MyTables.CustomerOrders._ID));
        //show on textview
        holder.nameTextView.setText(name);
        holder.orderImageView.setImageDrawable(Drawable.createFromPath(model));
        holder.itemView.setTag(id);
    }

    public int getItemCount(){
        return mCursor.getCount();
    }

    public void swapCursor(Cursor newCursor) {
        if (mCursor != null) mCursor.close();
        mCursor = newCursor;
        if (newCursor != null){
            this.notifyDataSetChanged();
        }
    }

    /**
     * Inner class to hold the views needed to display a single item in the recycler-view
     */
    class CustomerViewHolder extends RecyclerView.ViewHolder{
        // Customer name
        TextView nameTextView;
        ImageView orderImageView;


        // constructor
        public CustomerViewHolder (View itemView){
            super(itemView);
            nameTextView = (TextView) itemView.findViewById(R.id.orderNameView);
            orderImageView = (ImageView) itemView.findViewById(R.id.orderimageView);
            }
    }
}
