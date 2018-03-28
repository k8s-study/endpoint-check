FROM java:8-alpine
MAINTAINER Your Name <you@example.com>

ADD target/uberjar/ping-check-clj.jar /ping-check-clj/app.jar

EXPOSE 3000

CMD ["java", "-jar", "/ping-check-clj/app.jar"]
