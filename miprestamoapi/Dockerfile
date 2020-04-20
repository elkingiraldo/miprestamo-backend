FROM openjdk:8-jdk-alpine

MAINTAINER elkin.giraldo.pinedo@gmail.com
VOLUME /tmp
EXPOSE 8080

ADD target/miprestamoapi-0.0.1-SNAPSHOT.jar miprestamoapi.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/miprestamoapi.jar"]