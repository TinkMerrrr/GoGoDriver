package com.weeworld.gogodriver.Model;

import java.util.Date;

public class MessageUserModel {
    String messageText;
    String messageNameUser;
    long messageTime;

    public MessageUserModel() {
    }

    public MessageUserModel(String messageText, String messageUser) {
        this.messageText = messageText;
        this.messageNameUser = messageUser;
        messageTime = new Date().getTime();
    }

    public String getMessageText() {
        return messageText;
    }

    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }

    public String getMessageNameUser() {
        return messageNameUser;
    }

    public void setMessageNameUser(String messageNameUser) {
        this.messageNameUser = messageNameUser;
    }

    public long getMessageTime() {
        return messageTime;
    }

    public void setMessageTime(long messageTime) {
        this.messageTime = messageTime;
    }
}
