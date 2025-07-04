FROM ubuntu:latest AS build

RUN apt-get update && apt-get install -y openjdk-17-jdk maven curl unzip git

WORKDIR /app
COPY . .

RUN chmod +x ./mvnw
RUN ./mvnw clean package -DskipTests

# ===============================
FROM openjdk:17-jdk-slim
WORKDIR /app

EXPOSE 8080
COPY --from=build /app/target/demo-1.jar app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]
