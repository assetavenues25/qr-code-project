# ------------ Build Stage ------------
FROM openjdk:24-jdk AS build

WORKDIR /app

COPY mvnw .
COPY .mvn .mvn
COPY pom.xml .
RUN ./mvnw dependency:go-offline -B  # Pre-fetch dependencies

COPY src src
RUN chmod +x mvnw
RUN ./mvnw clean package -DskipTests

# ------------ Runtime Stage ------------
FROM eclipse-temurin:24-jdk-alpine  # Lighter final image

WORKDIR /app

COPY --from=build /app/target/*.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]
