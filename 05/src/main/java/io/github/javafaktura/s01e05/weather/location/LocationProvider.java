package io.github.javafaktura.s01e05.weather.location;

import java.util.List;

public interface LocationProvider {
    List<Location> load();
}
