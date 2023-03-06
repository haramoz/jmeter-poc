FROM maven:3.8.3-openjdk-17 AS build
WORKDIR /app
COPY pom.xml .
COPY src/ /app/src/
RUN mvn clean package -DskipTests

FROM tomcat:9-jdk17-openjdk-slim-buster

# Because the new image put the tomcat server in webapps.dist directory but try to start with webapps directory.
# https://github.com/docker-library/tomcat/issues/184 
RUN mv webapps webapps2
RUN mv webapps.dist/ webapps

COPY --from=build /app/target/*.war /usr/local/tomcat/webapps

EXPOSE 8080
ENTRYPOINT ["catalina.sh", "run"]