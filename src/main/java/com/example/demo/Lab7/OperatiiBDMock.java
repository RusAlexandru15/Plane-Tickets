package com.example.demo.Lab7;

//CLASA CARE DECUPLEAZA DE BAZA DE DATE

public class OperatiiBDMock implements OperatiiDB{

    @Override
    public Utilizator getUtilizator() {
        return new Utilizator("alex",TipRisc.RIDICAT);
    }
}
