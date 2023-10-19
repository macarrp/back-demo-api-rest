FROM eclipse-temurin:17-jdk-alpine
VOLUME /tmp
COPY target/*.jar demo-api-rest.jar
ENTRYPOINT ["java","-jar","/demo-api-rest.jar"]
EXPOSE 8080