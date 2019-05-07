package io.github.javafaktura.s01e05.filter.tdd.step7;

import io.github.javafaktura.s01e05.weather.Weather;
import io.github.javafaktura.s01e05.weather.filter.tdd.step7.WeatherCriteria;
import io.github.javafaktura.s01e05.weather.filter.tdd.step7.WeatherLocationFilter;
import io.github.javafaktura.s01e05.weather.location.Location;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.Clock;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;

public class WeatherLocationFilterTest {

    Clock fixedClock =
            Clock.fixed(
                    Instant.parse("2020-01-01T00:00:00.00Z"),
                    ZoneId.of("Asia/Calcutta")
            );

    WeatherLocationFilter filter = new WeatherLocationFilter();

    @Test
    @DisplayName("When criteria are not defined filter should return input prediction weather list")
    void whenCriteriaObjectIsNotDefinedFilterShouldReturnWholePredictionList() {
        WeatherCriteria emptyCriteria = new WeatherCriteria();
        List<Weather> input = List.of(
            new Weather(LocalDate.now(fixedClock), new Location("Zgierz", "Poland"), 0, 0, 50),
            new Weather(LocalDate.now(fixedClock), new Location("Pabianice", "Poland"), -10, 10, 20),
            new Weather(LocalDate.now(fixedClock), new Location("Sieradz", "Poland"), 25, 30, 10)
        );

        Assertions.assertEquals(input, filter.filter(emptyCriteria, input));
    }

    @Test
    @DisplayName("When minimal temp is defined 25, filter should return 2 weather predictions")
    void whenMinimalTemp25IsDefinedInCriteriaFilterFilterShouldReturn2WeatherPreditions() {
        WeatherCriteria minTemp25 = new WeatherCriteria().ofMinTemp(25);
        List<Weather> input = List.of(
                new Weather(LocalDate.now(fixedClock), new Location("Zgierz", "Poland"), 0, 0, 50),
                new Weather(LocalDate.now(fixedClock).plusDays(1), new Location("Zgierz", "Poland"), 15, 0, 50),
                new Weather(LocalDate.now(fixedClock).plusDays(2), new Location("Zgierz", "Poland"), 40, 0, 50),
                new Weather(LocalDate.now(fixedClock), new Location("Pabianice", "Poland"), -10, 10, 20),
                new Weather(LocalDate.now(fixedClock), new Location("Sieradz", "Poland"), 25, 30, 10)
        );

        List<Weather> expectedFilterResult = List.of(
                new Weather(LocalDate.now(fixedClock).plusDays(2), new Location("Zgierz", "Poland"), 40, 0, 50),
                new Weather(LocalDate.now(fixedClock), new Location("Sieradz", "Poland"), 25, 30, 10)
        );

        Assertions.assertEquals(expectedFilterResult, filter.filter(minTemp25, input));
    }

    @Test
    @DisplayName("When minimal temp is defined 25 and max temp is defined 30, filter should return 1 weather prediction")
    void whenMinimalTemp25AndMax30IsDefinedInCriteriaFilterFilterShouldReturn1WeatherPreditions() {
        WeatherCriteria minTemp25AndMax30 = new WeatherCriteria().ofMinTemp(25).ofMaxTemp(30);
        List<Weather> input = List.of(
                new Weather(LocalDate.now(fixedClock), new Location("Zgierz", "Poland"), 0, 0, 50),
                new Weather(LocalDate.now(fixedClock).plusDays(1), new Location("Zgierz", "Poland"), 15, 0, 50),
                new Weather(LocalDate.now(fixedClock).plusDays(2), new Location("Zgierz", "Poland"), 40, 0, 50),
                new Weather(LocalDate.now(fixedClock), new Location("Pabianice", "Poland"), -10, 10, 20),
                new Weather(LocalDate.now(fixedClock), new Location("Sieradz", "Poland"), 25, 30, 10)
        );

        List<Weather> expectedFilterResult = List.of(
                new Weather(LocalDate.now(fixedClock), new Location("Sieradz", "Poland"), 25, 30, 10)
        );

        Assertions.assertEquals(expectedFilterResult, filter.filter(minTemp25AndMax30, input));
    }

}
