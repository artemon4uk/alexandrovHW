FROM openjdk:8-jdk-alpine
RUN mkdir weatherservice
COPY target/weatherservice-1.0.0.jar /weatherservice
WORKDIR /weatherservice
CMD ["java", "-jar", "weatherservice-1.0.0.jar"]