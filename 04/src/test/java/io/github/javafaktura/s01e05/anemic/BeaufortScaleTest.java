package io.github.javafaktura.s01e05.anemic;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class BeaufortScaleTest {

    private BeaufortScaleConverter converter = new BeaufortScaleConverter();

    @ParameterizedTest(name = "Given number of knots equal to {0} is following Beaufort scale = {1}")
    @CsvSource( {
          "0,    0",
          "0.99, 0",
          "1,    1",
          "3.99, 1",
          "4,    2",
          "6.99, 2",
          "7   , 3",
          "10.99,3",
          "11,   4",
          "16.99,4",
          "17,   5",
          "21.99,5",
          "22,   6",
          "27.99,6",
          "28,   7",
          "33.99,7",
          "34,   8",
          "40.99,8",
          "41,   9",
          "47.99,9",
          "48,   10",
          "55.99,10",
          "56,   11",
          "63.99,11",
          "64,   12",
          "100,  12",
    })
    void givenNumberOfKnotsIsEqualFollowingBeaufortScale(
            double knots, int expectedScale
    ) {
        Assertions.assertEquals(expectedScale, converter.fromKnots(knots).getScale());
    }
}
