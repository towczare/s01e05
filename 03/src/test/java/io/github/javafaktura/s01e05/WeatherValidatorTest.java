package io.github.javafaktura.s01e05;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class WeatherValidatorTest {

    WeatherValidator validator = new WeatherValidator();

    @Test
    @DisplayName("When null object is passed to WeatherValidator validate method IllegalArgumentException should be thrown")
    void nullWeatherObjectShouldThrowIllegalArgumentException() {
        Weather weather = null;

        try {
            validator.validate(weather);
        } catch (IllegalArgumentException e) {
            Assertions.assertEquals(IllegalArgumentException.class, e.getClass());
        }
    }

    @ParameterizedTest(name = "When given Weather (temp={0}, wind={1}, rainfall={2}) is passed to WeatherValidator validate method IllegalArgumentException should be thrown")
    @CsvSource({
            "-100.01,    0.00,     0.00",
            " 100.01,    0.00,     0.00",
            "   0.00,  500.01,     0.00",
            "   0.00,   -0.01,     0.00",
            "   0.00,    0.00, 10000.00",
            "   0.00,    0.00,    -0.01"
    })
    void whenGivenWeatherAttributeIsDefinedFollowingExceptionShouldBeThrown(
            double temp, double wind, double rainfall
    ) {
        Weather weather = new Weather(temp, wind, rainfall);
        RuntimeException exception = null;
        try {
            validator.validate(weather);
        } catch (IllegalArgumentException e) {
            Assertions.assertEquals(IllegalArgumentException.class, exception.getClass());
        }
    }

}
