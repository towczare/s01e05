package io.github.javafaktura.s01e05.weather.filter.tdd.step10;

import io.github.javafaktura.s01e05.weather.Weather;

import java.util.List;
import java.util.function.Predicate;
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
            .filter(w -> w.getTemp() <= criteria.getMaxTemp())
            .filter(w -> w.getTemp() >= criteria.getMinTemp())
            .filter(filterForRainCriteria(criteria.getRainCriteria()))
            .collect(Collectors.toList());
    }

    private Predicate<Weather> filterForRainCriteria(RainCriteria rainCriteria) {
        switch (rainCriteria) {
            case WET:
                return w -> w.getRainfall() > 0.00;
            case DRY:
               return w -> w.getRainfall() == 0.00;
            case WHO_CARES:
                return w -> true;
        }
        return w -> true;
    }

}
