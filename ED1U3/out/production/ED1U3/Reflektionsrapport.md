# Reflektionsrapport
Helge Stenström

## Inledning
Fyra deluppgifter skulle genomföras. 
Alla fyra använder uteslutande kommandoraden (terminal) för
kommunikation med användaren. Uppgifterna tycks fokusera på:
- Klasser och objektorienterad programmering
- Arrayer (som i C, med fast storlek)
- ArrayList, som kan ändra storlek
- Olika sätt att loopa
- Getter- och setter-metoder

## Genomförande
I flera av delupgifterna använde jag main-klassen 
(den som innehåller metonden main()) till kommunikation med användare,
och införde en annan klass, som det bara finns ett objekt av, som ett mellanlager
ovanpå den klass som det finns flera objekt av.

Tanken är att man ska kunna ersätta main() med något annat, t.ex. ett GUI 
baserat på JavaFx. (Men jag kan inget om GUI-programmering i Java.)

Mellan-klassen, och till viss "lägsta" klassen (den med många objekt),
har jag försökt göra unit-tests för. Detta eftersom jag vill lära mig
unit tests med Java. Jag tror det är Junit4 som jag har använt.

Inspirerad av videon, och till skillnad från förra inlämningsuppgiften,
har jag denna gång gjort fyra stycken separata program.
Jag har inte satt mig in i hur man kan köra dem från kommandoraden, utan
har bara kört inifrån mitt IDE (IntelliJ IDEA), men jag antar att det
är trivialt för examinatorn att skapa och köra jar-filen, eller vad det nu heter,
precis som i videon.

Huvudprogram:
- helgestenstrom.D1P3A.MainProblemA.main()
- helgestenstrom.D1P3B.MainProblemB.main()
- helgestenstrom.D1P3C.MainProblemC.main()
- helgestenstrom.D1P3D.MainProblemD.main()


## Diskussion
Lite som en tidigare inlämningsuppgift, så har jag haft svårigheter
med input. Scanner input.nextLine() gör inte riktigt som jag vill. 
Men jag lärde mig ett sätt att hantera det.

Uppgiften med pengapåsarna kändes lite oklar. Textbeskrivningen stämde 
inte överens med videon. I textbeskrivningen nämndes inte någon totalvolym, 
och inte heller något om optimering. Den optimering som gjordes i videon
gick stick i stäv med kraven i texten (störst påse först). 
Inte heller stämde storlekarna överens mellan text och video.

Jag valde att använda totalvolym och påsstorlek från videon.

