package com.example.demo.Lab7;



public class CalculDobanda {

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

}
