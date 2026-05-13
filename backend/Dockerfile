# 构建阶段：使用 Maven 构建 Spring Boot 应用
FROM maven:3.9.8-eclipse-temurin-17 AS build
WORKDIR /workspace
COPY . /workspace
RUN mvn -B -DskipTests package

# 运行阶段：使用轻量 JRE 运行构建结果
FROM eclipse-temurin:17-jre
WORKDIR /app
COPY --from=build /workspace/target/backend-0.0.1-SNAPSHOT.jar /app/app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
