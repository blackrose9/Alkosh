package com.example.sarah.alkosh.Supplier;

import android.widget.ImageView;

/**
 * Created by sarah on 11/14/2017.
 */

public class Supplier {
    String fullName;
    String specialize;
    int rating;

    public Supplier() {
    }

    public Supplier(String fullName, String specialize, int rating) {
        this.fullName = fullName;
        this.specialize = specialize;
        this.rating = rating;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getSpecialize() {
        return specialize;
    }

    public void setSpecialize(String specialize) {
        this.specialize = specialize;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    //products declaration
    public String title;
    public ImageView productImage;
    public String description;
    public double price;
    public boolean selected;

    public Product(String title, ImageView productImage, String description,

                   double price) {

        this.title = title;

        this.productImage = productImage;

        this.description = description;

        this.price = price;
}
