package io.github.javafaktura.s01e05.weather.prediction;

import io.github.javafaktura.s01e05.weather.location.Location;
import io.github.javafaktura.s01e05.weather.Weather;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class RandomWeatherPredictor implements WeatherPredictor {

    private final List<Location> locations;

    public RandomWeatherPredictor(List<Location> locations) {
        this.locations = locations;
    }

    public List<Weather> predict(LocalDate start, int days) {
        List<Weather> predictions = new ArrayList<>();
        for (int day = 0; day < days; day++) {
            for (Location location : locations) {
                predictions.add(new Weather(start.plusDays(day), location, randomTemp(), randomWind(), getRandomRainfall()));
            }
        }
        return predictions;
    }

    private double randomTemp() {
        return Randomizer.getRandomInts(-10, 40);
    }

    private static double randomWind() {
        int probs = Randomizer.getRandomInts(0, 100);

        if(probs < 50) { // 50% chance
            return Randomizer.getRandomDouble(0, 20);
        } else if (probs < 80) { // 30% chance
            return Randomizer.getRandomDouble(20, 30);
        } else if (probs < 95) { // 15% chance
            return Randomizer.getRandomDouble(30, 60);
        } else { // 5% chance
            return Randomizer.getRandomDouble(0, 100);
        }
    }

    private static int getRandomRainfall() {
        int rainFall = Randomizer.getRandomInts(-20, 10);
        return rainFall < 0 ? 0 : rainFall; //33% chance for rain
    }
}
