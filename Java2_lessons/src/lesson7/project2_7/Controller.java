package lesson7.project2_7;

import java.io.IOException;

// Контроллеру все равно с какой моделью API работать, поэто для разных моделей своя переменная
public class Controller {
    WeatherModel weatherModel = new AccuweatherModel();

    // command это команда выбора периода запроса погоды (1 - сегодня или 2 - на 5 дней)
    public void getWeather(String command, String selectCity) throws IOException {
        switch (Functionality.fromValue(command)) {
            case GET_CURRENT_WEATHER:
                weatherModel.getWeather(Period.NOW, selectCity);
                break;
            case GET_WEATHER_IN_NEXT_FIVE_DAYS:
                throw new IOException("Метод в разработке!");
        }

    }
}
