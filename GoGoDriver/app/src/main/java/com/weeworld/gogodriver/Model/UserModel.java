package com.weeworld.gogodriver.Model;

import com.google.firebase.database.DatabaseReference;

public class UserModel {
    String UserID;
    String picUser;
    String Status;
    String historySearch;
    String FullnameUser;
    String PassUser;
    String PhoneUser;
    String EmailUser;
    String AddressUser;

    public UserModel(){}

    public UserModel(String userID, String picUser, String status, String historySearch, String fullnameUser, String passUser, String phoneUser, String emailUser) {
        this.UserID = userID;
        this.picUser = picUser;
        this.Status = status;
        this.historySearch = historySearch;
        this.FullnameUser = fullnameUser;
        this.PassUser = passUser;
        this.PhoneUser = phoneUser;
        this.EmailUser = emailUser;
    }



    public String getUserID() {
        return UserID;
    }

    public void setUserID(String userID) {
        UserID = userID;
    }

    public String getPicUser() {
        return picUser;
    }

    public void setPicUser(String picUser) {
        this.picUser = picUser;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public String getHistorySearch() {
        return historySearch;
    }

    public void setHistorySearch(String historySearch) {
        this.historySearch = historySearch;
    }

    public String getFullnameUser() {
        return FullnameUser;
    }

    public void setFullnameUser(String fullnameUser) {
        FullnameUser = fullnameUser;
    }

    public String getPassUser() {
        return PassUser;
    }

    public void setPassUser(String passUser) {
        PassUser = passUser;
    }

    public String getPhoneUser() {
        return PhoneUser;
    }

    public void setPhoneUser(String phoneUser) {
        PhoneUser = phoneUser;
    }

    public String getEmailUser() {
        return EmailUser;
    }

    public void setEmailUser(String emailUser) {
        EmailUser = emailUser;
    }

    public String getAddressUser() {
        return AddressUser;
    }

    public void setAddressUser(String AddressUser) {
        this.AddressUser = AddressUser;
    }
}
