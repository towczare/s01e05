package io.github.javafaktura.s01e05.weather.filter.tdd.step5;

public class WeatherCriteria {
    private double minTemp;

    public WeatherCriteria() {
        this.minTemp = -100.0;
    }

    public WeatherCriteria ofMinTemp(double minTemp) {
        this.minTemp = minTemp;
        return this;
    }

    public double getMinTemp() {
        return minTemp;
    }
}
