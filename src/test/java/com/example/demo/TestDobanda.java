package com.example.demo;
import com.example.demo.Lab7.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;



@RunWith(MockitoJUnitRunner.class)
public class TestDobanda {

    //interfata -contractul cu db MOCK-UITA
    @Mock
    OperatiiDB operatiiDB;


   @Test
    public void testDobandaMica(){
        CalculDobanda calculDobanda = new CalculDobanda();
        float expectedResult=0.2f;

        float actualResult= calculDobanda.calcul(TipDobanda.MICA);

       assertEquals(expectedResult, actualResult);
    }


    //!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!

    //aici se observa ca poti da de fiecare data alt user
    //ceea ce te ajuta sa faci teste diferite
    //asta nu era posibil daca foloseam implementarea interfetei
    //se face din when......then RETURN

    //!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!

    @Test
    public void testUtilizatorDobandaScazuta()
    {
        //ma folosesc de mock
        //daca nu am IMPLEMENTARE a interfetei, cu codu de mai jos ii ca si cum as avea
        //presupun ca nu am implementare pentru interfata


        float expectedResult=0.2f;

        Utilizator utl=new Utilizator("alex",TipRisc.SCAZUT);
        when(operatiiDB.getUtilizator()).thenReturn(utl);

        //folosesc al doilea constructor care are interfata ca parametru
        CalculDobanda calculDobanda = new CalculDobanda(operatiiDB);


        float actualResult= calculDobanda.calculDobandaUtilizator();
        assertEquals(expectedResult, actualResult);

        //verify e din mock
        verify(operatiiDB).getUtilizator();
    }



    @Test
    public void testUtilizatorDobandaMedie()
    {
        //ma folosesc de mock
        //daca nu am IMPLEMENTARE a interfetei, cu codu de mai jos ii ca si cum as avea
        //presupun ca nu am implementare pentru interfata


        float expectedResult=0.5f;

        Utilizator utl=new Utilizator("alex",TipRisc.MEDIU);
        when(operatiiDB.getUtilizator()).thenReturn(utl);

        //folosesc al doilea constructor care are interfata ca parametru
        CalculDobanda calculDobanda = new CalculDobanda(operatiiDB);


        float actualResult= calculDobanda.calculDobandaUtilizator();
        assertEquals(expectedResult, actualResult);

        verify(operatiiDB).getUtilizator();
    }



    @Test
    public void testUtilizatorDobandaRidicata()
    {
        //ma folosesc de mock
        //daca nu am IMPLEMENTARE a interfetei, cu codu de mai jos ii ca si cum as avea
        //presupun ca nu am implementare pentru interfata


        float expectedResult=0.7f;

        Utilizator utl=new Utilizator("alex",TipRisc.RIDICAT);
        when(operatiiDB.getUtilizator()).thenReturn(utl);

        //folosesc al doilea constructor care are interfata ca parametru
        CalculDobanda calculDobanda = new CalculDobanda(operatiiDB);


        float actualResult= calculDobanda.calculDobandaUtilizator();
        assertEquals(expectedResult, actualResult);
        verify(operatiiDB).getUtilizator();
    }


    //TEMA DECUPLAREA FATA DE BD
    //definesti o interfata pt serivce alta decat jpa
    //o implementezi intr o clasa



}
