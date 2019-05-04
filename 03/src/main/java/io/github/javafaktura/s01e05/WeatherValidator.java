package io.github.javafaktura.s01e05;

import com.google.common.base.Preconditions;


public class WeatherValidator {

    public void validate(Weather weather) {
        Preconditions.checkArgument(weather != null,                  "Weather can't be null");
        Preconditions.checkArgument(weather.getTemp()     >  -100.00, "Temperature can't be lower than -100.00 °C");
        Preconditions.checkArgument(weather.getTemp()     <=  100.00, "Temperature can't be higher than 100.00 °C");
        Preconditions.checkArgument(weather.getWind()     <=  500.00, "Wind can't be higher than 500.00 km/h");
        Preconditions.checkArgument(weather.getWind()     >=    0.00, "Wind can't be negative");
        Preconditions.checkArgument(weather.getRainfall() >=    0.00, "Rainfall can't be negative");
        Preconditions.checkArgument(weather.getRainfall() <= 1000.00, "Rainfall can't be higher than 1000.00 mm/day");
    }
}
