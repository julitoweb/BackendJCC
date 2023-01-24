FROM amazoncorretto:8-alpine-jdk
COPY /target/portfolio-0.0.1-SNAPSHOT.jar jcc.jar
ENTRYPOINT ["java","-jar","/jcc.jar"]