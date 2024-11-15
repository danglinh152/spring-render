FROM ubuntu:latest AS build
RUN apt-get update
RUN apt-get install -y maven openjdk-17-jdk
COPY . .
RUN mvn clean package -DskipTests

FROM openjdk:17-jdk-slim
EXPOSE 8080
COPY --from=build /target/demo-1.jar app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]
