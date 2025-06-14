FROM maven:3.8.5-openjdk-17 AS builder

WORKDIR /app
COPY . .

RUN mvn dependency:go-offline

COPY src ./src
RUN mvn clean package -DskipTests

RUN ls -la /app/target

FROM openjdk:17

WORKDIR /app

COPY --from=builder /app/target/microservicio.usuarios-0.0.1-SNAPSHOT.jar microservicio-usuarios.jar

EXPOSE 8080
ENTRYPOINT ["java","-jar","microservicio-usuarios.jar"]