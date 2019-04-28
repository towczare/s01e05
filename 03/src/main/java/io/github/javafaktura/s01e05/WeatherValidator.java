package io.github.javafaktura.s01e05;

import static com.google.common.base.Preconditions.checkArgument;

public class WeatherValidator {

    public void validate(Weather weather) {
        checkArgument(weather != null, new IllegalArgumentException("Weather can't be null"));
        checkArgument(weather.getTemp() >     -100.00, new IllegalArgumentException("Temperature can't be lower than -100.00 °C"));
        checkArgument(weather.getTemp() >      100.00, new IllegalArgumentException("Temperature can't be higher than 100.00 °C"));
        checkArgument(weather.getWind() >      500.00, new IllegalArgumentException("Wind can't be higher than 500.00 km/h"));
        checkArgument(weather.getWind() <        0.00, new IllegalArgumentException("Wind can't be negative"));
        checkArgument(weather.getRainfall() <    0.00, new IllegalArgumentException("Rainfall can't be negative"));
        checkArgument(weather.getRainfall() < 1000.00, new IllegalArgumentException("Rainfall can't be higher than 1000.00 mm/day"));
    }
}
