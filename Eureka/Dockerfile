FROM openjdk:8-jdk-alpine
RUN mkdir eurekaserver
COPY target/eureka-1.0.0.jar /eurekaserver
WORKDIR /eurekaserver
CMD ["java", "-jar", "eureka-1.0.0.jar"]