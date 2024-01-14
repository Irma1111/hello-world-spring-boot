# Stage 1: Gradle build
FROM gradle:7.4.1-jdk17 AS build

# Arbeitsverzeichnis im Docker-Container festlegen
WORKDIR /app

# Kopieren Sie die Gradle-Konfigurationsdateien zuerst, um die Cache-Schicht besser nutzen zu können
COPY build.gradle settings.gradle ./

# Kopieren Sie die Projektdateien
COPY src ./src

# Bauen Sie das Projekt mit Gradle
RUN gradle build --no-daemon

# Stage 2: Erstellen des Docker-Images mit dem JRE und der gebauten Anwendung
FROM openjdk:17-slim

WORKDIR /app

# Kopieren der gebauten Anwendung aus der vorherigen Stage
COPY --from=build /app/build/libs/*.jar app.jar

# Setzen des Port, auf dem die Anwendung läuft
EXPOSE 8080

# Starten der Spring Boot-Anwendung, wenn der Container gestartet wird
ENTRYPOINT ["java","-jar","app.jar"]
