
Beschrijving 
De VN wil dat de maan wordt verdeeld onder de verschillende bondgenoten. Hiervoor is een nieuwe organisatie, de Verenigde Ruimte Naties, opgericht met als leden de bondgenoten van de VN. Alle inwoners van de deelnemende landen krijgen een stukje maan, een zogenaamd maanperceel. Elk perceel valt onder één kadastraal land en is van een bepaald type. De verschillende typen zijn: woonperceel, mijnbouwperceel, waterwinperceel, landbouwperceel of lanceerbasis. Elk perceel type heeft zo z’n eigen kenmerken, maar ook een aantal overeenkomende kenmerken zoals oppervlakte, begrenzing etc. De Verenigde Ruimte Naties kunnen beperkingen opleggen op maanpercelen. Een eigenaar kan zijn perceel verkopen aan iemand anders, mits er geen beperking op ligt. Bij verkoop moet vastgelegd worden op welke datum het eigendomsrecht overgaat naar een ander persoon. Verkoop/aankoop wordt vastgelegd in een transactie.
 
Opdracht 1 
De maan bestaat uit kadastraal land en moet worden onderverdeeld in verschillende maanpercelen. Deze maanpercelen hebben een eigenaar. Ook kunnen ze van eigenaar wisselen door transacties (aankoop/verkoop). Er zijn verschillende type maanpercelen: woonperceel, mijnbouwperceel, waterwinning perceel, landbouwperceel en lanceerbasisperceel. Sommige type percelen mogen niet verkocht worden. Alle percelen hebben de volgende eigenschappen: id, locatie, grootte, grens (Polygoon, een verzamelingen van coördinaten waarbij de eerste en laatste coördinaat hetzelfde zijn waardoor je een gesloten polygoon hebt). De specifieke perceeltypes hebben ieder weer hun eigen eigenschappen:
•	Woonperceel – hoeveel mensen er kunnen wonen
•	Mijnbouwperceel – type delfstof en wat is de opbrengst per jaar in kilo’s
•	Waterwinning – hoeveel kubieke meter per jaar
•	Landbouwperceel – type gewas en opbrengst
•	Lanceerbasis – maximale raketgrootte die kan landen en opstijgen
De types gewas en delfstof zijn een vaste lijst. 
Dit zijn de mogelijke gewassen in een circulaire kas: 
•	Tomaat,
•	Komkommer,
•	Radijs
•	Sla,
•	Paprika
Dit zijn de mogelijke delfstoffen:
•	helium-3
•	iridium
•	regoliet
•	goud
•	palladium
•	platina
De opdracht voor dag 1: maak het UML diagram en codeer dit. 

Opdracht 2
De Verenigde Ruimte Naties willen voor hun administratie een aantal zaken op kunnen opvragen:
•	Maanadministratie met lijst percelen

Maak lambda expressions om de volgende gegevens te verkrijgen:
•	Percelen die vaker dan gemiddeld zijn verkocht
•	Percelen die veel vaker dan gemiddeld zijn verkocht
•	Percelen die minder dan gemiddeld zijn verkocht
•	Percelen die veel minder gemiddeld zijn verkocht
•	Percelen die meer/minder delfstoffen/gewassen opleveren dan gemiddeld

Ook moet er een methode zijn om het aantal verkochte maanpercelen te berekenen per periode uit te rekenen. Een methode om het aantal delfstof percelen en het aantal gewas percelen te berekenen. De gemiddelde opbrengst van een perceel per gewas en per delfstof moet berekend kunnen worden. Het aantal inwoners ouder dan 30 jaar per woonperceel moet opgevraagd worden. 

Dit alles moet periodiek gerapporteerd worden. Deze periode moet flexibel zijn. Om te laten zien dat het werkt graag de rapportage uitdraaien per maand (mag console applicatie zijn met output van de rapoortage in het console).


Deel 3
De VN wil de administratie van delfstoffen verder uitwerken. De enum delfstof wordt vervangen door een immutable object. Dit Object bevat gegevens over bijv. elementnaam, elementnummer, stofdichtheid, radioactief. Voor het maken van deze objecten hebben we een klasse DelfstofBuilder nodig.
Maanadministratie moet singleton worden.
Verder, voor zover dit nog niet is toegepast op het model dient encapsulation te worden toegepast. 

Deel 4
Om mensen en waren van de ene plek naar de andere te kunnen vervoeren zijn er op de maan een aantal vervoersbedrijven. Deze vervoersbedrijven maken gebruik van verschillende vervoersmiddelen, zoals een raket of een monorail.
De vervoersbedrijven hebben voor het verplaatsen van passagier een set van beschikbare zitplaatsen per trein, per vertrektijd, per station. Een passagier kan een plek reserveren, deze plek is dan niet meer beschikbaar.  De passagier kan een specifieke plek reserveren.
Voor het verplaatsen van vracht worden vrachtlijsten bijgehouden dit zijn queues. Op de vrachtlijsten staan vrachten (vrachtklasse, met gewicht, inhoud, bederfelijk J/N)
Voor de velden inhoud en gewicht zou gewerkt kunnen worden met een mengsel van long, Long, int en Integer. Met autoboxing zou de compiler dan zelf moeten bepalen welke methode gebruikt wordt of welke Wrapperclass/primitive er gebruikt wordt.
Er zijn kratten aanwezig voor bepaald type (delf)stoffen. Er kunnen verschillende types kratten gedefinieerd worden, verschillende groottes of voor verschillende soorten stoffen: vloeibaar, gas, vast. 
De vrachtlijst kan verschillende soorten kratten bevatten. Er zijn kratten en er zijn passagiers, ze nemen allebei een bepaalde ruimte in. 
Per rit (van A naar B) wordt gekeken hoe de vracht en de passagiers zo optimaal mogelijk vervoerd kunnen worden. Zo moet er rekening gehouden worden met wat er het eerst of het laatst in- of uitgepakt moet worden, denk bijvoorbeeld aan bederfelijk waar. Bij de sortering komen dan deze kratten bovenaan de lijst.
De beschikbare ruimte moet zo veel mogelijk worden gevuld.
Je zou bijvoorbeeld een monorail kunnen hebben waarin tien kratten passen. Iedereen die iets vervoerd wil hebben zet het in de queue. Als de queue vol is kan de monorail vertrekken. Je kunt er dan voor kiezen om kratten met bederfelijke waar voorrang te geven in de queue.
De verschillende typen kratten moeten onderling vergeleken kunnen worden en gesorteerd kunnen worden op bepaalde eigenschappen.


Deel 5
Alle statements die geprint worden moeten zowel beschikbaar zijn in het Nederlands, Engels en het Maans.

Deel 6

Controleer bij het aanmaken van de delfstof of de waarden die niet null mogen zijn ook daadwerkelijk gevuld zijn.
Is dit niet het geval gooi dan een eigen Exceptie.
 
(Bouw een unittest om dit gedrag te testen.)
 
Probeer het verschil tussen Unchecked en Checked exceptions.
Beslis of je een exception ter plekke afvangt of doorgooit.
 
 
Kijk naar de bestaande code en zoek uit waar je ExceptionHandling toe kunt voegen.
Zoek hierbij in de lijst met OCP-exceptions welke het best van toepassing is.

Deel 7:
Bij het inboeken van het transport van kratten is er plaats voor maximaal 20 kratten per wagon.

Het inboeken kan door meerdere personen tegelijk gedaan worden.

Zorg ervoor dat de wagons niet overboekt worden.


Dit is te testen in een unittest waarbij met meerdere threads tegelijk kratten ingeboekt worden.

Eventueel bouw je een wachttijd in bij het inboeken om de kans op dubbel boeken te vergemakkelijken.


Maak een lijst met delfstoffen, probeer in de ene thread alle namen van delfstoffen om te zetten naar uppercase en in de andere thread naar lowercase.

Laat deze tegelijk lopen.

Laat bijvoorbeeld de ene thread van achter naar voren door de lijst lopen en in de andere thread andersom.


Bonusopdracht:
**Dit mag in een losstaand project gemaakt worden, het is vooral qua verhaallijn dat het de case raakt**
De transportservice wordt uitgebreid met een bezorgservice. 
Op deze manier kunnen de maanperceeleigenaren hun gewassen en delfstoffen versturen. 
Deze bezorgservice maakt gebruik van de transportservice.
De bezorgservice werkt met garanties van uiterlijke bezorging, zodat de maanperceeleigenaren exact weten waar ze aan toe zijn. 
De datum voor uiterlijke bezorging kan precies berekend worden aan de hand van een aantal gegevens. 
De uiterlijke datum hangt namelijk af van een aantal factoren, zoals de dag waarop de bezorgservice is afgenomen, 
de afstand tussen ophalen en bezorgen, type product (er zijn verschillende categorieën, zoals gewassen, 
en dan nog subcategorieën gewassen met en zonder vergunning) en geldende wet en regelgeving. 
Zo zijn er verschillende types bezorgservice te selecteren, 
want zoals je je voor kunt stellen moeten tomaten sneller bezorgd en anders vervoerd worden dan goud. 
De houdbaarheid van de producten moet meegenomen worden in het berekenen van de uiterste bezorgdatum door middel van een in te stellen regel 
(bijv: producten moeten altijd nog 50% van hun houdbaarheid over hebben op het moment van bezorging tov aanvraagdatum bezorgservice). 
Sommige producten worden op alle kalenderdagen vervoerd, andere enkel op werkdagen (en dus niet feestdagen en weekenddagen). 
Houd hierbij rekening met dat er op de maan afwijkende feestdagen kunnen gelden, deze moeten dus nog toegevoegd kunnen worden.
In sommige gevallen kan de houdbaarheid worden verlengd door het toevoegen van een bepaalde stoffen of het anders verpakken van producten, 
het anders regelen van het klimaat in het transportmiddel of het verlengen van een vervoersvergunning voor speciale producten). 
Er gelden andere regels rondom het vervoeren van gewassen en delfstoffen waar vergunningen op zitten, zoals de opiaten en radioactieve stoffen. 
Deze mogen bijvoorbeeld enkel op werkdagen vervoerd worden en moeten binnen een bepaalde tijd vervoerd worden, 
terwijl de andere stoffen op alle kalenderdagen vervoerd kunnen worden. 
Er kan wel een verlengde vervoersvergunning aangevraagd worden om de uiterlijke bezorgdatum uit te stellen. 
De regels voor opiaten en radioactieve stoffen verschillen ook weer aan de hand van de maanhelften die ieder hun eigen regels hanteren. 
Aan de hand van een soort beslisboom met rekenmodule moet een uiterlijke bezorgingsdatum getoond worden aan de afnemer van de bezorgservice. 
De regels die achter de rekenmodule zitten zullen regelmatig veranderen, omdat de algemene regelgeving 
op de maan nog zeer nieuw is en dit daarom aan de hand van nieuwe inzichten regelmatig aangepast zal worden.

Opdracht week 7:
Bij het inboeken van het transport van kratten is er plaats voor maximaal 20 kratten per wagon.

Het inboeken kan door meerdere personen tegelijk gedaan worden.

Zorg ervoor dat de wagons niet overboekt worden.


Dit is te testen in een unittest waarbij met meerdere threads tegelijk kratten ingeboekt worden.

Eventueel bouw je een wachttijd in bij het inboeken om de kans op dubbel boeken te vergemakkelijken.


Maak een lijst met delfstoffen, probeer in de ene thread alle namen van delfstoffen om te zetten naar uppercase en in de andere thread naar lowercase.

Laat deze tegelijk lopen.

Laat bijvoorbeeld de ene thread van achter naar voren door de lijst lopen en in de andere thread andersom.


Bonusopdracht:
**Dit mag in een losstaand project gemaakt worden, het is vooral qua verhaallijn dat het de case raakt***
De transportservice wordt uitgebreid met een bezorgservice. Op deze manier kunnen de maanperceeleigenaren hun gewassen en delfstoffen versturen. Deze bezorgservice maakt gebruik van de transportservice.
De bezorgservice werkt met garanties van uiterlijke bezorging, zodat de maanperceeleigenaren exact weten waar ze aan toe zijn. De datum voor uiterlijke bezorging kan precies berekend worden aan de hand van een aantal gegevens. De uiterlijke datum hangt namelijk af van een aantal factoren, zoals de dag waarop de bezorgservice is afgenomen, de afstand tussen ophalen en bezorgen, type product (er zijn verschillende categorieën, zoals gewassen, en dan nog subcategorieën gewassen met en zonder vergunning) en geldende wet en regelgeving. 
Zo zijn er verschillende types bezorgservice te selecteren, want zoals je je voor kunt stellen moeten tomaten sneller bezorgd en anders vervoerd worden dan goud. De houdbaarheid van de producten moet meegenomen worden in het berekenen van de uiterste bezorgdatum door middel van een in te stellen regel (bijv: producten moeten altijd nog 50% van hun houdbaarheid over hebben op het moment van bezorging tov aanvraagdatum bezorgservice). Sommige producten worden op alle kalenderdagen vervoerd, andere enkel op werkdagen (en dus niet feestdagen en weekenddagen). Houd hierbij rekening met dat er op de maan afwijkende feestdagen kunnen gelden, deze moeten dus nog toegevoegd kunnen worden.
In sommige gevallen kan de houdbaarheid worden verlengd door het toevoegen van een bepaalde stoffen of het anders verpakken van producten, het anders regelen van het klimaat in het transportmiddel of het verlengen van een vervoersvergunning voor speciale producten). 
Er gelden andere regels rondom het vervoeren van gewassen en delfstoffen waar vergunningen op zitten, zoals de opiaten en radioactieve stoffen. Deze mogen bijvoorbeeld enkel op werkdagen vervoerd worden en moeten binnen een bepaalde tijd vervoerd worden, terwijl de andere stoffen op alle kalenderdagen vervoerd kunnen worden. Er kan wel een verlengde vervoersvergunning aangevraagd worden om de uiterlijke bezorgdatum uit te stellen. De regels voor opiaten en radioactieve stoffen verschillen ook weer aan de hand van de maanhelften die ieder hun eigen regels hanteren. Aan de hand van een soort beslisboom met rekenmodule moet een uiterlijke bezorgingsdatum getoond worden aan de afnemer van de bezorgservice. 
De regels die achter de rekenmodule zitten zullen regelmatig veranderen, omdat de algemene regelgeving op de maan nog zeer nieuw is en dit daarom aan de hand van nieuwe inzichten regelmatig aangepast zal worden.
