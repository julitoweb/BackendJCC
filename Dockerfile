
FROM openjdk:11
COPY /target/portfolio-0.0.1-SNAPSHOT.jar jcc.jar
ENTRYPOINT ["java","-jar","/jcc.jar"]