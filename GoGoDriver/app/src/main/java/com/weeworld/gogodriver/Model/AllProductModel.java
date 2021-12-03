package com.weeworld.gogodriver.Model;

import java.io.Serializable;

public class AllProductModel implements Serializable {

    String id;
    String picProduct;
    String nameProduct;
    String desProduct;
    String unitProduct;
    String type;
    int priceProduct;

    public AllProductModel() {
    }

    public AllProductModel(String picProduct, String nameProduct, int priceProduct) {
        this.picProduct = picProduct;
        this.nameProduct = nameProduct;
        this.priceProduct = priceProduct;
    }

    public AllProductModel(String picProduct, String nameProduct, int priceProduct, String desProduct, String unitProduct, String type) {
        this.picProduct = picProduct;
        this.nameProduct = nameProduct;
        this.priceProduct = priceProduct;
        this.desProduct = desProduct;
        this.unitProduct = unitProduct;
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPicProduct() {
        return picProduct;
    }

    public void setPicProduct(String picProduct) {
        this.picProduct = picProduct;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public int getPriceProduct() {
        return priceProduct;
    }

    public void setPriceProduct(int priceProduct) {
        this.priceProduct = priceProduct;
    }

    public String getDesProduct() {
        return desProduct;
    }

    public void setDesProduct(String desProduct) {
        this.desProduct = desProduct;
    }

    public String getUnitProduct() {
        return unitProduct;
    }

    public void setUnitProduct(String unitProduct) {
        this.unitProduct = unitProduct;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
