FROM gradle:6.3.0-jdk13 as gradle-build

WORKDIR /app

USER root

COPY build.gradle /app
COPY src /app/src

RUN gradle war --no-daemon --stacktrace

FROM tomcat:9-jdk13-openjdk-oracle

MAINTAINER akitafuki

RUN rm -rf /usr/local/tomcat/webapps/*

COPY --from=gradle-build /app/build/libs/ROOT.war /usr/local/tomcat/webapps

CMD ["catalina.sh", "run"]