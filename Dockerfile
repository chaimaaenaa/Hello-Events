FROM openjdk:21
LABEL authors="user"
EXPOSE 8081
ADD /target/hello-events.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]

