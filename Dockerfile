# Stage 1: Build the application
FROM eclipse-temurin:17-jdk-alpine AS builder

WORKDIR /app/source

COPY mvnw .
COPY .mvn .mvn
COPY pom.xml .
COPY src src

# Build the application and create JAR file
RUN ./mvnw clean package -DskipTests
#we have to skipp the test if we are using mysql and docker compose here

#Stage 2: Create a lightweight production image
FROM eclipse-temurin:17-jdk-alpine



COPY --from=builder /app/source/target/*.jar ./springboot-docker.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "springboot-docker.jar"]


#FROM openjdk:17-jdk-slim
#ADD target/*.jar app.jar
#ENTRYPOINT ["java","-jar","app.jar"]


