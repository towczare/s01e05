package io.github.javafaktura.s01e05.weather.filter;

public enum KiteType {
    DELTA(9.66, 24.14),
    DIAMOND(9.66, 24.14),
    DRAGON(9.66, 24.14),
    BOX(12.87, 40.23),
    STICKLESS_PARAFOIL(12.87, 40.23);

    private double minWind;
    private double maxWind;

    KiteType(double minWind, double maxWind) {
        this.minWind = minWind;
        this.maxWind = maxWind;
    }

    public WeatherCriteria toWeatherCriteria() {
        return new WeatherCriteria()
                .ofRain(RainCriteria.DRY)
                .ofMinWind(this.minWind)
                .ofMaxWind(this.maxWind);
    }

    public double getMinWind() {
        return minWind;
    }
}