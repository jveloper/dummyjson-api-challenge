FROM openjdk:17-slim
EXPOSE 8081
ADD /target/thortful-code-challenge-0.0.1-SNAPSHOT.jar thortful-code-challenge-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-Xms256m","-Xmx1024m","-jar","thortful-code-challenge-0.0.1-SNAPSHOT.jar"]