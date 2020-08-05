# having openjdk as builder of environment
FROM openjdk:8 as build

# creating a workdirectory on the docker image
WORKDIR /workspace/manual-spring-docker

# copying the maven wrapper into docker image environment
COPY mvnw .

# copying mvn file into docker image environment
COPY .mvn .mvn

# copying pom.xml file into current docker image environment
COPY pom.xml .

# copying src directory from current project into docker image environment
COPY src src

# running maven wrapper with skipping spring boot test
RUN ./mvnw install -DskipTests

# creating a directory fo targ and copying all the target files into targe dependcy directory
RUN mkdir -p target/dependency && (cd target/dependency; jar -xf ../*.jar)

# making openjdk as environment
FROM openjdk:8

# keep a temp volume for the image
VOLUME /tmp

# making an argument for the project target dependency
ARG DEPENDENCY=/workspace/manual-spring-docker/target/dependency

# copying all the spring boot related folders into the docker image environment
COPY --from=build ${DEPENDENCY}/BOOT-INF/lib /manual-spring-docker/lib
COPY --from=build ${DEPENDENCY}/META-INF /manual-spring-docker/META-INF
COPY --from=build ${DEPENDENCY}/BOOT-INF/classes /manual-spring-docker

# first all the classes into docker image environment and then running specific spring boot main java file
ENTRYPOINT ["java","-cp","manual-spring-docker:manual-spring-docker/lib/*","com.dockerization.manualdocker.AumateSpringBootRunByDockerApplication"]