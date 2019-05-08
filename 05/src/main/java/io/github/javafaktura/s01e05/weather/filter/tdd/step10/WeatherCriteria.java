package io.github.javafaktura.s01e05.weather.filter.tdd.step10;

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

    public RainCriteria getRainCriteria() {
        return rainCriteria;
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
}
