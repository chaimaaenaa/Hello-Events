FROM openjdk:21
EXPOSE 8080
ADD /target/hello-events-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]
