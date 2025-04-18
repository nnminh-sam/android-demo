package nnminh.android.nguyennhatminhn21dccn053;

public class Product {
    String imageUrl;

    String name;

    String cookTime;

    String price;

    String productType;

    int orderQuantity;

    public Product(String imageUrl, String name, String cookTime, String price, String productType, int orderQuantity) {
        this.imageUrl = imageUrl;
        this.name = name;
        this.cookTime = cookTime;
        this.price = price;
        this.productType = productType;
        this.orderQuantity = orderQuantity;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCookTime() {
        return cookTime;
    }

    public void setCookTime(String cookTime) {
        this.cookTime = cookTime;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public int getOrderQuantity() {
        return orderQuantity;
    }

    public void setOrderQuantity(int orderQuantity) {
        this.orderQuantity = orderQuantity;
    }
}
