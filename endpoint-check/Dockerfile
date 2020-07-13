FROM openjdk:8-alpine

COPY target/uberjar/endpoint-check.jar /endpoint-check/app.jar

EXPOSE 3000

CMD ["java", "-jar", "/endpoint-check/app.jar"]
