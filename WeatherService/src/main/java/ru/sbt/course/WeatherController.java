package ru.sbt.course;

import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.Min;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class WeatherController {
    private final WeatherService weatherService;

    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @GetMapping("/weather")
    public List<Double> getWeatherHistory(@RequestParam @Min(1) int n, @RequestParam @Nullable String city) {
        if (city == null) {
            return weatherService.getHistoryWeather(n).stream()
                    .map(Weather::getAvgTemperature)
                    .collect(Collectors.toList());
        }
        return weatherService.getHistoryWeather(n, city).stream()
                .map(Weather::getAvgTemperature)
                .collect(Collectors.toList());
    }

    @GetMapping("/weatherForecast")
    public double getForecastWeather(@RequestParam @Nullable String city) {
        if (city == null) {
            return weatherService.getForecastWeather().getAvgTemperature();
        }
        return weatherService.getForecastWeather(city).getAvgTemperature();
    }
}
