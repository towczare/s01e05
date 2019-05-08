package io.github.javafaktura.s01e05.weather.filter.tdd.step11;

import io.github.javafaktura.s01e05.weather.Weather;

import java.util.List;
import java.util.stream.Collectors;

public class WeatherLocationFilter {

    public List<Weather> filter(
            WeatherCriteria criteria,
            List<Weather> source
    ) {
        return filterByCriteria(criteria, source);
    }

    private List<Weather> filterByCriteria(WeatherCriteria criteria, List<Weather> source) {


        return source.stream()
            .filter(
                    criteria.toWeatherPredicate()
            )
            .collect(Collectors.toList());
    }



}
