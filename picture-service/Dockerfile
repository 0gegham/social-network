FROM maven:3.6.0-jdk-11-slim AS build
COPY src /home/app/src
COPY pom.xml /home/app
RUN mvn -f /home/app/pom.xml clean install -DskipTests=true


FROM openjdk:11-jre-slim
COPY --from=build /home/app/target/picture-service-*.jar /usr/local/lib/picture.jar
EXPOSE 8085
ENTRYPOINT ["java","-jar","/usr/local/lib/picture.jar"]