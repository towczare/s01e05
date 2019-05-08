package io.github.javafaktura.s01e05;

import io.github.javafaktura.s01e05.weather.Weather;
import io.github.javafaktura.s01e05.weather.filter.KiteType;
import io.github.javafaktura.s01e05.weather.filter.RainCriteria;
import io.github.javafaktura.s01e05.weather.filter.WeatherCriteria;
import io.github.javafaktura.s01e05.weather.filter.WeatherLocationFilter;
import io.github.javafaktura.s01e05.weather.location.LocationFileProvider;
import io.github.javafaktura.s01e05.weather.location.LocationProvider;
import io.github.javafaktura.s01e05.weather.prediction.WeatherPredictor;
import io.github.javafaktura.s01e05.weather.prediction.RandomWeatherPredictor;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDate;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class WeatherDemo {

    private final Logger logger = LoggerFactory.getLogger(WeatherDemo.class);

    private static final String WORLD_CITIES_CSV_PATH = "src/main/resources/world-cities.csv";
    private static final String POLISH_CITIES_CSV_PATH = "src/main/resources/polish-cities.csv";

    private LocationProvider locationProvider = new LocationFileProvider(WORLD_CITIES_CSV_PATH);
    private WeatherPredictor weatherPredictor = new RandomWeatherPredictor(locationProvider.load());
    private WeatherLocationFilter filter = new WeatherLocationFilter();

    @Test
    void weatherPredictionDemo() {
        List<Weather> predictions = weatherPredictor.predict(LocalDate.now(), 10);

        Comparator<Weather> weatherComparator =
            Comparator.comparing(
                    Weather::getLocation, (w1, w2) -> w2.compareTo(w1))
                    .thenComparing(Weather::getForecastDate);

        Collections.sort(predictions, weatherComparator);

        List<Weather> filteredPredictions = this.filter.filter(
                KiteType.BOX
                    .toWeatherCriteria()
                    .ofMaxTemp(25)
                    .ofMinTemp(15), predictions);

        for (Weather prediction : filteredPredictions) {
            logger.info(prediction.prettyLog());
        }
    }
}
