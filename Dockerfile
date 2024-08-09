FROM openjdk:8-jdk-alpine
RUN addgroup -S spring && adduser -S spring -G spring
USER spring:spring
ARG WAR_FILE=target/*.war
COPY ${WAR_FILE} .war
ENTRYPOINT ["java","-jar","/api-uber-chargers-1.0.0.war"]