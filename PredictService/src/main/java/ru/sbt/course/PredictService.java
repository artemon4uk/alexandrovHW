package ru.sbt.course;

import org.apache.commons.math3.stat.regression.SimpleRegression;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;


public class PredictService {
    private static final int N_DAYS = 7;

    private static final String weatherURL = "http://weatherservice:9001/weather?n=" + N_DAYS;
    private static final String currencyURL = "http://currencyservice:9002/currency?n=" + N_DAYS;
    private static final String weatherForecastURL = "http://weatherservice:9001/weatherForecast";

    private final RestTemplate restTemplate;
    private SimpleRegression simpleRegression;

    public PredictService(RestTemplateBuilder restTemplateBuilder) {
        restTemplate = restTemplateBuilder.build();
    }

    public void fit() {
        ResponseEntity<double[]> weatherResponseEntity = restTemplate.getForEntity(weatherURL, double[].class);
        ResponseEntity<double[]> currencyResponseEntity = restTemplate.getForEntity(currencyURL, double[].class);
        if (this.simpleRegression == null) {
            this.simpleRegression = new SimpleRegression();
            for (int i = 0; i < N_DAYS; ++i) {
                simpleRegression.addData(weatherResponseEntity.getBody()[i], currencyResponseEntity.getBody()[i]);
            }
        }
    }

    public double predict() {
        ResponseEntity<Double> weatherForecastResponse = restTemplate.getForEntity(weatherForecastURL, Double.class);
        return predictCurrency(weatherForecastResponse.getBody());
    }

    private double predictCurrency(Double value) {
        return simpleRegression.predict(value);
    }
}
