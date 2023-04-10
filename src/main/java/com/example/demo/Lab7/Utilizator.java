package com.example.demo.Lab7;

public class Utilizator {
    private String name;
    private TipRisc profilRisc; //3 tipuri

    public Utilizator(String name, TipRisc profilRisc) {
        this.name = name;
        this.profilRisc = profilRisc;
    }

    public String getName() {
        return name;
    }

    public TipRisc getProfilRisc() {
        return profilRisc;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setProfilRisc(TipRisc profilRisc) {
        this.profilRisc = profilRisc;
    }
}
