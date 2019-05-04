package io.github.javafaktura.s01e05.domain;

import com.google.common.collect.Lists;

import java.util.Arrays;
import java.util.List;

public enum BeaufortScale {

    CALM(0, 0, 1, 0),
    LIGHT_AIR(1, 1, 4, 0.3),
    LIGHT_BREEZE(2, 4, 7, 0.6),
    GENTLE_BREEZE(3, 7, 11, 1.2),
    MODERATE_BREEZE(4, 11, 17, 2),
    FRESH_BREEZE(5, 17, 22, 3),
    STRONG_BREEZE(6, 22, 28, 4),
    HIGH_WIND(7, 28, 34, 5.5),
    GALE(8, 34, 41, 7.5),
    STRONG_GALE(9, 41, 48, 10),
    STORM(10, 48, 56, 12.5),
    VIOLENT_STORM(11, 56, 64, 16),
    HURRICANE(12, 64, 500, 20);

    private int scale;
    private double minSpeedKnots;
    private double maxSpeedKnots;
    private double maxWaveHeightMeters;


    BeaufortScale(int scale,double minSpeedKnots, double maxSpeedKnots, double waveHeight) {
        this.scale = scale;
        this.minSpeedKnots = minSpeedKnots;
        this.maxSpeedKnots = maxSpeedKnots;
        this.maxWaveHeightMeters = waveHeight;
    }

    public static BeaufortScale fromKnots(double knots) {
        return Lists.reverse(getBeaufortScale())
            .stream()
            .filter(scale -> knots >= scale.minSpeedKnots)
            .findFirst()
            .orElse(CALM);
    }

    private static List<BeaufortScale> getBeaufortScale() {
        return Arrays.asList(BeaufortScale.values());
    }

    public int getScale() {
        return scale;
    }

    public double getMinSpeedKnots() {
        return minSpeedKnots;
    }

    public double getMaxSpeedKnots() {
        return maxSpeedKnots;
    }

    public double getMaxWaveHeightMeters() {
        return maxWaveHeightMeters;
    }
}
