package io.github.javafaktura.s01e05.anemic;

public class BeaufortScaleConverter {
    public BeaufortScale fromKnots(double knots) {
        if (knots > 64) {
            return BeaufortScale.HURRICANE;
        } else if (knots > 56) {
            return BeaufortScale.VIOLENT_STORM;
        } else if (knots > 48) {
            return BeaufortScale.STORM;
        } else if (knots > 41) {
            return BeaufortScale.STRONG_GALE;
        } else if (knots > 34) {
            return BeaufortScale.GALE;
        } else if (knots > 28) {
            return BeaufortScale.HIGH_WIND;
        } else if (knots > 22) {
            return BeaufortScale.STRONG_BREEZE;
        } else if (knots > 17) {
            return BeaufortScale.FRESH_BREEZE;
        } else if (knots > 11) {
            return BeaufortScale.MODERATE_BREEZE;
        } else if (knots > 7) {
            return BeaufortScale.GENTLE_BREEZE;
        } else if (knots > 4) {
            return BeaufortScale.LIGHT_BREEZE;
        } else if (knots > 1) {
            return BeaufortScale.LIGHT_AIR;
        } else {
            return BeaufortScale.CALM;
        }
    }
}
