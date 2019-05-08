package io.github.javafaktura.s01e05.weather;

import io.github.javafaktura.s01e05.weather.location.Location;

import java.time.LocalDate;
import java.util.Objects;

public class Weather {
    private LocalDate forecastDate;
    private Location location;
    private double temp;
    private double wind;
    private int rainfall;

    public Weather(LocalDate forecastDate, Location location, double temp, double wind, int rainfall) {
        this.forecastDate = forecastDate;
        this.location = location;
        this.temp = temp;
        this.wind = wind;
        this.rainfall = rainfall;
    }

    public LocalDate getForecastDate() {
        return forecastDate;
    }

    public Location getLocation() {
        return location;
    }

    public double getTemp() {
        return temp;
    }

    public double getWind() {
        return wind;
    }

    public int getRainfall() {
        return rainfall;
    }


    public String prettyLog() {
        return "\n --------------" + " \n" +
                forecastDate + " - " + location.getCity() + " / " + location.getCountry() + " \n" +
                " \uD83C\uDF21️ temp = " + temp + " C" + " \n" +
                " \uD83D\uDCA8 wind = " + wind + " km/h" +  " \n" +
                " \uD83C\uDF27️ rainfall = " + rainfall + " mm/day" +  " \n" +
                "----------------\n";
    }

    @Override
    public String toString() {
        return "Weather{" +
                "forecastDate=" + forecastDate +
                ", location=" + location +
                ", temp=" + temp +
                ", wind=" + wind +
                ", rainfall=" + rainfall +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Weather)) return false;
        Weather weather = (Weather) o;
        return Double.compare(weather.temp, temp) == 0 &&
                Double.compare(weather.wind, wind) == 0 &&
                rainfall == weather.rainfall &&
                Objects.equals(forecastDate, weather.forecastDate) &&
                Objects.equals(location, weather.location);
    }

    @Override
    public int hashCode() {
        return Objects.hash(forecastDate, location, temp, wind, rainfall);
    }
}
