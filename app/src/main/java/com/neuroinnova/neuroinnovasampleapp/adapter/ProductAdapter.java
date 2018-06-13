package com.neuroinnova.neuroinnovasampleapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.neuroinnova.neuroinnovasampleapp.R;
import com.neuroinnova.neuroinnovasampleapp.model.Product;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by george on 6/13/18.
 */

public class ProductAdapter extends BaseAdapter {

    ArrayList<Product> productArrayList;
    Context context;


    public ProductAdapter(ArrayList<Product> productArrayList1, Context context1) {
        this.productArrayList = productArrayList1;
        this.context = context1;

    }

    @Override
    public int getCount() {
        return productArrayList.size();
    }

    @Override
    public Product getItem(int position) {
        return productArrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return productArrayList.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        //get current Product

        final Product product = productArrayList.get(position);

        //Inflate layout

        if (convertView == null) {
            final LayoutInflater layoutInflater = LayoutInflater.from(context);
            convertView = layoutInflater.inflate(R.layout.item_shop, null);
        }

        ViewHolder viewHolder=new ViewHolder(convertView);
        Picasso.get()
                .load(product.getImageUrl())
                .placeholder(R.drawable.placeholder)
                .error(R.drawable.placeholder_error)
                .into(viewHolder.imgItemPic);
        viewHolder.txtCategory.setText(product.getCategory().getName());
        viewHolder.txtDiscount.setText(product.getDiscount());
        viewHolder.txtProductName.setText(product.getName());
        viewHolder.txtProductPrice.setText(product.getPrice());
        viewHolder.btnAddToCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, product.getName(), Toast.LENGTH_SHORT).show();
            }
        });


        return convertView;
    }

    public static class ViewHolder {
        public View rootView;
        public ImageView imgItemPic;
        public TextView txtCategory;
        public TextView textViewUnderline;
        public TextView txtProductName;
        public TextView txtProductPrice;
        public TextView txtDiscount;
        public Button btnAddToCart;

        public ViewHolder(View rootView) {
            this.rootView = rootView;
            this.imgItemPic = (ImageView) rootView.findViewById(R.id.imgItemPic);
            this.txtCategory = (TextView) rootView.findViewById(R.id.txtCategory);
            this.textViewUnderline = (TextView) rootView.findViewById(R.id.textViewUnderline);
            this.txtProductName = (TextView) rootView.findViewById(R.id.txtProductName);
            this.txtProductPrice = (TextView) rootView.findViewById(R.id.txtProductPrice);
            this.txtDiscount = (TextView) rootView.findViewById(R.id.txtDiscount);
            this.btnAddToCart = (Button) rootView.findViewById(R.id.btnAddToCart);
        }

    }
}
