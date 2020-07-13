FROM java:8-alpine
MAINTAINER Your Name <you@example.com>

ADD target/uberjar/endpoint-check.jar /endpoint-check/app.jar

EXPOSE 3000

CMD ["java", "-jar", "/endpoint-check/app.jar"]
