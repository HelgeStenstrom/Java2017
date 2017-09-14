Reflektionsrapport
===================

## Inledning

Fyra deluppgifter skulle göras. De handlade alla om att ta emot data från användaren och att presentera 
data nästan oförändrat. Obligatoriska moment var att använda Scanner, loopar, if-, for- och switch-konstruktioner,
samt variabler av olika slag

## Genomförande

* Strukturen har jag lånat från en likande programmeringsuppgift som jag gör samtidigt i en annan kurs, men då i C#.
* Ett huvudprogam, Main.java innehåller main-funktionen som är obligatorisk i Java-program.
* Menu.java med klassen Menu() hanterar val av deluppgifter att köra
* Varje deluppgift, och även Menu() startas genom att anropa dess enda publika metod, start(). 
* Allt ligger i samma package (motsvarar nog ungefär namespacei C#)
* I stort sett har jag försökt att undvika att hitta "avancerade" konstruktioner som kanske inte ingått i kursen ännu. 
T.ex. finns inga hash/dictionary eller vad det nu heter i Java. Det hade kunnat vara användbart i deluppgift D.

## Diskussion
Jag är helt nybörjare på Java, och även på C# som jag försöker lära mig parallellt. Jag hade svårigheter med sådant 
som skiljer de två språken. 

Mest besvärlig var inmatning med input.next(), input.nextLine() och input.nextInt() och hur
de hanterar radslut och "tokens".  Lösningen blev att hålla mig till nextLine, och omvandla till Integer vid behov.
Detta gjordes med en wrapper. 

Mindre besvär var att "aaa" == "aaa" inte fungerar i Java, fast det fungerar i andra språk jag använt och minns något.
Åtminstone Python. Vidare vad som ska skrivas med inledande versal respektive bara små bokstäver, där skiljer Java och 
C#.

Ändå är språken så pass lika, att det inte var någon svårihet att översätta en labuppgift jag hade i C# till Java. 
Det är förstås inget jag kommer att lämna in.

Det språk jag använder mest är LabVIEW. Det är grafiskt och har ingen textbaserad källkod. Det vore intressant att
veta om eller hur det går att koppla ihop med Java.
