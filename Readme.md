https://github.com/Irma1111/hello-world-spring-boot/actions/runs/6762784283/job/18379156643

# Readme
To-Do-Liste Projekt README
Dies ist das README-Dokument für das To-Do-Liste-Projekt. In diesem Projekt erstelle ich eine Webanwendung zur Verwaltung von To-Do-Einträgen mit Hilfe von Spring Boot und der Java Persistence API (JPA).

Projektidee
Das Hauptziel des Projekts ist es, eine benutzerfreundliche To-Do-Liste zu entwickeln, in der Einträge erstellt, bearbeitet, als erledigt markiert und gelöscht werden können. Die Anwendung wird es Benutzern ermöglichen, ihre täglichen Aufgaben effizient zu organisieren und zu verwalten.

Projektstruktur
Das Projekt ist in verschiedene Pakete unterteilt:

de.htwberlin.webtech: Das Hauptpaket enthält die Backend-Klassen und Controller für To-Do-Einträge.
Task: Die Task-Klasse repräsentiert einen To-Do-Eintrag mit einer Beschreibung und einem Status.
TaskController: Der TaskController enthält Endpunkte zur Verwaltung von To-Do-Einträgen, einschließlich Erstellung, Aktualisierung und Löschung.
TaskService: Diese Klasse enthält die Geschäftslogik für To-Do-Einträge, einschließlich Methoden zur Abfrage von Einträgen und deren Statusänderung.
TaskRepository: Dieses Repository ist für die Datenbankinteraktion verantwortlich und verwendet Spring Data JPA.
Verwendete Technologien
In diesem Projekt werden verschiedene Technologien verwendet, darunter:

Spring Boot: Ein Framework zur Entwicklung von Java-Anwendungen.
Java Persistence API (JPA): Eine API zur Verwaltung von Datenbanken in Java-Anwendungen.
Spring Data JPA: Ein Teil des Spring-Frameworks, der die Datenbankinteraktion vereinfacht.
RESTful Web Services: Die Anwendung bietet RESTful-APIs zur Kommunikation mit dem Frontend.
Installation und Ausführung
Um das Projekt auszuführen, müssen Sie die folgenden Schritte ausführen:

Stellen Sie sicher, dass Sie Java JDK und Maven auf Ihrem System installiert haben.

Klonen Sie dieses Repository auf Ihren Computer. Sie können das Repository unter folgendem Link finden: To-Do-Liste Repository.

Navigieren Sie in das Projektverzeichnis und führen Sie mvn spring-boot:run aus, um die Anwendung zu starten.

Die Anwendung wird auf http://localhost:8080 bereitgestellt, und Sie können auf die Endpunkte über Ihren Webbrowser oder ein REST-Client-Tool zugreifen.

Verwendung der API
Die API bietet folgende Endpunkte:

/api/tasks: Hier können Sie To-Do-Einträge erstellen, aktualisieren, löschen und alle Einträge abrufen.
/api/tasks/{taskId}: Hier können Sie einen bestimmten To-Do-Eintrag abrufen, aktualisieren oder löschen.
/api/tasks/{taskId}/complete: Hier können Sie einen Eintrag als erledigt markieren.
Beispielanfragen
Hier sind einige Beispiele für HTTP-Anfragen an die API:

Erstellen Sie einen neuen To-Do-Eintrag:

css
Copy code
POST /api/tasks
Body:
{
"description": "Einkäufe erledigen"
}
Aktualisieren Sie einen To-Do-Eintrag:

bash
Copy code
PUT /api/tasks/{taskId}
Body:
{
"description": "Einkäufe erledigen (erledigt)",
"completed": true
}
Löschen Sie einen To-Do-Eintrag:

bash
Copy code
DELETE /api/tasks/{taskId}
Markieren Sie einen Eintrag als erledigt:

bash
Copy code
POST /api/tasks/{taskId}/complete
Bitte beachten Sie, dass dies nur Beispiele sind, und Sie können die API entsprechend Ihren Anforderungen verwenden.

Lizenz
Dieses Projekt steht unter der MIT-Lizenz. Weitere Informationen finden Sie in der Lizenzdatei.

Vielen Dank für Ihr Interesse an meinem To-Do-Liste-Projekt! Bei Fragen oder Problemen können Sie sich gerne an mich wenden.