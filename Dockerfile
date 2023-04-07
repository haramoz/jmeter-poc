# Use the official Maven image as the base image
FROM maven:3.8.3-openjdk-17 AS build

# Set the working directory
WORKDIR /app

ENV SPRING_DATA_MONGODB_URI=mongodb://admin:admin@mongodb:27017/mydb?authSource=admin

# Copy the pom.xml file into the working directory
COPY pom.xml .

# Download dependencies
RUN mvn dependency:go-offline

# Copy the rest of the application source code
COPY src ./src

# Build the application using Maven
RUN mvn clean package

# Use the official OpenJDK image as the base image for the runtime
FROM openjdk:17-jdk-alpine

# Set the working directory
WORKDIR /app

# Copy the built JAR file from the build stage
COPY --from=build /app/target/*.jar app.jar


# Expose the application port
EXPOSE 8080

# Run the application
CMD ["java", "-jar", "app.jar"]
