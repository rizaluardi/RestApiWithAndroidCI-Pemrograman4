package com.yola.uasyola.model;

public class Jurusan {
    private int id;
    private String jurusan;
    private String jenjang;

    public Jurusan() {
    }

    public Jurusan(String jurusan, String jenjang) {
        this.jurusan = jurusan;
        this.jenjang = jenjang;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getJurusan() {
        return jurusan;
    }

    public void setJurusan(String obat) {
        this.jurusan = jurusan;
    }

    public String getJenjang() {
        return jenjang;
    }

    public void setJenjang(String jenjang) {
        this.jenjang = jenjang;
    }
}