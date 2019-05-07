package io.github.javafaktura.s01e05.weather.filter.tdd.step8;

import io.github.javafaktura.s01e05.weather.Weather;

import java.util.List;
import java.util.stream.Collectors;

public class WeatherLocationFilter {

    public List<Weather> filter(
            WeatherCriteria criteria,
            List<Weather> source
    ) {
        return source.stream()
                .filter(w -> w.getTemp() >= criteria.getMinTemp())
                .filter(w -> w.getTemp() <= criteria.getMaxTemp())
                .collect(Collectors.toList());
    }

}
