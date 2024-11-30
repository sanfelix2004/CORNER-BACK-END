FROM openjdk:17-jdk-slim

WORKDIR /app

# Copia il file JAR nella directory di lavoro
COPY target/menu-service-0.0.1-SNAPSHOT.jar app.jar

# Espone la porta
EXPOSE 8081

# Comando per eseguire il JAR
ENTRYPOINT ["java", "-jar", "-Dserver.port=8081", "app.jar"]