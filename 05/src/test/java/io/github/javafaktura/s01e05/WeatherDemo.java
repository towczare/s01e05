package io.github.javafaktura.s01e05;

import io.github.javafaktura.s01e05.weather.Weather;
import io.github.javafaktura.s01e05.weather.location.LocationFileProvider;
import io.github.javafaktura.s01e05.weather.location.LocationProvider;
import io.github.javafaktura.s01e05.weather.prediction.WeatherPredictor;
import io.github.javafaktura.s01e05.weather.prediction.RandomWeatherPredictor;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDate;
import java.util.List;

class WeatherDemo {

    private final Logger logger = LoggerFactory.getLogger(WeatherDemo.class);

    private static final String WORLD_CITIES_CSV_PATH = "src/main/resources/world-cities.csv";
    private static final String POLISH_CITIES_CSV_PATH = "src/main/resources/polish-cities.csv";

    private LocationProvider locationProvider = new LocationFileProvider(POLISH_CITIES_CSV_PATH);
    private WeatherPredictor weatherPredictor = new RandomWeatherPredictor(locationProvider.load());

    @Test
    void weatherPredictionDemo() {
        List<Weather> predictions = weatherPredictor.predict(LocalDate.now(), 10);
        for (Weather prediction : predictions) {
            logger.info(prediction.prettyLog());
        }
    }
}
