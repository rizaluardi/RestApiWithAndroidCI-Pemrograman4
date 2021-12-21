package com.yola.uasyola.model;

import com.google.gson.annotations.SerializedName;

public class PostPutDelRuangan {
    @SerializedName("status")
    String statusruangan;
    @SerializedName("result")
    Ruangan mRuangan;
    @SerializedName("message")
    String messageruangan;
    public String getStatusRuangan() {
        return statusruangan;
    }
    public void setStatusRuangan(String statusruangan) {
        this.statusruangan = statusruangan;
    }
    public String getMessageRuangan() {
        return messageruangan;
    }
    public void setMessageRuangan(String messageruangan) {
        this.messageruangan = messageruangan;
    }
    public Ruangan getRuangan() {
        return mRuangan;
    }
    public void setRuangan(Ruangan Ruangan) {
        mRuangan = Ruangan;
    }
}
