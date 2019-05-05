package io.github.javafaktura.s01e05.domain;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Foot {
    private final double value;

    public static Foot of(double value) {
        return new Foot(value);
    }

    public double getValue() {
        return value;
    }

    private Foot(double value) {
        this.value = value;
    }

    public Meter toMeter() {
        return Meter.of(
                BigDecimal.valueOf(value)
                        .multiply(
                                BigDecimal.valueOf(0.3048)
                        )
                        .setScale(2, RoundingMode.HALF_UP)
                        .doubleValue()
        );
    }
}
