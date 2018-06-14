package com.neuroinnova.neuroinnovasampleapp.model;

/**
 * Created by george on 6/14/18.
 */

public class ProductCart extends Product {

    int quantity;
    String dbId;

    public String getDbId() {
        return dbId;
    }

    public void setDbId(String dbId) {
        this.dbId = dbId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
