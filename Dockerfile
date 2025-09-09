# Bước 1: Build project bằng Maven
FROM maven:3.9.6-eclipse-temurin-17 AS build
WORKDIR /app

# Copy file pom.xml và tải dependencies
COPY pom.xml .
RUN mvn dependency:go-offline -B

# Copy toàn bộ source code và build
COPY src ./src
RUN mvn clean package -DskipTests

# Bước 2: Tạo image để chạy ứng dụng
FROM eclipse-temurin:17-jdk-alpine
WORKDIR /app

# Copy file jar từ bước build
COPY --from=build /app/target/shoplaptopservice-0.0.1-SNAPSHOT.jar app.jar

# Expose cổng (Render sẽ tự mapping, thường dùng 8080)
EXPOSE 8080

# Lệnh chạy ứng dụng
ENTRYPOINT ["java", "-jar", "app.jar"]
