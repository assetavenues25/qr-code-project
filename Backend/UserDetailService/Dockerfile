# Use official OpenJDK image as the base image
FROM openjdk:17-jdk-slim

# Set working directory inside the container
WORKDIR /app

# Install Maven (required to build the project)
RUN apt-get update && apt-get install -y maven

# Copy the Maven build files and source code
COPY pom.xml .
COPY mvnw .
COPY .mvn .mvn
COPY src src

# Build the application using Maven
RUN mvn clean package -DskipTests

# Copy the built JAR file to the container
COPY target/*.jar app.jar

# Expose the port your Spring Boot app runs on
EXPOSE 10000

# Command to run the application
CMD ["java", "-jar", "app.jar"]
