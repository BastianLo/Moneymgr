FROM openjdk:17-jdk-slim as builder

WORKDIR /app

COPY . .

RUN ./gradlew build

RUN rm build/libs/*plain*
RUN mv build/libs/*.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]
