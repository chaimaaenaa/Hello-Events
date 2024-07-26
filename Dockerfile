FROM openjdk:21
EXPOSE 8081
ADD /target/hello-events.jar hello-events.jar
ENTRYPOINT ["java", "-jar", "hello-events.jar"]
