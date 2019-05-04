package io.github.javafaktura.s01e05;

import java.time.Instant;

interface WeatherRepository {
    Instant save(Weather weather);
}
