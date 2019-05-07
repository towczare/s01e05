package io.github.javafaktura.s01e05.weather.prediction;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Random;

class Randomizer {
    private static final Random RANDOM = new Random();
    private static final int TWO_PLACES = 2;

    public static int getRandomInts(int min, int max){
        return RANDOM.ints(min,(max+1)).findFirst().getAsInt();
    }

    public static double getRandomDouble(double min, double max){
        return round(
                RANDOM.doubles(min,(max+1)).findFirst().getAsDouble(),
                TWO_PLACES
        );
    }

    private static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        BigDecimal bd = new BigDecimal(value);
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }

}
