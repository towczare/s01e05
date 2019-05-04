package io.github.javafaktura.s01e05;

import java.time.Instant;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class WeatherInMemoryRepository implements WeatherRepository {

    private Map<Instant, Weather> db;

    public WeatherInMemoryRepository() {
        db = new HashMap<>();
    }

    public Instant save(Weather weather) {
        Instant key = getKey();
        db.put(key, weather);
        return key;
    }

    private Instant getKey() {
        return Instant.now();
    }
}
