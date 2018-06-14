/**
 * Created by george on 6/14/18.
 */


package com.neuroinnova.neuroinnovasampleapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.neuroinnova.neuroinnovasampleapp.R;
import com.neuroinnova.neuroinnovasampleapp.calculator.CartValueCalculator;
import com.neuroinnova.neuroinnovasampleapp.db.CartDb;
import com.neuroinnova.neuroinnovasampleapp.model.ProductCart;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;


public class ProductCartAdapter extends BaseAdapter {

    public ArrayList<ProductCart> getProductArrayList() {
        return productArrayList;
    }

    public void setProductArrayList(ArrayList<ProductCart> productArrayList) {
        this.productArrayList = productArrayList;
    }

    ArrayList<ProductCart> productArrayList;
    Context context;
    TextView textView;


    public ProductCartAdapter(ArrayList<ProductCart> productArrayList1, Context context1,TextView textView) {
        this.productArrayList = productArrayList1;
        this.context = context1;
        this.textView=textView;

    }


    @Override
    public int getCount() {
        return productArrayList.size();
    }

    @Override
    public ProductCart getItem(int position) {
        return productArrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return productArrayList.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        //get current ProductCart

        final ProductCart product = productArrayList.get(position);

        //Inflate layout

        if (convertView == null) {
            final LayoutInflater layoutInflater = LayoutInflater.from(context);
            convertView = layoutInflater.inflate(R.layout.item_shopping_cart, null);
        }

        ViewHolder viewHolder = new ViewHolder(convertView);
        Picasso.get()
                .load(product.getImageUrl())
                .placeholder(R.drawable.placeholder)
                .error(R.drawable.placeholder_error)
                .into(viewHolder.imageView);
        viewHolder.txtPrice.setText(String.valueOf(product.getPrice()));
        // viewHolder.txtDiscount.setText(product.getDiscount());
        viewHolder.txtProductName.setText(product.getName());
//        viewHolder.txtProductPrice.setText(product.getPrice());
        viewHolder.deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                CartDb cartDb=CartDb.getInstance(context);

                cartDb.deleteFromCart(product.getDbId());

                setProductArrayList(cartDb.getProductCartsInCart());

              notifyDataSetChanged();




                textView.setText("Cart:: " + CartDb.getInstance(context).getCount() + " items for : Sh." + String.valueOf(new CartValueCalculator(context).getCartValue()));








            }
        });


        return convertView;
    }

    public static class ViewHolder {
        public View rootView;
        public ImageView imageView;
        public TextView txtProductName;
        public TextView txtPrice;
        public Button deleteButton;

        public ViewHolder(View rootView) {
            this.rootView = rootView;
            this.imageView = (ImageView) rootView.findViewById(R.id.imageView);
            this.txtProductName = (TextView) rootView.findViewById(R.id.txtProductName);
            this.txtPrice = (TextView) rootView.findViewById(R.id.txtPrice);
            this.deleteButton = (Button) rootView.findViewById(R.id.deleteButton);
        }

    }
}
