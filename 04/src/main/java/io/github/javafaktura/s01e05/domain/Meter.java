package io.github.javafaktura.s01e05.domain;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Meter {
    private final double value;

    public static Meter of(double value) {
        return new Meter(value);
    }

    public double getValue() {
        return value;
    }

    private Meter(double value) {
        this.value = value;
    }

    public Foot toFoot() {
        return Foot.of(
            BigDecimal.valueOf(value)
            .divide(
                BigDecimal.valueOf(0.3048),
                2,
                RoundingMode.HALF_UP
            )
            .doubleValue()
        );
    }
}
