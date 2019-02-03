FROM tomcat:9-jre11-slim

MAINTAINER akitafuki

COPY build/libs/RustledBot.war /usr/local/tomcat/webapps

CMD ["catalina.sh", "run"]