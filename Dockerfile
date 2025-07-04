# Utilise une image Java 17
FROM openjdk:17-jdk-slim

# Dossier de travail dans le conteneur
WORKDIR /app

# Copier le JAR
COPY target/enaaSkills.jar app.jar

# Commande pour exécuter l'application
ENTRYPOINT ["java", "-jar", "app.jar"]


