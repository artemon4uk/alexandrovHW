package ru.sbt.course;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppConfiguration {
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean
    public WeatherService weatherService(RestTemplateBuilder restTemplateBuilder,
                                         ObjectMapper mapper,
                                         WeatherRepository weatherRepository) {
        return new WeatherService(restTemplateBuilder, mapper, weatherRepository);
    }
}
