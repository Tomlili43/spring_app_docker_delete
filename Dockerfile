# syntax=docker/dockerfile:1

# FROM eclipse-temurin:17-jdk-jammy
# FROM eclipse-temurin:8u372-b07-jre-jammy
# use jdk 8
FROM openjdk:8-jdk-alpine
WORKDIR /app


COPY .mvn/ .mvn
COPY mvnw pom.xml ./
RUN ./mvnw dependency:resolve

COPY src ./src

CMD ["./mvnw", "spring-boot:run"]