package io.github.javafaktura.s01e05;

import java.util.Objects;

class Weather {
    final double temp;
    final double wind;
    final double rainfall;

    Weather(double temp, double wind, double rainfall) {
        this.temp = temp;
        this.wind = wind;
        this.rainfall = rainfall;
    }

    public double getTemp() {
        return temp;
    }

    public double getWind() {
        return wind;
    }

    public double getRainfall() {
        return rainfall;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Weather)) return false;
        Weather weather = (Weather) o;
        return Double.compare(weather.temp, temp) == 0 &&
                Double.compare(weather.wind, wind) == 0 &&
                Double.compare(weather.rainfall, rainfall) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(temp, wind, rainfall);
    }

    @Override
    public String toString() {
        return "Weather{" +
                "temp=" + temp +
                ", wind=" + wind +
                ", rainfall=" + rainfall +
                '}';
    }
}
