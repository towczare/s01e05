package io.github.javafaktura.s01e05.weather;

import io.github.javafaktura.s01e05.weather.location.Location;

import java.time.LocalDate;
import java.util.Objects;

public class Weather {
    private LocalDate localDate;
    private Location location;
    private double temp;
    private double wind;
    private int rainfall;

    public Weather(LocalDate localDate, Location location, double temp, double wind, int rainfall) {
        this.localDate = localDate;
        this.location = location;
        this.temp = temp;
        this.wind = wind;
        this.rainfall = rainfall;
    }

    public LocalDate getLocalDate() {
        return localDate;
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
                localDate + " - " + location.getCity() + " / " + location.getCountry() + " \n" +
                " \uD83C\uDF21️ temp = " + temp + " C" + " \n" +
                " \uD83D\uDCA8 wind = " + wind + " km/h" +  " \n" +
                " \uD83C\uDF27️ rainfall = " + rainfall + " mm/day" +  " \n" +
                "----------------\n";
    }

    @Override
    public String toString() {
        return "Weather{" +
                "localDate=" + localDate +
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
                Objects.equals(localDate, weather.localDate) &&
                Objects.equals(location, weather.location);
    }

    @Override
    public int hashCode() {
        return Objects.hash(localDate, location, temp, wind, rainfall);
    }
}
