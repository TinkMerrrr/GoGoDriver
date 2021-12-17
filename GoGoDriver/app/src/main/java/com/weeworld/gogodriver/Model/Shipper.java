package com.weeworld.gogodriver.Model;

public class Shipper {
    private String numberPhone, fullnameUser,password;

    public Shipper() {
    }

    public Shipper(String numberPhone, String fullnameUser, String password) {
        this.numberPhone = numberPhone;
        this.fullnameUser = fullnameUser;
        this.password = password;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
