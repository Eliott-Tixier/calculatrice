# Utiliser l'image officielle OpenJDK 17 comme image de base
FROM openjdk:17-jdk-slim

# Créer un répertoire /app dans le conteneur pour notre application
WORKDIR /app

# Copier le fichier JAR de l'application dans le conteneur
COPY target/calculator-backend-0.0.1-SNAPSHOT.jar app.jar

# Exposer le port sur lequel l'application s'exécute
EXPOSE 8080

# Attendre que la base de données soit prête avant de démarrer l'application
CMD java -jar app.jar
