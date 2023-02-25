# Jmeter proof of concept
Wir werden eine Proof of Concept Jmeter-Anwendung für eine Java-Applikation implementieren. Im Rahmen dieses Projekts werden wir Jemeter auf Java/Spring basierte REST Api und Event Driven Api anwenden.

## Authors
Mehmet @mehmetmgrsl

Arka @haramoz

## Jmeter Maven Plugin
Dieses Jmeter Maven Plugin ermöglicht es uns, einen Leistungstest als Teil des Build-Prozesses durchzuführen. Für die Einrichtung der Schritte besuchen Sie bitte [link](https://github.com/jmeter-maven-plugin/jmeter-maven-plugin )

### Tests
Die test Files werden standardmäßig im Pfad "src/test/jmeter" abgelegt.

### Ergebnisse des Leistungstests

Die Ergebnisse der jmeter-Tests befinden sich standardmäßig im Pfad "/target/jmeter/results". Standardmäßig handelt es sich um eine .csv-Datei, eine andere Ergebnisausgabe kann angegeben/konfiguriert werden

## Schritte zur Ausführung des Leistungstests
<pre>
mvn clean package
mvn spring-boot:run 
mvn jmeter:jmeter (Neue bash)</pre>