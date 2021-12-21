package com.yola.uasyola.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class GetRuangan {
    @SerializedName("status")
    String statusruangan;
    @SerializedName("result")
    List<Ruangan> listDataRuangan;
    @SerializedName("message")
    String message;
    public String getStatus() {
        return statusruangan;
    }
    public void setStatusRuangan(String statusruangan) {
        this.statusruangan = statusruangan;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public List<Ruangan> getListDataRuangan() {
        return listDataRuangan;
    }
    public void setListDataRuangan(List<Ruangan> listDataRuangan) {
        this.listDataRuangan = listDataRuangan;
    }
}