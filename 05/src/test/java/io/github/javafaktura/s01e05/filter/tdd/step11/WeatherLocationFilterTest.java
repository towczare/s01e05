package io.github.javafaktura.s01e05.filter.tdd.step11;

import io.github.javafaktura.s01e05.weather.Weather;
import io.github.javafaktura.s01e05.weather.filter.tdd.step11.*;
import io.github.javafaktura.s01e05.weather.location.Location;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

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

    @Test
    @DisplayName("When dry for rain in criteria is defined then 2 weather predictions should be returned")
    void whenDryForRainIsDefinedInCriteriaThenFilterShouldReturn2WeatherPredictions() {
        WeatherCriteria noRain = new WeatherCriteria().ofRain(RainCriteria.DRY);
        List<Weather> input = List.of(
                new Weather(LocalDate.now(fixedClock), new Location("Zgierz", "Poland"), 0, 0, 0),
                new Weather(LocalDate.now(fixedClock).plusDays(1), new Location("Zgierz", "Poland"), 15, 0, 50),
                new Weather(LocalDate.now(fixedClock).plusDays(2), new Location("Zgierz", "Poland"), 40, 0, 50),
                new Weather(LocalDate.now(fixedClock), new Location("Pabianice", "Poland"), -10, 10, 20),
                new Weather(LocalDate.now(fixedClock), new Location("Sieradz", "Poland"), 25, 30, 0)
        );

        List<Weather> expectedFilterResult = List.of(
                new Weather(LocalDate.now(fixedClock), new Location("Zgierz", "Poland"), 0, 0, 0),
                new Weather(LocalDate.now(fixedClock), new Location("Sieradz", "Poland"), 25, 30, 0)
        );

        Assertions.assertEquals(expectedFilterResult, filter.filter(noRain, input));
    }

    @ParameterizedTest(name = "For given {0} kite and weather it requires requirements filter should return weather for city {1}")
    @CsvSource({
        "DELTA, Katowice",
        "DIAMOND, Katowice",
        "DRAGON, Katowice",
        "BOX, Cieszyn",
        "STICKLESS_PARAFOIL, Cieszyn",
    })
    void forGivenSourceAndKiteTypeWeExpectFollowingWeatherPredictionsFromFilter(
            KiteType kiteType,
            String expectedCity
    ) {
        WeatherCriteria kiteWeather = kiteType.toWeatherCriteria();
        List<Weather> input = List.of(
                new Weather(LocalDate.now(fixedClock).plusDays(1), new Location("Sosnowiec", "Poland"), -10,8.00, 0),
                new Weather(LocalDate.now(fixedClock).plusDays(2), new Location("Katowice", "Poland"), 30, 9.66, 0),
                new Weather(LocalDate.now(fixedClock).plusDays(3), new Location("Warszawa", "Poland"), 20, 9.66, 1),
                new Weather(LocalDate.now(fixedClock).plusDays(2), new Location("Cieszyn", "Poland"), 30, 25.00, 0),
                new Weather(LocalDate.now(fixedClock).plusDays(2), new Location("Pabianice", "Poland"), 30, 42.00, 1)
        );

        List<Weather> filtered = this.filter.filter(kiteWeather, input);

        Assertions.assertAll("Only one weather prediction fits our Kite requirements",
                () -> Assertions.assertTrue(filtered.size() == 1),
                () -> Assertions.assertEquals(expectedCity, filtered.get(0).getLocation().getCity())
        );


    }

}
