FROM openjdk:17-jdk-alpine

WORKDIR /app

COPY target/*.jar /app/*.jar

CMD ["java", "-jar", "app-intsolutionss-java-example-0.0.1-SNAPSHOT.jar"]
