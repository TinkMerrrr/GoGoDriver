package com.weeworld.gogodriver.Model;
import java.util.List;
public class Request {
    private String numberPhone, fullnameUser, address, total, status;
    private List<Order> foods;

    public Request() {
    }

    public Request(String numberPhone, String fullnameUser, String address, String total, String status, List<Order> foods) {
        this.numberPhone = numberPhone;
        this.fullnameUser = fullnameUser;
        this.address = address;
        this.total = total;
        this.status = "0";
        this.foods = foods;
    }

    public String getNumberPhone() {
        return numberPhone;
    }

    public void setNumberPhone(String numberPhone) {
        this.numberPhone = numberPhone;
    }

    public String getFullnameUser() {
        return fullnameUser;
    }

    public void setFullnameUser(String fullnameUser) {
        this.fullnameUser = fullnameUser;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Order> getFoods() {
        return foods;
    }

    public void setFoods(List<Order> foods) {
        this.foods = foods;
    }
}

