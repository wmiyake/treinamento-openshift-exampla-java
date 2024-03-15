FROM registry.access.redhat.com/ubi8/openjdk-17

WORKDIR /app

COPY target/app-intsolutionss-java-example-0.0.1-SNAPSHOT.jar /app/

CMD ["java", "-jar", "/app/app-intsolutionss-java-example-0.0.1-SNAPSHOT.jar"]