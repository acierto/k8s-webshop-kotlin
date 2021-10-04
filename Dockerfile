FROM gradle:7.2-jdk11-hotspot AS build
RUN mkdir /webshop-build
COPY . /webshop-build
WORKDIR /webshop-build
RUN gradle build --no-daemon -x test

FROM adoptopenjdk/openjdk11
RUN mkdir /webshop
COPY --from=build /webshop-build/webshop-server/build/libs/webshop-server-0.0.1-SNAPSHOT.jar /webshop/webshop-server.jar
WORKDIR /webshop
CMD ["java", "-jar", "webshop-server.jar"]
