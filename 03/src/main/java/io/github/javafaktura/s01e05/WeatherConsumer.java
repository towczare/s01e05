package io.github.javafaktura.s01e05;

public class WeatherConsumer {

    private final WeatherValidator weatherValidator;

    public WeatherConsumer(WeatherValidator weatherValidator) {
        this.weatherValidator = weatherValidator;
    }

    public void save(Weather weather) {
        weatherValidator.validate(weather);
        /** Logic omitted to simplify this example **/
    }
}
