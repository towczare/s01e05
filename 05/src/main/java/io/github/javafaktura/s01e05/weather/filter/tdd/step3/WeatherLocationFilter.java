package io.github.javafaktura.s01e05.weather.filter.tdd.step3;

import io.github.javafaktura.s01e05.weather.Weather;

import java.util.List;

public class WeatherLocationFilter {

    public List<Weather> filter(WeatherCriteria criteria, List<Weather> source) {
        return source;
    }

}
