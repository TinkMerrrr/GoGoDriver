package com.weeworld.gogodriver.Model;

import java.util.List;

public class ListOrderModel {
    String fullnameUser;
    String address;
    String numberPhone;
    String status;
    List<CartModel> cart;

    public ListOrderModel() {
    }

    public ListOrderModel(String fullnameUser, String numberPhone, String address, List<CartModel> cart) {
        this.fullnameUser = fullnameUser;
        this.address = address;
        this.numberPhone = numberPhone;
        this.status = "0";
        this.cart = cart;
    }


    public String getFullnameUser() {
        return fullnameUser;
    }

    public void setFullnameUser(String fullnameUser) {
        this.fullnameUser = fullnameUser;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNumberPhone() {
        return numberPhone;
    }

    public void setNumberPhone(String numberPhone) {
        this.numberPhone = numberPhone;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<CartModel> getCartModelList() {
        return cart;
    }

    public void setCartModelList(List<CartModel> cartModelList) {
        this.cart = cartModelList;
    }
}
