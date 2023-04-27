package com.example.demo.Lab7;

//CLASA CARE DECUPLEAZA DE BAZA DE DATE
//ii o implementare a interfetei care returneaza niste date
public class OperatiiDBMock implements OperatiiDB{

    @Override
    public Utilizator getUtilizator() {
        return new Utilizator("alex",TipRisc.RIDICAT);
    }


}
