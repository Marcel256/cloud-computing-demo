FROM gradle:7.3.3-jdk8 as build
COPY . /workspace/app
WORKDIR /workspace/app
RUN gradle build

FROM openjdk:8-jdk-alpine
COPY --from=build /workspace/app /workspace/app
WORKDIR /workspace/app
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "build/libs/demo-0.0.1-SNAPSHOT.jar"]
