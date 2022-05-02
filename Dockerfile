FROM maven:3.8.1-openjdk-8-slim AS builder
RUN mkdir -p /FileGenerator
WORKDIR /FileGenerator
COPY pom.xml /FileGenerator
COPY src /FileGenerator/src
RUN mvn clean install
CMD java -jar target/FileGenerator-1.0-SNAPSHOT.jar