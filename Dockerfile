FROM amazoncorretto:11-alpine-jdk
MAINTAINER JCC
COPY target/portfolio-0.0.1-SNAPSHOT.jar jcc.jar
ENTRYPOINT ["java","-jar","/jcc.jar"]