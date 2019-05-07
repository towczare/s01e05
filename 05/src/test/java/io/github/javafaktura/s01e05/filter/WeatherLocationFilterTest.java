package io.github.javafaktura.s01e05.filter;

import io.github.javafaktura.s01e05.weather.Weather;
import io.github.javafaktura.s01e05.weather.filter.WeatherCriteria;
import io.github.javafaktura.s01e05.weather.filter.WeatherLocationFilter;
import io.github.javafaktura.s01e05.weather.location.Location;
import io.github.javafaktura.s01e05.weather.prediction.RandomWeatherPredictor;
import io.github.javafaktura.s01e05.weather.prediction.WeatherPredictor;
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
        List<Weather> input = List.of(new Weather(LocalDate.now(fixedClock), new Location("Zgierz", "Poland"), -10, 0, 0));

        Assertions.assertEquals(input, filter.filter(emptyCriteria, input));
    }


}
