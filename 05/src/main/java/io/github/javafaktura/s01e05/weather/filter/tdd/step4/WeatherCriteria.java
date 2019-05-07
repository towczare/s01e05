package io.github.javafaktura.s01e05.weather.filter.tdd.step4;

public class WeatherCriteria {
    private double minTemp;

    public WeatherCriteria() {
    }

    public WeatherCriteria(double minTemp) {
        this.minTemp = minTemp;
    }

    public double getMinTemp() {
        return minTemp;
    }
}
