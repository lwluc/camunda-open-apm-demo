FROM gradle:7.1.0-jdk11 AS build
COPY --chown=gradle:gradle . /usr/src/app
WORKDIR /usr/src/app
RUN gradle build --no-daemon 

FROM openjdk:11-jre-slim

RUN mkdir /app

COPY --from=build /usr/src/app/entrypoint.sh /usr/app/entrypoint.sh
COPY --from=build /usr/src/app/build/libs/micronaut-client-0.1-all.jar /usr/app/application.jar

ADD https://github.com/jwilder/dockerize/releases/download/v0.6.1/dockerize-alpine-linux-amd64-v0.6.1.tar.gz dockerize.tar.gz
RUN tar xzf dockerize.tar.gz
RUN chmod +x dockerize

ADD https://github.com/inspectIT/inspectit-ocelot/releases/download/2.0.0/inspectit-ocelot-agent-2.0.0.jar inspectit-ocelot-agent.jar

ENTRYPOINT ["sh", "./entrypoint.sh"]