FROM  maven:3-jdk-8 as build
COPY src /usr/src/app/src
COPY pom.xml /usr/src/app
COPY entrypoint.sh /usr/src/app
RUN mvn -f /usr/src/app/pom.xml clean package -B

FROM openjdk:8
COPY --from=build /usr/src/app/target/external-service-0.0.1-SNAPSHOT.jar /usr/app/application.jar
COPY --from=build /usr/src/app/entrypoint.sh /usr/app/entrypoint.sh

ADD https://github.com/jwilder/dockerize/releases/download/v0.6.1/dockerize-alpine-linux-amd64-v0.6.1.tar.gz dockerize.tar.gz
RUN tar xzf dockerize.tar.gz
RUN chmod +x dockerize

ADD https://github.com/inspectIT/inspectit-ocelot/releases/download/2.0.0/inspectit-ocelot-agent-2.0.0.jar inspectit-ocelot-agent.jar

EXPOSE 7788
ENTRYPOINT ["sh", "./entrypoint.sh"]