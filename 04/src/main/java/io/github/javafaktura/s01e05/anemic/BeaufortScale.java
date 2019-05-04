package io.github.javafaktura.s01e05.anemic;

public enum BeaufortScale {

    CALM(0),
    LIGHT_AIR(1),
    LIGHT_BREEZE(2),
    GENTLE_BREEZE(3),
    MODERATE_BREEZE(4),
    FRESH_BREEZE(5),
    STRONG_BREEZE(6),
    HIGH_WIND(7),
    GALE(8),
    STRONG_GALE(9),
    STORM(10),
    VIOLENT_STORM(11),
    HURRICANE(12);

    private int scale;

    BeaufortScale(int scale) {
        this.scale = scale;
    }

    public int getScale() {
        return scale;
    }
}
