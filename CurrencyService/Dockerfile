FROM openjdk:8-jdk-alpine
RUN mkdir currencyservice
COPY target/currencyservice-1.0.0.jar /currencyservice
WORKDIR /currencyservice
CMD ["java", "-jar", "currencyservice-1.0.0.jar"]