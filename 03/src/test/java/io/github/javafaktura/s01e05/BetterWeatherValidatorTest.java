package io.github.javafaktura.s01e05;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class BetterWeatherValidatorTest {

    WeatherValidator validator = new WeatherValidator();

    @Test
    @DisplayName("When null object is passed to WeatherValidator validate method IllegalArgumentException should be thrown")
    void nullWeatherObjectShouldThrowIllegalArgumentException() {
        //when
        Weather weather = null;

        //expect
        IllegalArgumentException exception = Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> validator.validate(weather)
        );
        //and expect
        Assertions.assertEquals("Weather can't be null", exception.getMessage());
    }

    @ParameterizedTest(name = "When given Weather (temp={0}, wind={1}, rainfall={2}) " +
            "is passed to WeatherValidator validate method " +
            "IllegalArgumentException should be thrown with following message \"{3}\"")
    @CsvSource({
            "-100.01,    0.00,     0.00, Temperature can't be lower than -100.00 °C",
            " 100.01,    0.00,     0.00, Temperature can't be higher than 100.00 °C",
            "   0.00,  500.01,     0.00, Wind can't be higher than 500.00 km/h",
            "   0.00,   -0.01,     0.00, Wind can't be negative",
            "   0.00,    0.00, 10000.01, Rainfall can't be higher than 1000.00 mm/day",
            "   0.00,    0.00,    -0.01, Rainfall can't be negative",
    })
    void whenGivenWeatherAttributeIsDefinedFollowingExceptionShouldBeThrown(
            double temp, double wind, double rainfall, String expectedErrorMsg
    ) {
        /** given **/
        Weather weather = new Weather(temp, wind, rainfall);

        /** expect **/
        IllegalArgumentException exception = Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> validator.validate(weather)
        );
        /** and expect **/
        Assertions.assertEquals(expectedErrorMsg, exception.getMessage());
    }

    @ParameterizedTest(name = "When given Weather (temp={0}, wind={1}, rainfall={2}) " +
            "is passed to WeatherValidator validate method " +
            "No exceptions should be thrown")
    @CsvSource({
            " -99.99,    0.00,     0.00",
            " 100.00,  500.00,  1000.00"
    })
    void whenGivenWeatherAttributeIsDefinedNoExceptionShouldBeThrown(
            double temp, double wind, double rainfall
    ) {
        /** given **/
        Weather weather = new Weather(temp, wind, rainfall);

        /** expect **/
        Assertions.assertDoesNotThrow(
                () -> validator.validate(weather)
        );
    }

}
