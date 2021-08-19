FROM maven:3.6.0-jdk-11-slim AS build
COPY src /home/app/src
COPY pom.xml /home/app
RUN mvn -f /home/app/pom.xml clean install -DskipTests=true


FROM openjdk:11-jre-slim
COPY --from=build /home/app/target/conversations-service-*.jar /usr/local/lib/conversations.jar
EXPOSE 8083
ENTRYPOINT ["java","-jar","/usr/local/lib/conversations.jar"]