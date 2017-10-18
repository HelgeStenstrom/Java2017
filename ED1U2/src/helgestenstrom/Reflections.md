Reflektionsrapport 
==================


## Inledning
Fyra deluppgifter ska utföras. De har olika krav om 
tekniker som ska användas för att lösa uppgifterna.

## Genomförande
Jag startade med deluppgift A, men det blev liggande en 
längre tid. Jag använde fyra klasser och ett *interface*.

Precis som förra gången, så har jag menyer i två nivåer. 
Jag använder Int för menyvalet för att det är enklast så.

Dialogspråket är ömsom svenska, ömsom engelska.

### Gemensamma delar
Klasserna Main, MainMenu och NullStartable är gemensamma.

### Problem A
Klasserna Account, Bank och Person används till uppgiften.

### Problem B
Klassen Profit löser uppgiften. 

### Problem C
Klassen Transporter har en inre klass, BuntStorlek, för att 
bunta ihop dimensionerna för en bunt.

Utskriften är jag inte riktigt nöjd med. Jag vill inte skriva ut
några onödiga nollor i slutet av värdena, men hittade inget
sätt att göra det som gör källkoden lättläst.

### Problem D
En klass, fyra funktioner, två instansvariabler. 

## Diskussion

Genomgående problem är validering av indata, formatering av 
utskrifter och hur textmarkören rör sig.

Jag har valt att i stort sett strunta i att validera indata. 
Tänker att det får bli när vi kommer fram till Exceptions. 

Flyttal vill jag i allmänhet skriva ut utan onödiga nollor på slutet.
Lite googlande visade att jag behöver använda DecimalFormat, 
men et skulle ha gjort koden så svårläst att jag struntade i det, och
istället valde ett "lagom" antal nollor (en eller två).

När jag kör programmet, finns textmarkören ofta inte där min inmatade
text ska hamna, förrän jag börjar skriva texten. Det känns 
inte tillfredställande. Kanske problemet är kopplat till
min utvecklingsmiljö, IntelliJ IDEA. Har inte testat någon annan miljö.


Jag har inte skrivit särskit många kommentarer. Jag hoppas att
namn på klasser, funktioner och variabler är en tillräcklig 
dokumentation. Kommentarer riskerar ofta att ljuga. Det kan ävan 
namn göra, men det är mer uppenbart när man skriver koden, och 
därför lättare att rätta.


Att använda switch/case för menyer känns lite klumpigt. 
Jag skulle hellre göra en tabell med invärden och funktioner att
anropa. Det får bli en annan gång.

