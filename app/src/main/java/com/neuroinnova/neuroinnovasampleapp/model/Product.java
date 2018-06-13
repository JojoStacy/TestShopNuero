package com.neuroinnova.neuroinnovasampleapp.model;

/**
 * Created by george on 6/13/18.
 */

public class Product {


    public Product(long id,String imageUrl,int price,int discount, String name,Model model,String barcode,Category category,Manufacturer manufacturer)
    {
        this.id=id;
        this.imageUrl=imageUrl;
        this.price=price;
        this.discount=discount;
        this.name=name;
        this.model=model;
        this.barcode=barcode;
        this.category=category;
        this.manufacturer=manufacturer;
    }


    long id;
    String imageUrl;
    int price;
    int discount;
    String name;
    Model model;
    String barcode;
    Category category;
    Manufacturer manufacturer;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public Manufacturer getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(Manufacturer manufacturer) {
        this.manufacturer = manufacturer;
    }

    public Model getModel() {
        return model;
    }

    public void setModel(Model model) {
        this.model = model;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }




}
