package io.github.javafaktura.s01e05;

public class Pm10SmogAlertService {
    public SmogAlertLevel rateAirQuality(int pm10, Country country) {
        switch(country){
            case ITALY:
                if (pm10 >= 75) {
                    return SmogAlertLevel.WARNING;
                } else if (pm10 >= 50) {
                    return SmogAlertLevel.INFO;
                }
                break;
            case HUNGARY:
                if (pm10 >= 100) {
                    return SmogAlertLevel.WARNING;
                } else if (pm10 >= 75) {
                    return SmogAlertLevel.INFO;
                }
                break;
            case POLAND:
                if (pm10 >= 120) {
                    return SmogAlertLevel.WARNING;
                } else if (pm10 >= 100) {
                    return SmogAlertLevel.INFO;
                }
                break;
        }
        return SmogAlertLevel.OK;
    }
}
