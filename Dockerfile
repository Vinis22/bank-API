FROM maven:3.9.6-eclipse-temurin-21 AS build
WORKDIR /app

COPY pom.xml .
COPY . .

# Build no tests
RUN mvn clean package -DskipTests

FROM openjdk:21-jdk-slim
WORKDIR /app
COPY --from=build /app/target/bank-app-0.0.1-SNAPSHOT.jar /app/
ENTRYPOINT ["java", "-jar", "/app/bank-app-0.0.1-SNAPSHOT.jar"]
