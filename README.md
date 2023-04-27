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

## EndPoint-uri folosite
Un endpoint este un punct final (adresa URL) al unei aplicații web sau a unei API (Interfață de Programare a Aplicațiilor) la care clienții (de obicei, alte aplicații sau servicii web) pot accesa resursele oferite de aplicația sau API-ul respectiv.
Acestea sunt de 4 feluri: GET solicita date,POST trimite date,PUT actualizeaza resurse,iar DELETE le sterge.
EndPoint-urile au fost implementate in clasele controller ale aplicatiei.

DisponibilityController:
 @GetMapping("/disps") : returneaza toate disponibilitatiile din  baza de date
 
FlightController
 @GetMapping("/flights") : returneaza toate zborurile din  baza de date
 @GetMapping("/flights/getFlight{id}"): returneaza un zbor in functie de id
 @GetMapping("/flights/getByDay/{day}"): returneaza un zbor in functie de ziua decolarii
 @GetMapping("/flights/getByDeparture/{from}"): returneaza un zbor in functie de locul plecarii
 @GetMapping("/flights/getByArrival/{to}"): returneaza un zbor in functie de locul sosirii
 @PostMapping("/flights/new"): creeaza un zbor nou cu informatii primite dintr-un requestBody
 @PutMapping("/flights/editFlight{id}"): modifica zborul cu id-ul dat avand informatii primite dintr-un requestBody
 @DeleteMapping("/flights/deleteFlight{id}") : sterge zborul cu id-ul dat
 
TicketController
@PostMapping("/tickets/new") : creeaza un bilet nou cu informatii primite dintr-un requestBody
 @GetMapping("/tickets/ticketsByFlight{id}"): returneaza lista biletelor aferente zborului cu id-ul dat
@PutMapping("/tickets/increaseTicketsByFlight{id}") :scumpeste toate bilete zborului cu id-ul dat 
 @PutMapping("/tickets/reduceTicketsByFlight{id}"):ieftineste toate bilete zborului cu id-ul dat
 
 UserController
 @GetMapping("/users") :  returneaza toti clientii din  baza de date
 @PostMapping("/users/new"): creeaza un user nou cu informatii primite dintr-un requestBody
## Detalii de implementare
Logica aplicatiei se foloseste in cadrul claselor Service.
Clasele Utilitare:
DispManager: 
 Clasa e responsabila pentru salvarea/modificarea in baza de date a disponibilitatiilor(atunci cand se genereaza un zbor,se doreste ca in spate sa i se creeze si disponbilitatea in mod automat).Aici se apeleaza direct metoda save din DispRepository(care extinde jpa).Metoda createDisponibility de asta se ocupa.Ea are ca parametru zborul pentru care salvam disponibilitatea .
 Metoda  modifyDisponibility reduce numarul de locuri dintr-o anumita clasa (economica/business/first_class) in urma achizitionarii unui bilet. Aceasta are nevoie de biletul si zborul ca parametrii.
 
 Clasele FlightNode,FlightGraph si FlightFinder au fost implementate cu scopul gasirii zborurilor indirecte(exp: Bucuresti-> Londra ;Londra->New York).FlightNode descrie structura unui nod din graful de cautare.Fiecare nod are informatia(zborul sau), parintele(care e tot un nod),lista vecinilor si un parametru visited de tip boolean.Am suprascris metoda equals(nodurile se compara in functie de informatia pe care o poarta,adica zborul lor).Vecninii sunt generati prin metoda findNeighbours.Consider doua noduri ca fiind vecini daca locul de aterizare pentru primul corespunde cu locul de decolare pentru al doilea.
 Clasa FlightGraph contine o lista de noduri FlightNode.Am implementat algortimul BFS pentru gasirea zborurilor indirecte in metoda findPath.Ca rezultat se obtine lista de zboruri sau null in cazul in care nu exista ruta intre doua noduri.Inainte de traversarea se verifica situatia zborului direct (exp: daca se doreste deplasarea de la Bucuresti la Londra ,dar exista deja un zbor in lista initiala).Parcurgerea grafului necesita o structura de tip coada (fifo) in care se adauga doar nodurile nevizitate ,alaturi de vecinii lor.Testarea (compararea cu destinatia dorita se face in momentul scoaterii din coada a nodului curent).Metoda constructSolution alcatuieste ruta in intregime folosindu-se de relatia parinte dintre noduri.Va construi de la inceput spre final,deci va trebui inversata inainte sa o returnam.
 Clasa FlightFinder retine ca atribute lista zborurilor si isi genereaza graful pentru cautare(respectand principiul singleton).Aceasta are o singura metoda findBestPath cu doi parametrii de tip String(nume plecare si nume destinatie) care returneaza lista zborurilor pentru ruta indirecta.
 

Observer Desing Pattern:
   Am folosit acest pattern pentru aplicarea de scumpiri/reduceri asupra preturilor biletelor.
   Clasa ticket va implementa interfata priceTickets cu cele 2 metode ale sale:priceIncrease si priceReduce care modifica
   valoarea biletului .Clasa TicketManager  detine o lista de bilete pe care se pot aplica scumpiri sau ieftiniri.
   Aceasta functionalitate ne permite sa manipulam un subset configurabil al totalului de bilete.(De exemplu daca se doreste scumpirea biletelor doar pentru un anumit zbor). 
   
Principiul singleton:
  Entitatille claselor utilitare (cum ar fi TicketManager) se instantia doar o singura data in tot procesul aplicatiei. 








   
