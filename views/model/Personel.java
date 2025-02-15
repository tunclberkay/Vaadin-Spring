package com.example.application.views.model;

public class Personel {
    private String ad;
    private String soyad;
    private String tc;

    public Personel(String ad, String soyad, String tc) {
        this.ad = ad;
        this.soyad = soyad;
        this.tc = tc;
    }

    public String getAd() { return ad; }  
    public String getSoyad() { return soyad; }  
    public String getTC() { return tc; }  
}
