FROM gradle:7.3.3-jdk11 as build
COPY . /workspace/app
WORKDIR /workspace/app
RUN gradle build

FROM openjdk:11-jdk-alpine
COPY --from=build /workspace/app /workspace/app
WORKDIR /workspace/app
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "build/libs/demo-0.0.1-SNAPSHOT.jar"]
