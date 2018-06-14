package com.neuroinnova.neuroinnovasampleapp.calculator;

import android.content.Context;

import com.neuroinnova.neuroinnovasampleapp.db.CartDb;
import com.neuroinnova.neuroinnovasampleapp.model.Product;
import com.neuroinnova.neuroinnovasampleapp.model.ProductCart;

import java.util.ArrayList;

/**
 * Created by george on 6/14/18.
 */

public class CartValueCalculator {

    Context context;
    CartDb cartDb=CartDb.getInstance(context);;
    public CartValueCalculator(Context context)
    {
        this.context=context;
        cartDb=CartDb.getInstance(context);

    }

    public int getCartValue()
    {
        ArrayList<ProductCart> productArrayList=cartDb.getProductCartsInCart();
        int sum= 0;
        for (int i= 0;i<productArrayList.size();i++)
        {
            sum=sum+(productArrayList.get(i).getPrice()* productArrayList.get(i).getQuantity());
        }

        return sum;


    }
}
