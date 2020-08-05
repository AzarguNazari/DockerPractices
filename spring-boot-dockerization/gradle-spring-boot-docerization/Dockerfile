FROM openjdk:8 as build
RUN apt-get update
RUN apt-get install -y maven
WORKDIR /workspace/spring-boot
COPY build.gradle build.gradle
COPY settings.gradle settings.gradle
COPY gradlew gradlew
COPY gradlew.bat gradlew.bat
COPY gradle gradle
COPY src src
RUN ./gradlew build -x test
ENTRYPOINT ["java","-jar","build/libs/gradle-spring-boot-docerization-0.0.1-SNAPSHOT.jar"]