FROM openjdk:21
COPY target/*.jar demo-hng-0.0.1-SNAPSHOT.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/demo-hng-0.0.1-SNAPSHOT.jar"]