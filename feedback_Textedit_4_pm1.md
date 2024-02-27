# Bewertung Text Editor
## 🥇 Die Note ist: 5.78 (38.25/40.00 Punkte)

🧪 Projektstand und Abschluss Textedit Gruppe 4

👫 bachhmoh@students.zhaw.ch; topaljas@students.zhaw.ch; djafeden@students.zhaw.ch; dubuicol@students.zhaw.ch


# Präsentation des Projektstandes: max 10P

👨‍🏫  Projektstand Klassendiagramm: 4: (0-4): 4

	
> - Sind genau die relevanten Klassen, Beziehungen und Attribute im Diagramm enthalten? Hilft es,
die Programmierung zielgerichtet vorzunehmen? Ist das Klassendiagramm übersichtlich
strukturiert und leicht verständlich formatiert? (3 Punkte)
> - Formale Korrektheit: Entspricht die Darstellung den Vorgaben aus dem Dokument
Klassendiagramm? (1 Punkt)


Volle Punktzahl! Sehr schönes Übersicht mit sehr vielen Überlgungen. Sehr schönes Pattern mit `TextEditor.Command`, das Teil der Controller-Layers ist und auch die Kontoller über den `Scanner` hat. Das Pattern ist im Klassendiagramm gut ersichtlich.  

Bemerkung: Beschreibung von `Paragraph(s)` war «out of sync». Wöhrend der Sitzung korrigiert, die Änderung war zu kurzfristig. Kein Abzug. 




👨‍🏫  Projektstand Klassenbeschreibung: 2: (0-2): 2

> - Sind die Beschreibungen genügend ausführlich, um den Zweck und die Zuständigkeiten der Klasse
zu definieren? Sind Sie kurz, prägnant und mit genügend Informationsgehalt? (2 Punkte)

Sehr gut! Die Klassen werden sehr präzise, kurz und bündig beschrieben. Genau so soll es sein.  Sehr schön fand ich die Unterteilung von «Purpose» und «Functionality».  


👨‍🏫  Projektstand Testkonzept: 4: (0-4): 3

> - Überzeugt das Konzept, dass die relevanten Teile der Applikation getestet werden? Ist die
Darstellung übersichtlich?


gut, übersichtlich, gut beschrieben, auch mit einigen Anwendungsfällen. Leider fehlt eine wichtige Funktion, da `INDEX` nicht aufgeführt ist. 


> An der Sitzung mit der Gruppe festgelegter Testumfang:

Notizen der Lehrperson

cf commit https://github.zhaw.ch/PM1-IT23tbZH-scmy-scnz/team4-nullpointers-projekt2-textedit/tree/245cda323d72265776f9ee098dcc477e6514a08c#testing-documentation


### unbewertete Kriterien: 

> Präsentation Logging (unbewertet)

Notizen der Lehrperson

> Ausgewählte Codestelle besprechen bezüglich Clean Code (unbewertet)

Notizen der Lehrperson

> Allfällige Unklarheiten klären (unbewertet) 

Notizen der Lehrperson



# Projekt-Abschluss: max 30P

## Entwicklung: max 20P  


👨‍🏫  Abschluss Funktionalität: 6: (0-41): 41  


> Vorführung oder Test durch Betreuer:   
(12 Funktionen à je 3 pt., 5  pt. für INDEX)  
> - (3 pt) Programm läuft eigenstöndig mit `main()` 
> - (3 pt) Eingabe mit `Scanner` funktioniert
> - (3 pt) `ADD` Einfügen ganzer Absätze
> - (3 pt) `DEL` Löschen ganzer Absätze
> - (3 pt) `REPLACE` Globales Suchen und Ersetzen von Text innerhalb eines Absatzes. 
> - (3 pt) `DUMMY` Dummy-Paragraf
> - (3 pt) `PRINT` Ausgabe des Textes auf der Konsole je nach Einstellung von FORMAT RAW oder FORMAT FIX
> - (3 pt) `FORMAT RAW` Unformatierte, absatzweise Ausgabe des Textes mit Angabe der Absatznummer 
> - (3 pt) `FORMAT FIX` Formatierte Ausgabe von Text mit einer einstellbaren maximalen Spaltenbreite Zeichen, Zeilenumbruch jeweils auf dem letzten Leerzeichen
> - (3 pt) Sonderzeichen werden gefiltert (z.B. £, €, 🌲, 🥶)
> - (3 pt) Fehlermeldungen auf `System.err`
> - (3 pt) `EXIT` Beenden der Applikation
> - (5 pt) `INDEX` Ausgabe eines Indexes (Wortverzeichnisses) aller Worte mit mehr als 3 Buchstaben, die öfter als dreimal auftreten mit Angabe des Absatzes 

Life Demo in der Stunden vor Abgabe:   

Funktionniert alles in der Demo. Alle haben Freude! 

Edgar Eggnog did a great job! 🍪  

very nice hidden `taleMode`! 




👨‍🏫  Abschluss CleanCode: 6: (0-8): 7

> Sie halten die Vorgaben hinsichtlich einsetzbarer Konstrukte und Clean Code ein.  
Kriterium: Codeanalyse durch Betreuer, ggf. Erläuterung: (2 pt) unerlaubte Konstrukte, (6 pt) CleanCode Handbuch) 

Der Code ist gut verstänglich aufgebaut und dokumentiert! Weiter so! 

Bemerkung: 
- die Methode `defineCommandType` ist etwas zu lang. Es wäre besser, wenn die Methode in kleinere Methoden aufgeteilt wird - Hinweis darauf sind auch die Kommentare im Code. 
- `userText` ist etwas unglücklich gewählt, zumal sogar im Javadoc steht, das sei der Paragraph. 
- die Methode `start` müsste eigentlich `run` heissen. 

-1 Pt 




👨‍🏫  Abschluss Klassenaufteilung: 3: (0-3): 3


> Sie haben eine sinnvolle Aufteilung in Klassen und Klassendefinitionen gefunden. (Kriterium: Analyse durch Betreuer, ggf. Erläuterung) 

Die Aufteilung der Klasse entpricht den Plänen aus den vorherigen Sitzungen und dem Ergebnis der instensiven Diskussionen im Team: Sehr gut! Weiter so - volle Punktzahl. 
Sehr gut gefallen hat mir die klar definierte Aufteilung der Zuständigekeiten der Klassen und deren Kapselung.  


👨‍🏫  Abschluss Test: 5: (0-5): 5


> Sie haben sinnvolle Test Cases gemäss Projektstandsitzung umgesetzt und erfolgreich ausgeführt. 

Die Testcases folgen gut dem Plan und testen ausführlich die Funktionalität. Es werden auch "schlechte" Testfälle getestet und die Strutktur der Tests ist gut lesbar: man sieht auf einen Blick, was getestet wird. Volle Punktzahl.



## Vorgehen und Dokumentation: max 10P


👨‍🏫  Abschluss Dokumentation: 6: (0-6): 6

> - (4 p) Ihr Code ist in Javadoc (mindestens für Klassen und Public Methods und zusätzlich für Konstruktoren, jedoch generell ohne Getter/Setter) und wo sinnvoll in Zeilenkommentaren zur Funktionalität dokumentiert.   
> - (1 p) Relevante Informationen finden sich im `README`, Abeweichungen vom Projektstand sind dokumentiert.
> - (1 p) Links zu Testkonzept und Klassendiagramm sind im `README` enthalten.

Das Readme ist sehr informativ und relevant gehalten: sehr gut! Weiter so.   
Stichproben und statische Code Analyse zeigen, dass JavaDoc in Ordnung ist. 




👨‍🏫  Abschluss Beitrag: 4: (0-4): 4


> Alle Gruppenmitglieder haben gleichermassen Code beigetragen und auf GitHub eingecheckt. (Eine einfache Variante wäre, dass jedes Gruppenmitglied für bestimmte Klassen verantwortlich ist, andere Aufteilungen sind aber denkbar. Kriterium: Check durch GitHub Log, Dokumentation im Code.)

Das Team hat vorbildich zusammengearbeitet. Alle haben gleichermassen beigetragen. Volle Punktzahl. Auch waren die Design-Workshops sehr spannend und konstuiv! 

Abwesenheit Bach: 3 Wochen weg im TextEdit wegen Militär WK. «neutral» bewerten (wie wenn er nicht da wäre), Absprache mit Team. Kein Abzug. 


# 📒 Notizen 

...aus den Coachings


