package io.github.javafaktura.s01e05.weather.filter.tdd.step7;

public class WeatherCriteria {
    private double minTemp;
    private double maxTemp;

    public WeatherCriteria() {
        this.minTemp = -100.0;
        this.maxTemp = 100.0;
    }

    public WeatherCriteria ofMinTemp(double minTemp) {
        this.minTemp = minTemp;
        return this;
    }

    public double getMinTemp() {
        return minTemp;
    }

    public WeatherCriteria ofMaxTemp(int maxTemp) {
        this.maxTemp = maxTemp;
        return this;
    }

    public double getMaxTemp() {
        return maxTemp;
    }
}
