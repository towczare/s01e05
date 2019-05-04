package io.github.javafaktura.s01e05;

import java.time.Instant;

public class WeatherConsumer {

    private final WeatherRepository weatherRepository;
    private final WeatherValidator weatherValidator;

    public WeatherConsumer(WeatherRepository weatherRepository, WeatherValidator weatherValidator) {
        this.weatherRepository = weatherRepository;
        this.weatherValidator = weatherValidator;
    }

    public Instant save(Weather weather) {
        weatherValidator.validate(weather);
        return weatherRepository.save(weather);
    }
}
