package com.example.demo.Lab7;

public class CalculDobanda {

    //atribut de tipul interfetei
    private OperatiiDB operatiiDB;

    //constructor defaultt
    //trebe scris daca vreau sa l folosesc
    public CalculDobanda() {}

    public CalculDobanda(OperatiiDB operatiiDB){
        this.operatiiDB=operatiiDB;
    }


    public float calcul(TipDobanda dobanda){
        return switch (dobanda) {
            case MICA -> 0.2F;
            case MEDIE -> 0.5F;
            case MARE->0.7F;
        };
    }

    public float calculDobandaUtilizator(Utilizator user){
        return switch (user.getProfilRisc()) {
            case SCAZUT ->this.calcul(TipDobanda.MICA);
            case MEDIU -> this.calcul(TipDobanda.MEDIE);
            case RIDICAT->this.calcul(TipDobanda.MARE);
        };
    }

    //in metoda asta folosesc interfata ca sa generez user
    public float calculDobandaUtilizator(){
        Utilizator user=this.operatiiDB.getUtilizator();

        //folosesc metoda de mai sus
        return calculDobandaUtilizator(user);
    }

}
