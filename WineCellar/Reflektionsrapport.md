# Vinkällaren, ett Java-projekt

## Krav och lösningar

### Programmet ska ha en meny
Det finns en mycket enkel meny (MenuBar), med två kommandon: Fil->Avsluta, och Hjälp->Om.
Om ger samma hjälptext som man når med Hjälp-knappen.

### Programmet ska ha en hjälpfunktion
Programmet måste ha en hjälpfunktion som kan nås när programmet
körs (via en meny eller på annat vis).
Man kan nå hjälpfunktionen på två sätt: Med menyvalet Hjälp -> Om, eller genom att klicka 
på hjälp-knappen.

### Programmet ska bestå av minst fyra klasser
Programmet består för närvarande av klasserna CellarManager,
EntryController, ListController, Main, White och WineBase. Utöver
dessa finns två Enum: CharacterType och WineType, och ett interface:
Wine. 

Av dessa ligger kärnan i CellarManager och WineBase. De skulle se
tämligen lika ut om programmet inte hade något GUI.

White är en underklass till Wine. Jag skulle kunna skapa Red och Rose
också, men har inte gjort det.

Interfacet Wine kan tyckas onödigt. Jag gjorde det mest för att testa.
Jag ville ha en viss separation mellan metoder som kan anropas (Wine)
och gemensam funktionalitet (WineBase). White har inte mycket
funktionalitet för närvarande.

CharacterType borde egentligen delas upp i flera Enum, eftersom de
olika värdena är kopplade till olika vintyper (vitt eller rött). Men
det blir ganska krångligt att populera ChoiceBox med olika värden
beroende på om vinet är rött eller vitt. Men fullt görbart. Jag ser
det som överkurs.

EntryController och ListController sköter varsitt formulär som är
gjort med JavaFX Scene Builder. Det var knepigt att få till det, och
det stör mig att fälten som motsvarar grafiska komponenter är public.

### Varje klass måste ha både metoder och fält
Känns som ett onödigt krav. Klassen Main saknar fält. Kanske
superklassen Application har fält? Jag har inte kollat. 

Klassen White saknar också fält, men superklassen WineBase har fält.
White är bara en dum utökning av WineBase. Om jag skulle dela upp enum
CharacterType i olika enum för rött respektive vitt, skulle White bli
något mer komplex.

I övrigt har klasserna både metoder och fält.

### Programmet måste använda sig av
* Klasser och objekt. Det finns objekt av varje klass, utom möjligen
Main. Jag har inte gjort  något kod som skapar objekt av Main. Kanske
superklassen Application gör det. 
* Array eller ArrayList. Listan av viner är en ArrayList<Wine>.
* Metoder. Det finns gott om metoder.
* Fält och variabler. Det finns gott om både fält och variabler.
* Loop. Jag använder mig gärna av loopen "for (Thing thing : things) {}".

### Objektens integritet
Jag har förstått att det inte bara handlar om public vs private. I
vissa fall ökar man integriteten genom att kopiera objekt. Det gör jag
exempelvis i copy constructorn WineBase(WineBase other). Det är en
metodik som fungerar även i språk utan public/private (jag tänker på
Python). 


## Kommentarer
Programmets upplägg har jag tagit ganska mycket från ett liknande
projekt i C#, där jag använder Visual Studio. Språken är ju ganska
lika, men mycket tankemöda har behövs för att behärska JavaFx
tillräckligt. Man får inte lika mycket hjälp från verktyget som man
har i VisualStudio, även om IntelliJ IDEA är bra på många andra sätt. 

Jag har också försökt testa saker med Junit, även det tämligen nytt
för mig. Jag har använt Pythons motsvarighet. Jag har inte alls så
många tester som jag skulle vilja. Att testa GUI är svårt, och det
mesta av komplexiteten har (tyvärr) hamnat där. 

Jag är osäker på hur man bäst jobbar med JavaFx och den fxml-fil som
Scene Builder skapar. Jag använder gärna Scene Builder, för det är bra
att visualisera användargränssnittet redan innan programmet körs. Men
hopkopplingen fungerar inte fullt ut. Scene Builder kan lägga till
vilken Controller som ska användas, men om jag gör det, får jag en
runtime exception (InvocationTargetErrorException, eller något i den
stilen). Genom att sätta kontroller i Java-koden undviker jag det,
men då missar jag en koppling till GUI-objekten. Jag har ett antal
fält som IntelliJ skapade åt mig då, men nu när inte fxml-filen sätter
Controller, vet inte IntelliJ att dessa objekt ofta har en
understruktur, och jag får ingen hjälp med att skriva koden.

En workaround är att bygga upp menyer och TablView i koden, i en
MenuBar respektive TableView som jag skapat i Scene Builder. Det känns
inte optimalt.
