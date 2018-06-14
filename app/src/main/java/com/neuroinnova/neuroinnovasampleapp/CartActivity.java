package com.neuroinnova.neuroinnovasampleapp;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.neuroinnova.neuroinnovasampleapp.adapter.ProductCartAdapter;
import com.neuroinnova.neuroinnovasampleapp.calculator.CartValueCalculator;
import com.neuroinnova.neuroinnovasampleapp.db.CartDb;
import com.neuroinnova.neuroinnovasampleapp.model.ProductCart;

import java.util.ArrayList;

public class CartActivity extends AppCompatActivity implements View.OnClickListener {

    private ListView listView;
    private LinearLayout activity_cart;
    ProductCartAdapter productCartAdapter;
    CartDb cartDb;
    ArrayList<ProductCart> productCartArrayList;
    private TextView cartValue;
    private Button btnPayment;
    private Button btnEmptyCart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);
        initView();

        cartValue.setText("Cart:: " + CartDb.getInstance(this).getCount() + " items for : Sh." + String.valueOf(new CartValueCalculator(this).getCartValue()));

        cartDb = CartDb.getInstance(this);
        productCartArrayList = cartDb.getProductCartsInCart();
        productCartAdapter = new ProductCartAdapter(productCartArrayList, this,cartValue);


        listView.setAdapter(productCartAdapter);

        btnEmptyCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                AlertDialog.Builder builder;
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    builder = new AlertDialog.Builder(CartActivity.this, android.R.style.Theme_Material_Dialog_Alert);
                } else {
                    builder = new AlertDialog.Builder(CartActivity.this);
                }
                builder.setTitle("Empty Cart")
                        .setMessage("Are you sure you want to empty cart?")
                        .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                CartDb.getInstance(CartActivity.this).resetTables();
                                cartValue.setText("Cart:: " + CartDb.getInstance(CartActivity.this).getCount() + " items for : Sh." + String.valueOf(new CartValueCalculator(CartActivity.this).getCartValue()));

                                productCartAdapter.setProductArrayList(cartDb.getProductCartsInCart());
                                productCartAdapter.notifyDataSetChanged();
                            }
                        })
                        .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                // do nothing
                            }
                        })
                        .setIcon(android.R.drawable.ic_dialog_alert)
                        .show();


            }
        });

        btnPayment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(CartActivity.this,PaymentActivity.class));

            }
        });

    }

    private void initView() {
        listView = (ListView) findViewById(R.id.listView);
        activity_cart = (LinearLayout) findViewById(R.id.activity_cart);
        cartValue = (TextView) findViewById(R.id.cartValue);
        btnPayment = (Button) findViewById(R.id.btnPayment);
        btnEmptyCart = (Button) findViewById(R.id.btnEmptyCart);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnPayment:

                break;
            case R.id.btnEmptyCart:

                break;
        }
    }
}
