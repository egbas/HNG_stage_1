FROM openjdk:21
COPY target/demo-hng-0.0.1-SNAPSHOT.jar demo-hng.jar
ENTRYPOINT ["java", "-jar", "/demo-hng.jar"]
EXPOSE 8080