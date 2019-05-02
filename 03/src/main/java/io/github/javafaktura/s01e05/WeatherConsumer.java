package io.github.javafaktura.s01e05;

public class WeatherConsumer {

    private final WeatherRepository weatherRepository;
    private final WeatherValidator weatherValidator;

    public WeatherConsumer(WeatherRepository weatherRepository, WeatherValidator weatherValidator) {
        this.weatherRepository = weatherRepository;
        this.weatherValidator = weatherValidator;
    }

    public String save(Weather weather) {
        weatherValidator.validate(weather);
        return weatherRepository.save(weather);
    }
}
