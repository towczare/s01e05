package io.github.javafaktura.s01e05;

public class WeatherConsumer {

    private final WeatherRepository weatherRepository;

    public WeatherConsumer(WeatherRepository weatherRepository) {
        this.weatherRepository = weatherRepository;
    }

    public String save(Weather weather) {
        return weatherRepository.save(weather);
    }
}
