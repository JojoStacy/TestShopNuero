package com.neuroinnova.neuroinnovasampleapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.neuroinnova.neuroinnovasampleapp.adapter.ProductAdapter;
import com.neuroinnova.neuroinnovasampleapp.calculator.CartValueCalculator;
import com.neuroinnova.neuroinnovasampleapp.data.Faker;
import com.neuroinnova.neuroinnovasampleapp.db.CartDb;

public class MainActivity extends AppCompatActivity {

    private GridView gridview;
    private LinearLayout activity_main;
    Faker faker;
    private TextView cartValue;
    private EditText editSearch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();


        cartValue.setText("Cart:: "+CartDb.getInstance(this).getCount()+" items for : Sh."+String.valueOf(new CartValueCalculator(this).getCartValue()));

        faker = new Faker();
        ProductAdapter productAdapter = new ProductAdapter(faker.getFakeProducts(), MainActivity.this,cartValue);
        gridview.setAdapter(productAdapter);

        cartValue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,CartActivity.class));
            }
        });
        editSearch.setVisibility(View.GONE);


    }

    @Override
    protected void onResume() {
        super.onResume();

        cartValue.setText("Cart:: "+CartDb.getInstance(this).getCount()+" items for : Sh."+String.valueOf(new CartValueCalculator(this).getCartValue()));

        ProductAdapter productAdapter = new ProductAdapter(faker.getFakeProducts(), MainActivity.this,cartValue);
        gridview.setAdapter(productAdapter);
    }


    private void initView() {
        gridview = (GridView) findViewById(R.id.gridview);
        activity_main = (LinearLayout) findViewById(R.id.activity_main);
        cartValue = (TextView) findViewById(R.id.cartValue);
        editSearch = (EditText) findViewById(R.id.editSearch);
    }


}
