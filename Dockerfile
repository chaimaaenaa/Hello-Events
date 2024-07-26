FROM openjdk:21
<<<<<<< HEAD
LABEL authors="user"
EXPOSE 8081
ADD /target/hello-events.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]
=======
EXPOSE 8081
ADD /target/hello-events.jar hello-events.jar
ENTRYPOINT ["java", "-jar", "hello-events.jar"]
>>>>>>> b910883d9e05197a4aa3be389112fa8eddfb5cc5
