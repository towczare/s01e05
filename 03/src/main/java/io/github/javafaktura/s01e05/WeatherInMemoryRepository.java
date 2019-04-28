package io.github.javafaktura.s01e05;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class WeatherInMemoryRepository implements WeatherRepository {

    private Map<String, Weather> db;

    public WeatherInMemoryRepository() {
        db = new HashMap<>();
    }

    public String save(Weather weather) {
        String key = getKey();
        db.put(key, weather);
        return key;
    }

    private String getKey() {
        return UUID.randomUUID().toString();
    }
}
