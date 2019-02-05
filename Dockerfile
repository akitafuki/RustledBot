FROM gradle:5.1.1-jre11-slim as gradle-build

WORKDIR /app

USER root

COPY build.gradle /app
COPY src /app/src

RUN gradle war --no-daemon --stacktrace

FROM tomcat:9-jre11-slim

MAINTAINER akitafuki

COPY --from=gradle-build /app/build/libs/RustledBot.war /usr/local/tomcat/webapps

CMD ["catalina.sh", "run"]