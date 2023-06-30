FROM amazoncorretto:17-alpine3.17
COPY build/libs/SB-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]