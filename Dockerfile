FROM maven:3.9.9-eclipse-temurin-23 AS build
COPY . .
RUN mvn clean package -DskipTests
FROM eclipse-temurin:8u432-b06-jre-ubi9-minimal
COPY --from=build /target/*.jar demo.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "demo.jar"]
