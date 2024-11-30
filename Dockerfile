# Usa l'immagine base di Java
FROM openjdk:17-jdk-slim

# Imposta la directory di lavoro
WORKDIR /app

# Copia il file JAR nella directory di lavoro
COPY target/menu-service-0.0.1-SNAPSHOT.jar app.jar

# Espone la nuova porta (cambia da 8080 a 8081)
EXPOSE 8081

# Comando per eseguire il JAR
ENTRYPOINT ["java", "-jar", "-Dserver.port=8081", "app.jar"]