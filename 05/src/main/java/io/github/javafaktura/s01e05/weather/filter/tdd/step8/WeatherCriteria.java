package io.github.javafaktura.s01e05.weather.filter.tdd.step8;

public class WeatherCriteria {
    private double minTemp;
    private double maxTemp;
    private RainCriteria rainCriteria;

    public WeatherCriteria() {
        this.minTemp = -100.0;
        this.maxTemp = 100.0;
        this.rainCriteria = RainCriteria.WHO_CARES;
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
}
