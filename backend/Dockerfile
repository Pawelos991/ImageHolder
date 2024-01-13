FROM openjdk:17
WORKDIR /app
COPY imageHolder.jar /app/imageHolder.jar
COPY config/application.properties /app/config/application.properties
ENTRYPOINT ["java", "-jar", "/app/imageHolder.jar"]
