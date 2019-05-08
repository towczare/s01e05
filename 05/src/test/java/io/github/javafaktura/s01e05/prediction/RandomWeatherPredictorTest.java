package io.github.javafaktura.s01e05.prediction;

import io.github.javafaktura.s01e05.weather.Weather;
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
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class RandomWeatherPredictorTest {
    Clock fixedClock =
        Clock.fixed(
            Instant.parse("2020-01-01T00:00:00.00Z"),
            ZoneId.of("Asia/Calcutta")
        );

    @Test
    @DisplayName("For 2 locations and 2 days, predictor, should return 2 weather objects")
    void forTwoLocationsAndTwoDaysShouldReturnFourWeathers() {
        List<Location> twoLocations =
                List.of(
                    new Location("a", "A"),
                    new Location("b", "B")
                );
        WeatherPredictor weatherPredictor =
                new RandomWeatherPredictor(twoLocations);

        List<Weather> weathers = weatherPredictor.predict(LocalDate.now(fixedClock), 2);

        Assertions.assertEquals(4, weathers.size());
    }

    @Test
    @DisplayName("For 1 single location and 3 days, predictor should return 3 weather objects for 3 days in a row")
    void forSingleLocationAnd3DaysShouldReturn3WeatherObjectsInARowStartingFromToday() {
        List<Location> twoLocations = List.of(new Location("a", "A"));
        WeatherPredictor weatherPredictor =
                new RandomWeatherPredictor(twoLocations);

        List<Weather> weathers = weatherPredictor.predict(LocalDate.now(fixedClock), 3);

        Assertions.assertEquals(asLocalDates("2020-01-01", "2020-01-02", "2020-01-03"), toLocalDates(weathers));
    }

    private List<LocalDate> toLocalDates(List<Weather> weathers) {
        return weathers.stream()
                .map(w -> w.getForecastDate())
                .collect(Collectors.toList());
    }

    private List<LocalDate> asLocalDates(String... dates) {
        return Arrays.asList(dates)
                .stream()
                .map(d -> LocalDate.parse(d))
                .collect(Collectors.toList());
    }
}
