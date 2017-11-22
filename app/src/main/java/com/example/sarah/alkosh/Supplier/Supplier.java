package com.example.sarah.alkosh.Supplier;

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
}
