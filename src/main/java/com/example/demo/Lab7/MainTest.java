package com.example.demo.Lab7;

public class MainTest {
    public static void main(String[] args)
    {
        //la parametru ii interfata
        //trimit ca parametru o clasa care implementeaza interfata
        CalculDobanda calculDobanda=new CalculDobanda(new OperatiiDBMock());

        System.out.println(calculDobanda.calculDobandaUtilizator());

    }
}
