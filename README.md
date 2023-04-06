# Bilete de avion





## Intro&Features



Aplicatia este destinata cumpararii online de bilete de avion.
Clientul poate sa caute oferte de zbor in functie de destinatie,data si disponibilitate.
Se pun la dispozitie 3 clase de bilete(economic,bussiness si first class) ,cu preturi diferite.
De asemnea,clientul poate solicita generarea unei noi rute alcatuite din mai multe zboruri cu escale daca nu exitsa zbor direct de la locatia in care se afla.
Administratorul poate sa centralizeze noile zboruri,sa actualizeze/modifice ofertele sau sa anuleze (sa stearga) unele calatorii.
Atat clientul cat si admin-ul trebuie sa se inregistreze pentru a beneficia de functionaliatile prezentate.

## Baza de date

Baza de date este alcatuita din 4 tabele :
Tabela Client are un id(primary key),nume,locatia si parola.
Numele si parola reprezinta credentialele pentru inregistrare,iar locatia e pentru primirea ofertelor de zbor in functie de locul in care se afla.
Tabela Bilet contine id-ul clinetului(cel care detine biletul),id-ul zborului,pretul si clasa.
Tabela Zbor contine id-ul de zbor(cod unic) ,ziua decolarii,locul de decolare si aterizare,si id-ul disponibilitatii.
Tabela Disponibilitate stocheaza numarul de locuri disponibile pentru un zbor din fiecare clasa.
Pretul de baza este pentru clasa economica.Clasa bussiness va fi cu 80% mai scumpa,iar first class cu 120% din pretul de baza.

Atunci cand administratorul inregistreaza un nou zbor,disponibilitatea calatoriei se va genera automat(tabela zbor fiind in relatie unu la unu cu disponibilitatea).De asemnea,la sterge zborului se va sterge si disponibilitatea.

## Detalii de implementare

Observer Desing Pattern:
   Am folosit acest pattern pentru aplicarea de scumpiri/reduceri asupra preturilor biletelor.
   Clasa ticket va implementa interfata priceTickets cu cele 2 metode ale sale:priceIncrease si priceReduce care modifica
   valoarea biletului .Clasa TicketManager  detine o lista de bilete pe care se pot aplica scumpiri sau ieftiniri.
   Aceasta functionalitate ne permite sa manipulam un subset configurabil al totalului de bilete.(De exemplu daca se doreste scumpirea biletelor doar pentru un anumit zbor). 








   
