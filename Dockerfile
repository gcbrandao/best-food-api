FROM maven:3.5.2-jdk-8-alpine as builder
COPY . /usr/src/mymaven
VOLUME m2_data:/root/.m2/
WORKDIR /usr/src/mymaven
RUN mvn clean install -f /usr/src/mymaven && mkdir /usr/src/wars/
RUN find /usr/src/mymaven/ -iname '*.war' -exec cp {} /usr/src/wars/ \;


FROM tomcat:9.0-jre8-alpine
COPY --from=builder /usr/src/wars/* /usr/local/tomcat/webapps/
COPY tomcat-users.xml $CATALINA_HOME/conf/