# Use the official Maven image as the base image
FROM maven:3.8.3-openjdk-17 AS build

ENV SPRING_DATA_MONGODB_URI=mongodb://admin:admin@mongodb:27017/mydb?authSource=admin

# Copy the pom.xml file into the working directory
COPY pom.xml .

# Download dependencies
RUN mvn dependency:go-offline

# Copy the rest of the application source code
COPY src ./src

# Build the application using Maven
RUN mvn clean package -DskipTests

# Use the official OpenJDK image as the base image for the runtime
FROM openjdk:17-jdk-alpine


# Copy the built JAR file from the build stage
COPY --from=build target/*.jar app.jar


# Expose the application port
EXPOSE 8080

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]
