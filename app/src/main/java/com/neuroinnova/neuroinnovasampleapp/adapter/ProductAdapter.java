package com.neuroinnova.neuroinnovasampleapp.adapter;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.neuroinnova.neuroinnovasampleapp.R;
import com.neuroinnova.neuroinnovasampleapp.calculator.CartValueCalculator;
import com.neuroinnova.neuroinnovasampleapp.db.CartDb;
import com.neuroinnova.neuroinnovasampleapp.model.Product;
import com.neuroinnova.neuroinnovasampleapp.model.ProductCart;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by george on 6/13/18.
 */

public class ProductAdapter extends BaseAdapter {

    ArrayList<Product> productArrayList;
    Context context;
    CartDb cartDb;
    TextView textview;
    CartValueCalculator cartValueCalculator;



    public ProductAdapter(ArrayList<Product> productArrayList1, Context context1,TextView textView) {
        this.productArrayList = productArrayList1;
        this.context = context1;
        this.textview=textView;
        cartDb=CartDb.getInstance(context1);
        cartValueCalculator=new CartValueCalculator(context1);

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
       // viewHolder.txtDiscount.setText(product.getDiscount());
        viewHolder.txtProductName.setText(product.getName());
//        viewHolder.txtProductPrice.setText(product.getPrice());
        viewHolder.btnAddToCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {






      addToCart(context,product);



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


    public void addToCart(final Context mContext, final Product product)
    {
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(mContext);
        LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);;
        final View dialogView = inflater.inflate(R.layout.layout_alert_dialog, null);
        dialogBuilder.setView(dialogView);

        final EditText edt = (EditText) dialogView.findViewById(R.id.edit1);

        dialogBuilder.setTitle("Quantity");
        dialogBuilder.setMessage("Enter  below");
        dialogBuilder.setPositiveButton("Done", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
                
                if(edt.getText().toString().isEmpty())
                {
                    Toast.makeText(mContext, "You must set quantity to add item to cart", Toast.LENGTH_SHORT).show();
                    return;
                }

                ProductCart productCart=new Gson().fromJson(new Gson().toJson(product),ProductCart.class);
                productCart.setQuantity(Integer.parseInt(edt.getText().toString()));

                cartDb.add(productCart);

                Toast.makeText(mContext, product.getName()+ " added to cart", Toast.LENGTH_SHORT).show();

                textview.setText(cartDb.getCount()+" items for : Sh."+String.valueOf(cartValueCalculator.getCartValue()));
               
            }
        });
        dialogBuilder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
                //pass
            }
        });
        AlertDialog b = dialogBuilder.create();
        b.show();
    }
}
