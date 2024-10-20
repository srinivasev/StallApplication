#FROM openjdk:17-jdk-alpine
FROM eclipse-temurin:17-jdk-alpine
USER 1000
ADD deploy.yaml /tmp/data
ADD pod.yaml /tmp/data
ADD https://www.gutenberg.org/files/11/11-0.txt /tmp/data
COPY target/StallApp-0.0.1-SNAPSHOT.jar StallApp-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/StallApp-0.0.1-SNAPSHOT.jar"]