# Jmeter proof of concept
Wir werden eine Proof of Concept Jmeter-Anwendung für eine Java-Applikation implementieren. Im Rahmen dieses Projekts werden wir Jemeter auf Java/Spring basierte REST Api und Event Driven Api anwenden.

## Authors
Mehmet @mehmetmgrsl

Arka @haramoz

## Jmeter Maven Plugin
Dieses Jmeter Maven Plugin ermöglicht es uns, einen Leistungstest als Teil des Build-Prozesses durchzuführen. Für die Einrichtung der Schritte besuchen Sie bitte [link](https://github.com/jmeter-maven-plugin/jmeter-maven-plugin )

### JMeter Tests
Die test Files werden standardmäßig im Pfad "src/test/jmeter" abgelegt.

### Ergebnisse des Leistungstests

Die Ergebnisse der jmeter-Tests befinden sich standardmäßig im Pfad "/target/jmeter/results". Standardmäßig handelt es sich um eine .csv-Datei, eine andere Ergebnisausgabe kann angegeben/konfiguriert werden

## Schritte zur Ausführung des Leistungstests
<pre>
mvn clean package
mvn spring-boot:run 
mvn jmeter:jmeter (Neue bash)</pre>

### Finishing touch
Add swagger api contract 
Junit mockito test cases

### Useful links
[mongodb_spring_official_example](https://github.com/mongodb-developer/mongodb-springboot/blob/main/mdb-spring-boot/src/main/java/com/example/mdbspringboot/MdbSpringBootApplication.java)

[mongodb_springboot_docs](https://www.mongodb.com/compatibility/spring-boot)

Useful tool for working with mongodb:
[mongodb_compass](https://www.mongodb.com/try/download/compass)

Martin comments:
Also load testing, ramp up functionality, also very cool resource need projection.
