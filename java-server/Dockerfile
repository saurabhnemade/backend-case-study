FROM openjdk:11 as build

WORKDIR /home/java-server

COPY src ./src
COPY pom.xml ./
COPY start-server.sh ./
COPY mvnw ./mvnw
COPY mvnw.cmd ./
COPY .mvn ./.mvn

RUN cd /home/java-server
RUN ls -lrt
RUN ./mvnw clean install

FROM openjdk:11

USER 1000
WORKDIR /usr/app

COPY --from=build /home/java-server/target/ ./target/
COPY --from=build /home/java-server/start-server.sh ./

CMD ["bash","start-server.sh"]