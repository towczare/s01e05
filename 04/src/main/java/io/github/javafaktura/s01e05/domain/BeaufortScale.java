package io.github.javafaktura.s01e05.domain;

import com.google.common.collect.Lists;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.List;

public enum BeaufortScale {

    CALM(           0,  Knot.of(0),  Knot.of(1),  Foot.of(0.00)),
    LIGHT_AIR(      1,  Knot.of(1),  Knot.of(4),  Foot.of(0.33)),
    LIGHT_BREEZE(   2,  Knot.of(4),  Knot.of(7),  Foot.of(0.66)),
    GENTLE_BREEZE(  3,  Knot.of(7), Knot.of(11),  Foot.of(2.00)),
    MODERATE_BREEZE(4, Knot.of(11), Knot.of(17),  Foot.of(3.30)),
    FRESH_BREEZE(   5, Knot.of(17), Knot.of(22),  Foot.of(6.60)),
    STRONG_BREEZE(  6, Knot.of(22), Knot.of(28),  Foot.of(9.90)),
    HIGH_WIND(      7, Knot.of(28), Knot.of(34), Foot.of(13.10)),
    GALE(           8, Knot.of(34), Knot.of(41), Foot.of(18.00)),
    STRONG_GALE(    9, Knot.of(41), Knot.of(48), Foot.of(23.00)),
    STORM(         10, Knot.of(48), Knot.of(56), Foot.of(29.50)),
    VIOLENT_STORM( 11, Knot.of(56), Knot.of(64), Foot.of(37.70)),
    HURRICANE(     12, Knot.of(64), Knot.of(99), Foot.of(46.00));

    private int scale;
    private Knot minSpeed;
    private Knot maxSpeed;
    private Foot waveHeights;

    BeaufortScale(int scale, Knot minSpeed, Knot maxSpeed, Foot waveHeight) {
        this.scale = scale;
        this.minSpeed = minSpeed;
        this.maxSpeed = maxSpeed;
        this.waveHeights = waveHeight;
    }

    public static BeaufortScale from(Knot knots) {
        return Lists.reverse(getBeaufortScale())
            .stream()
            .filter(scale -> knots.getValue() >= scale.minSpeed.getValue())
            .findFirst()
            .orElse(CALM);
    }

    public static BeaufortScale from(Foot waveHeight) {
        List<BeaufortScale> reverseScale = Lists.reverse(getBeaufortScale());
        return reverseScale
                .stream()
                .filter(scale -> waveHeight.getValue() >= scale.waveHeights.getValue())
                .findFirst()
                .orElse(CALM);
    }

    public static BeaufortScale from(Meter waveHeight) {
        return from(waveHeight.toFoot());
    }

    private static List<BeaufortScale> getBeaufortScale() {
        return Arrays.asList(BeaufortScale.values());
    }

    public int getScale() {
        return scale;
    }
}
