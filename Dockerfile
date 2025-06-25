FROM openjdk:21-jdk-slim
VOLUME /tmp
COPY docker-app.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
