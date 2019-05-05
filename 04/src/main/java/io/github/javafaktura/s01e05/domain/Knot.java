package io.github.javafaktura.s01e05.domain;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Knot {
    private final double value;

    public static Knot of(double value) {
        return new Knot(value);
    }

    public double getValue() {
        return value;
    }

    private Knot(double value) {
        this.value = value;
    }
}
