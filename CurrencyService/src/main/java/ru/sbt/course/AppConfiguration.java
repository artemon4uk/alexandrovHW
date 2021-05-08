package ru.sbt.course;

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
    public CurrencyService currencyService(RestTemplateBuilder restTemplateBuilder, CurrencyRepository currencyRepository) {
        return new CurrencyService(restTemplateBuilder, currencyRepository);
    }
}
