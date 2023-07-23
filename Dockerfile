FROM amazoncorretto:17-alpine-jdk
MAINTAINER franciscoderamo
COPY target/portfolio-0.0.1-SNAPSHOT.jar app-franciscoderamo.jar
ENTRYPOINT ["java","-jar","/app-franciscoderamo.jar"]