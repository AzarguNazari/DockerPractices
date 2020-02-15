FROM openjdk:8 as build
WORKDIR /workspace/manual-spring-docker

COPY mvnw .
COPY .mvn .mvn
COPY pom.xml .
COPY src src

RUN ./mvnw install -DskipTests
RUN mkdir -p target/dependency && (cd target/dependency; jar -xf ../*.jar)

FROM openjdk:8
VOLUME /tmp
ARG DEPENDENCY=/workspace/manual-spring-docker/target/dependency
COPY --from=build ${DEPENDENCY}/BOOT-INF/lib /manual-spring-docker/lib
COPY --from=build ${DEPENDENCY}/META-INF /manual-spring-docker/META-INF
COPY --from=build ${DEPENDENCY}/BOOT-INF/classes /manual-spring-docker
ENTRYPOINT ["java","-cp","manual-spring-docker:manual-spring-docker/lib/*","com.dockerization.manualdocker.AumateSpringBootRunByDockerApplication"]