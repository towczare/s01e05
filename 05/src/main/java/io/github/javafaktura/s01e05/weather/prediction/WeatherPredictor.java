package io.github.javafaktura.s01e05.weather.prediction;

import io.github.javafaktura.s01e05.weather.Weather;

import java.time.LocalDate;
import java.util.List;

public interface WeatherPredictor {
    List<Weather> predict(LocalDate start, int days);
}
