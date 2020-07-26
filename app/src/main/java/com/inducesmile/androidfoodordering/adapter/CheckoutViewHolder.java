package com.inducesmile.androidfoodordering.adapter;

import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.inducesmile.androidfoodordering.R;

public class CheckoutViewHolder extends RecyclerView.ViewHolder{

    public TextView checkoutName, checkoutQuantity, checkoutPrice;

    public CheckoutViewHolder(View itemView) {
        super(itemView);
        checkoutName = (TextView)itemView.findViewById(R.id.checkout_name);
        checkoutQuantity = (TextView)itemView.findViewById(R.id.checkout_quantity);
        checkoutPrice = (TextView)itemView.findViewById(R.id.checkout_price);
    }
}
