package io.github.javafaktura.s01e05;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class BadPm10SmogAlertServiceTest {

    @Test
    @DisplayName("For given Pm10 and country should return right smog alert type")
    void forGivenPm10AndCountryShouldReturnRightSmogAlertType() {
        //given
        Pm10SmogAlertService alertService = new Pm10SmogAlertService();
        //and
        List<TestParams> testScenarios = new ArrayList<>();
        testScenarios.add(new TestParams(  0, Country.HUNGARY,  SmogAlertLevel.OK));
        testScenarios.add(new TestParams( 75, Country.HUNGARY,  SmogAlertLevel.INFO));
        testScenarios.add(new TestParams(100, Country.HUNGARY,  SmogAlertLevel.WARNING));
        testScenarios.add(new TestParams(  0, Country.ITALY,    SmogAlertLevel.OK));
        testScenarios.add(new TestParams( 50, Country.ITALY,    SmogAlertLevel.INFO));
        testScenarios.add(new TestParams( 75, Country.ITALY,    SmogAlertLevel.WARNING));
        testScenarios.add(new TestParams(  0, Country.POLAND,   SmogAlertLevel.OK));
        testScenarios.add(new TestParams(100, Country.POLAND,   SmogAlertLevel.INFO));
        testScenarios.add(new TestParams(120, Country.POLAND,   SmogAlertLevel.WARNING));

        for (TestParams scenario : testScenarios) {
            //expected
            Assertions.assertEquals(scenario.expectedAlertLevel, alertService.rateAirQuality(scenario.pm10, scenario.country));
        }
    }


    class TestParams {
        int pm10;
        Country country;
        SmogAlertLevel expectedAlertLevel;

        public TestParams(int pm10, Country country, SmogAlertLevel expectedAlertLevel) {
            this.pm10 = pm10;
            this.country = country;
            this.expectedAlertLevel = expectedAlertLevel;
        }
    }
}
