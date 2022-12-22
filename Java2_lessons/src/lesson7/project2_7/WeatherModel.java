package lesson7.project2_7;

import java.io.IOException;

// Интерфейс который сможет описать различные источники данных погоды
public interface WeatherModel {
    void getWeather(Period period, String selectedCity) throws IOException;

    void getSavedWeatherData();
}
