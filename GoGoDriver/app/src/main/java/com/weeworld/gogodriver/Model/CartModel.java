package com.weeworld.gogodriver.Model;

public class CartModel {
    String id;
    String productImg;
    String productName;
    String totalQuantity;
    int productPrice;
    int totalPrice;

    public CartModel() {
    }

    public CartModel(String id, String productImg, String productName, String totalQuantity, int productPrice, int totalPrice) {
        this.id = id;
        this.productImg = productImg;
        this.productName = productName;
        this.totalQuantity = totalQuantity;
        this.productPrice = productPrice;
        this.totalPrice = totalPrice;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProductImg() {
        return productImg;
    }

    public void setProductImg(String productImg) {
        this.productImg = productImg;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getTotalQuantity() {
        return totalQuantity;
    }

    public void setTotalQuantity(String totalQuantity) {
        this.totalQuantity = totalQuantity;
    }

    public int getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(int productPrice) {
        this.productPrice = productPrice;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }

}
