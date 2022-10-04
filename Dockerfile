FROM openjdk:17-alpine
ADD target/troquinhas-0.0.1-SNAPSHOT.jar troquinhas-0.0.1-SNAPSHOT.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "troquinhas-0.0.1-SNAPSHOT.jar"]