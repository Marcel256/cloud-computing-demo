FROM openjdk:8-jdk-alpine
WORKDIR /workspace/app

COPY . /workspace/app
RUN --target=/root/.gradle ./gradlew clean build
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "build/libs/demo-0.0.1-SNAPSHOT.jar"]
