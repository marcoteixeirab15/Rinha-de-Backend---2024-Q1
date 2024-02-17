FROM eclipse-temurin:21.0.2_13-jdk-alpine

LABEL description="Rinha"
LABEL version="1.0"

RUN apk update && \
    apk add --no-cache curl

WORKDIR /app
COPY target/rinha-backend-0.0.1-SNAPSHOT.jar ./
EXPOSE $PORT
ENTRYPOINT java --enable-preview -server -XX:+UseNUMA -XX:+UseZGC -Dconfig.http.listenAddresses=$HOSTNAME:$PORT -Dio.netty.buffer.checkBounds=false -Dio.netty.buffer.checkAccessible=false -jar rinha-backend-0.0.1-SNAPSHOT.jar