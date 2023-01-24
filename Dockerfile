
FROM openjdk:19
COPY /target/Portfolio-0.0.1-SNAPSHOT.jar jcc.jar
ENTRYPOINT ["java","-jar","/jcc.jar"]