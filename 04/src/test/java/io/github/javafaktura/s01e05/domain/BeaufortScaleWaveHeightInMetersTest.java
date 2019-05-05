package io.github.javafaktura.s01e05.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class BeaufortScaleWaveHeightInMetersTest {

    @ParameterizedTest(name = "Given wave of height {0} in meters should be following Beaufort scale = {1}")
    @CsvSource( {
            " 0,     0",
            " 0.09,  0",
            " 0.1,   1",
            " 0.19,  1",
            " 0.2,   2",
            " 0.59,  2",
            " 0.99,  3",
            " 1.99,  4",
            " 2.99,  5",
            " 3.5,   6",
            " 4,     7",
            " 5.5,   8",
            " 6.99,  8",
            " 7.5,   9",
            " 9,    10",
            "11.5,  11",
            "13.99, 11",
            "30,    12"
    })
    void shouldReturnFollowingBeaufortScale(
            double waveHeight, int expectedScale
    ) {
        Assertions.assertEquals(expectedScale, BeaufortScale.from(Meter.of(waveHeight)).getScale());
    }
}
