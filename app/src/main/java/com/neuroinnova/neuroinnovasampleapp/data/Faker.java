package com.neuroinnova.neuroinnovasampleapp.data;

import com.neuroinnova.neuroinnovasampleapp.model.Category;
import com.neuroinnova.neuroinnovasampleapp.model.Manufacturer;
import com.neuroinnova.neuroinnovasampleapp.model.Model;
import com.neuroinnova.neuroinnovasampleapp.model.Product;

import java.util.ArrayList;

/**
 * Created by george on 6/13/18.
 */

public class Faker {

    public ArrayList<Product> getFakeProducts()
    {
        ArrayList<Product> productArrayList=new ArrayList<>();



        productArrayList.add(new Product(1,"https://image.ibb.co/dLs5Cy/1.jpg",300,10, "Supra Shoes",getFakeModel(),"832883832832",getFakeCategory(),getFakeManufacturer()));

        productArrayList.add(new Product(2,"https://image.ibb.co/ktcu5J/2.jpg",400,10, "Dress Shoes",getFakeModel(),"832883832832",getFakeCategory(),getFakeManufacturer()));

        productArrayList.add(new Product(3,"https://image.ibb.co/bRfE5J/3.jpg",500,10, "Omo",getFakeModel(),"832883832832",getFakeCategory(),getFakeManufacturer()));

        productArrayList.add(new Product(4,"https://image.ibb.co/hMOqed/4.jpg",350,10, "Bata shoes",getFakeModel(),"832883832832",getFakeCategory(),getFakeManufacturer()));

        productArrayList.add(new Product(5,"https://image.ibb.co/jRbXsy/5.jpg",30,10, "Sweet Chocolate",getFakeModel(),"832883832832",getFakeCategory(),getFakeManufacturer()));
        productArrayList.add(new Product(6,"https://image.ibb.co/f425Cy/6.jpg",3000,10, "Italian Tie",getFakeModel(),"832883832832",getFakeCategory(),getFakeManufacturer()));

        productArrayList.add(new Product(7,"https://image.ibb.co/giOCsy/7.jpg",400,10, "Drake Earphones",getFakeModel(),"832883832832",getFakeCategory(),getFakeManufacturer()));

        productArrayList.add(new Product(8,"https://image.ibb.co/eBZwKd/8.jpg",350,10, "Supra Shoes",getFakeModel(),"832883832832",getFakeCategory(),getFakeManufacturer()));

        productArrayList.add(new Product(9,"https://image.ibb.co/jDGnQJ/9.jpg",30,10, "Cool Dress",getFakeModel(),"832883832832",getFakeCategory(),getFakeManufacturer()));

        productArrayList.add(new Product(10,"https://image.ibb.co/m1NNsy/10.jpg",3300,10, "Tatia Dress",getFakeModel(),"832883832832",getFakeCategory(),getFakeManufacturer()));

        productArrayList.add(new Product(11,"https://image.ibb.co/mJMtzd/11.jpg",3001,10, "Namibian Watch",getFakeModel(),"832883832832",getFakeCategory(),getFakeManufacturer()));

        productArrayList.add(new Product(12,"https://image.ibb.co/kYpP5J/12.jpg",54,10, "Scarf",getFakeModel(),"832883832832",getFakeCategory(),getFakeManufacturer()));

        productArrayList.add(new Product(13,"https://image.ibb.co/bAKP5J/13.jpg",360,10, "Snoop Snickers",getFakeModel(),"832883832832",getFakeCategory(),getFakeManufacturer()));

        productArrayList.add(new Product(14,"https://image.ibb.co/eGHoXy/14.jpg",3890,10, "Ricoh Shoes",getFakeModel(),"832883832832",getFakeCategory(),getFakeManufacturer()));

        productArrayList.add(new Product(15,"https://image.ibb.co/kSQLed/15.jpg",30,10, "Leather Shoes",getFakeModel(),"832883832832",getFakeCategory(),getFakeManufacturer()));

        productArrayList.add(new Product(16,"https://image.ibb.co/gy8vCy/16.jpg",2300,10, "Velcex gloves",getFakeModel(),"832883832832",getFakeCategory(),getFakeManufacturer()));

        productArrayList.add(new Product(17,"https://image.ibb.co/evSoXy/17.jpg",1200,10, "Fish Hook",getFakeModel(),"832883832832",getFakeCategory(),getFakeManufacturer()));

        productArrayList.add(new Product(18,"https://image.ibb.co/cAprkJ/18.jpg",100,10, "Calvin Klein Bag",getFakeModel(),"832883832832",getFakeCategory(),getFakeManufacturer()));

        productArrayList.add(new Product(19,"https://image.ibb.co/nwKfed/25.jpg",900,10, "Cool Socks",getFakeModel(),"832883832832",getFakeCategory(),getFakeManufacturer()));

        productArrayList.add(new Product(20,"https://image.ibb.co/fy645J/32.jpg",400,10, "Kanon Camera",getFakeModel(),"832883832832",getFakeCategory(),getFakeManufacturer()));

        return  productArrayList;
    }

    private Manufacturer getFakeManufacturer()
    {
        Manufacturer manufacturer=new Manufacturer();

        manufacturer.setName("Yunilever");

        return  manufacturer;

    }

    private Model getFakeModel()
    {
        Model model= new Model();
        model.setName("Cool Teen");
        return model;

    }

    private Category getFakeCategory()
    {
        Category category= new Category();

        category.setName("Product Hot Category");
        category.setDescription("This is a sample category");

        return category;
    }
}
