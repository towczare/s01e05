package io.github.javafaktura.s01e05;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.jupiter.api.Assertions.assertEquals;

class BetterPm10SmogAlertServiceTest {

    private Pm10SmogAlertService alertService = new Pm10SmogAlertService();

    @ParameterizedTest(name = "For given Pm10 = {0} and country = {1} alert service should return smog alert type = {2}")
    @CsvSource({
            "0,     HUNGARY,    OK",
            "75,    HUNGARY,    INFO",
            "100,   HUNGARY,    WARNING",
            "0,     ITALY,      OK",
            "50,    ITALY,      INFO",
            "75,    ITALY,      WARNING",
            "0,     POLAND,     OK",
            "100,   POLAND,     INFO",
            "120,   POLAND,     WARNING        "
    })
    //@CsvFileSource(resources = "/BetterPm10SmogAlertServiceTest.csv", numLinesToSkip = 1) // external source
    void forGivenPm10AndCountryShouldReturnRightSmogAlertType(
            int pm10, Country country, SmogAlertLevel expectedSmogLevel
    ) {
        /** when **/
        SmogAlertLevel result = alertService.rateAirQuality(pm10, country);

        /** expected **/
        assertEquals(expectedSmogLevel, result);
        // Hamcrest matcher alternative
        //assertThat(result, equalTo(expectedSmogLevel));
    }
}
