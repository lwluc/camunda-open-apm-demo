FROM  maven:3-jdk-8 as build
WORKDIR /app
COPY . /app
RUN mvn clean package -B

ADD https://github.com/jwilder/dockerize/releases/download/v0.6.1/dockerize-alpine-linux-amd64-v0.6.1.tar.gz dockerize.tar.gz
RUN tar xzf dockerize.tar.gz
RUN chmod +x dockerize

ENTRYPOINT ["sh", "./entrypoint.sh"]