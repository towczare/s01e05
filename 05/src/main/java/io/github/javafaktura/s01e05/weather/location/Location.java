package io.github.javafaktura.s01e05.weather.location;

import java.util.Objects;

public class Location {
    private String city;
    private String country;

    public Location(String city, String country) {
        this.city = city;
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public String getCountry() {
        return country;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Location)) return false;
        Location that = (Location) o;
        return Objects.equals(city, that.city) &&
                Objects.equals(country, that.country);
    }

    @Override
    public int hashCode() {
        return Objects.hash(city, country);
    }

    @Override
    public String toString() {
        return "City: " + city + " Country: " + country + " ";
    }

    public int compareTo(Location location) {
        return (location.getCountry() + " " + location.getCity())
                .compareTo(this.getCountry() + " " + this.getCity());
    }
}
