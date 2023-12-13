FROM gradle:8.5.0-jdk21-alpine as gradle-build

WORKDIR /app

USER root

COPY build.gradle /app
COPY src /app/src

RUN gradle bootWar --no-daemon --stacktrace

FROM tomcat:11.0-jdk21

LABEL maintainer="akitafuki"

RUN rm -rf /usr/local/tomcat/webapps/*

COPY --from=gradle-build /app/build/libs/ROOT.war /usr/local/tomcat/webapps

CMD ["catalina.sh", "run"]
