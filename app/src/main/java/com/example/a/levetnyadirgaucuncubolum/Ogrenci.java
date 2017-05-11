package com.example.a.levetnyadirgaucuncubolum;

/**
 * Created by a on 11.05.2017.
 */

public class Ogrenci {
    String adSoyad;
    String eMail;
    String adres;

    public Ogrenci() {
    }

    public Ogrenci(String adSoyad, String eMail, String adres) {
        this.adSoyad = adSoyad;
        this.eMail = eMail;
        this.adres = adres;
    }

    public String getAdSoyad() {
        return adSoyad;
    }

    public void setAdSoyad(String adSoyad) {
        this.adSoyad = adSoyad;
    }

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    public String getAdres() {
        return adres;
    }

    public void setAdres(String adres) {
        this.adres = adres;
    }
}
