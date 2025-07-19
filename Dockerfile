# 베이스 이미지 (Java 17 사용)
FROM openjdk:17-jdk-alpine

# JAR 파일 복사
ARG JAR_FILE=build/libs/demo-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} app.jar

# 실행 명령
ENTRYPOINT ["java","-jar","/app.jar"]