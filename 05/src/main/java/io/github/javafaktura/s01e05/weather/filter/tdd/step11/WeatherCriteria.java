package io.github.javafaktura.s01e05.weather.filter.tdd.step11;

import io.github.javafaktura.s01e05.weather.Weather;

import java.util.function.Predicate;

public class WeatherCriteria {
    private double minTemp;
    private double maxTemp;
    private RainCriteria rainCriteria;
    private double minWind;
    private double maxWind;

    public WeatherCriteria() {
        this.minTemp = -100.0;
        this.maxTemp = 100.0;
        this.rainCriteria = RainCriteria.WHO_CARES;
        this.minWind = 0.00;
        this.maxWind = 100.00;
    }

    public WeatherCriteria ofMinTemp(double minTemp) {
        this.minTemp = minTemp;
        return this;
    }

    public WeatherCriteria ofMaxTemp(int maxTemp) {
        this.maxTemp = maxTemp;
        return this;
    }

    public WeatherCriteria ofRain(RainCriteria rain) {
        this.rainCriteria = rain;
        return this;
    }

    public WeatherCriteria ofMinWind(double minWind) {
        this.minWind = minWind;
        return this;
    }

    public WeatherCriteria ofMaxWind(double maxWind) {
        this.maxWind = maxWind;
        return this;
    }

    private Predicate<Weather> getMaxTemp() {
        return w -> w.getTemp() <= maxTemp;
    }

    private Predicate<Weather> getMinTemp() {
        return w -> w.getTemp() >= minTemp;
    }

    private Predicate<Weather> getMaxWind() {
        return w -> w.getWind() <= maxWind;
    }

    private Predicate<Weather> getMinWind() {
        return w -> w.getWind() >= minWind;
    }

    private Predicate<Weather> getRainCriteria() {
        switch (rainCriteria) {
            case WET:
                return w -> w.getRainfall() > 0.00;
            case DRY:
                return w -> w.getRainfall() == 0.00;
            case WHO_CARES:
                return w -> true;
        }
        return w -> true;
    }

    public Predicate<? super Weather> toWeatherPredicate() {
        return getMaxTemp()
                .and(getMinTemp())
                .and(getRainCriteria())
                .and(getMinWind())
                .and(getMaxWind());
    }
}
