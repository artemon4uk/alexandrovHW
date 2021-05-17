FROM openjdk:8-jdk-alpine
RUN mkdir predictservice
COPY target/predictservice-1.0.0.jar /predictservice
WORKDIR /predictservice
CMD ["java", "-jar", "predictservice-1.0.0.jar"]