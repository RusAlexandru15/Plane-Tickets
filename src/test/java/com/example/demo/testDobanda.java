package com.example.demo;

import com.example.demo.Lab7.*;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

@SpringBootTest
public class testDobanda {

    //interfata -contractul cu db
    @Mock
    OperatiiDB operatiiDB;

    CalculDobanda calculDobanda = new CalculDobanda();

    @Test
    public void testDobandaMica(){
        float expectedResult=0.2f;
        float actualResult= calculDobanda.calcul(TipDobanda.MICA);
        assertTrue(expectedResult==actualResult);
    }


    @Test
    public void testUtilizatorDobanda()
    {
        //ma folosesc de mock
        //daca nu am IMPLEMENTARE a interfetei, cu codu de mai jos ii ca si cum as avea
        Utilizator utl=new Utilizator("alex",TipRisc.RIDICAT);
        when(operatiiDB.getUtilizator()).thenReturn(utl);

        float expectedResult=0.7f;
        float actualResult= calculDobanda.calculDobandaUtilizator(operatiiDB.getUtilizator());

        assertEquals(expectedResult, actualResult);
    }

}
