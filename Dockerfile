# Etapa de build: Usa Maven para compilar el JAR
FROM maven:3.9.6-eclipse-temurin-17 AS build
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests  # Compila el JAR, salta tests para velocidad

# Etapa de runtime: Usa OpenJDK 17 para ejecutar el JAR
FROM eclipse-temurin:17-jre
VOLUME /tmp
WORKDIR /app
COPY --from=build /app/target/*.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]
EXPOSE 8080