package nnminh.playground.gridviewadvance;

import android.widget.ImageView;

import java.io.Serializable;

public class Item implements Serializable {
    private String name;
    private Double price;
    private int imageResId;
    private String discount;

    public Item(String name, Double price, int imageResId, String discount) {
        this.name = name;
        this.price = price;
        this.imageResId = imageResId;
        this.discount = discount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public int getImageResId() {
        return imageResId;
    }

    public void setImage(int imageResId) {
        this.imageResId = imageResId;
    }

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }
}
