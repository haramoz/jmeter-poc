# Jmeter proof of concept
Wir werden eine Proof of Concept Jmeter-Anwendung für eine Java-Applikation implementieren. Im Rahmen dieses Projekts werden wir Jemeter auf Java/Spring basierte REST Api und Event Driven Api anwenden.

## Authors
Mehmet @mehmetmgrsl

Arka @haramoz

## Jmeter Maven Plugin
This Jmeter Maven plugin allows us to perform a performance test as part of the build process. To set up the steps, please visit [link](https://github.com/jmeter-maven-plugin/jmeter-maven-plugin )

### JMeter Tests
By default, the test files are stored in the path "src/test/jmeter".

### Result of the performance testing

By default, the results of the jmeter tests are located in the path "/target/jmeter/results". By default it is a .csv file, a different result output can be specified/configured

## Steps for the performance test
<pre>
mvn clean package
mvn spring-boot:run 
docker-compose up (for database)
mvn jmeter:jmeter (Neue bash)</pre>


or 

<pre>
docker-compose up
mvn jmeter:jmeter (New bash)</pre>

### Finishing touch
Add swagger api contract 
Junit mockito test cases

### Useful links
[mongodb_spring_official_example](https://github.com/mongodb-developer/mongodb-springboot/blob/main/mdb-spring-boot/src/main/java/com/example/mdbspringboot/MdbSpringBootApplication.java)

[mongodb_springboot_docs](https://www.mongodb.com/compatibility/spring-boot)

Useful tool for working with mongodb:
[mongodb_compass](https://www.mongodb.com/try/download/compass)

Martin comments:
Also ramp up functionality, also very cool resource need projection.
-> Added todos.md
