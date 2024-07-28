FROM openjdk:17-jdk-alpine

WORKDIR /app

COPY target/prs-0.0.1-SNAPSHOT.jar /app/prs-0.0.1-SNAPSHOT.jar

ENTRYPOINT ["java", "-jar", "/app/prs-0.0.1-SNAPSHOT.jar"]

