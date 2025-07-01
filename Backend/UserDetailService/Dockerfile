# Build stage with Java 24
FROM openjdk:21-jdk AS build

# Set working directory inside the container
WORKDIR /app

# Copy the Maven wrapper and project files
COPY mvnw .
COPY .mvn .mvn
COPY pom.xml .
COPY src src

# Make mvnw executable
RUN chmod +x mvnw

# Build the application using Maven Wrapper
RUN ./mvnw clean package -DskipTests

# Runtime stage
FROM openjdk:21-jdk

# Set working directory inside the container
WORKDIR /app

# Copy the built JAR file from the build stage
COPY --from=build /app/target/*.jar app.jar

# Expose the port your Spring Boot app runs on
EXPOSE 8080

# Command to run the application
CMD ["java", "-jar", "app.jar"]
