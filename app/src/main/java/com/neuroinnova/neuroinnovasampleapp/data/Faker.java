package com.neuroinnova.neuroinnovasampleapp.data;

import com.neuroinnova.neuroinnovasampleapp.model.Manufacturer;
import com.neuroinnova.neuroinnovasampleapp.model.Product;

import java.util.ArrayList;

/**
 * Created by george on 6/13/18.
 */

public class Faker {

    public ArrayList<Product> getFakeProducts()
    {
        ArrayList<Product> productArrayList=new ArrayList<>();

        productArrayList.add(new Product());

        return  productArrayList;
    }

    private Manufacturer getFakeManufacturer()
    {
        Manufacturer manufacturer=new Manufacturer();

        manufacturer.setName("Yunilever");

        return  manufacturer;

    }
}
