Oppagve 1:

a) Hva slags datastruktur vil du bruke til å lagre hendelsene som venter
på at deres tid skal komme. Hvilke klasser kan du eventuelt bruke fra
standardbiblioteket. Begrunn svaret.



Når vi skal programmere en eventsimulering er det flere data
strukturer vi kan bruke. En vanlig datastruktur som har blitt brukt til eventSim,
er LinkedList. En linkedList er en linær datastruktur hvor elementene, også kjent som noder,
ikke er lagret kontinuerlig etterhverandre i minnet, slik et array har.
 Nodene har en peker til en annen node i minnet. Den første noden er ofte referet til som head, den siste noden som tail.
 Når vi legger til en ny node bakerst i listen vil den peke  til ingenting eller null,
 dog vil den forrige noden peke til den nye. eksempel: A -> B -> C -> null. Legger til D.
 A -> B -> C -> D -> null. Bruker vi en dobbelt linket liste, har en node pekere til den forrige og den neste noden:
 null <- A <-> B <-> C <-> D -> null. Slik at vi kan traversere listen båden fram og tilbake. Fordelen med en lenka liste,
 er at vi kan hente ut første og siste element.   
 Slik at vi raskt kan hente ut både første og siste element. I noen tilfeller 
 kan vi det også være hensiktmessig og ha en sirkulær
 linkedList. Da vil siste noden peke tilbake til start. Linkedlist er rask til å "inserte" både foran og bak, med O(n). 
 I midten er den vanligvis O(n) men er O(1) om vi har en iterator eller cursor på posisjon noden befinner seg i.
 Det samme mønsteret gjelder for removal. Selv om en lenka liste kunne funket bra som en data struktur for eventsimulering faller valget
 valget på PriorityQueue. 
PriorityQueue klassen i java er basert på en priority heap (Java, 2018). En priority heap er en lika datastruktur som en queue eller stack, bare at elementene har en prioritet assosiert med seg.
I en prioritetskø vil elementet som har høyest prioritet bli toppen av det binære treet, slik at den vil bli behandlet først (Wikipedia, 2020).
Dette er fordelaktig da vi skal simulere hendelser over tid. Nettopp fordi hendelser skjer før hverandre i tid. 


oppgave 2a
 for å holde på store mengder med informasjon kan det være lurt å tenke over hvilken struktur  vi skal velge å lagre de i. siden det er snakk 10.000 objekter og vi har kun behov for å hente ut
 tilfeldige personer på en spesifikk index med RandomWrapper. Første kunne jeg brukt en ArrayList, men da vi ikke har behov for å fjerne noen fra listen, selv de som er døde er det bedre å bruke en array.
 Da den tar mindre plass i minnet.


###Kilder
    
 Priority Queue, https://en.wikipedia.org/wiki/Priority_queue
 Priority queue, https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/PriorityQueue.html
 LinkedList,  https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/LinkedList.html
