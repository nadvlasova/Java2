package lesson7.project2_7;

import lesson7.project2_7.entity.Weather;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class DataBaseRepository {
    private static final String DB_NAME = "geekbrains.db";
    String insertWeather = "insert into weather (city, localdate, weather_text, temperature) values (?, ?, ?, ?)";

    static  {
        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    // Создали таблицу weather в Базе данных запрос с колонками:
    // create table weather (id integer primary key autoincrement, city text, localdate text, weather_text text, temperature real)
    public boolean saveWeatherData(Weather weather) throws SQLException {
        // тут прописываем подключение к БД и запрос
        try (Connection connection = DriverManager.getConnection("jdbc:sqlite:geekbrains.db")) {
            PreparedStatement saveWeather = connection.prepareStatement(insertWeather);
            saveWeather.setString(1, weather.getCity());
            saveWeather.setString(2, weather.getLocaldate());
            saveWeather.setString(3, weather.getWeatherText());
            saveWeather.setDouble(4, weather.getTemperature());
            return saveWeather.execute();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        // throw new SQLException("Сохранение данных о погоде в Базу Данных не выполнено!");// у меня на это ругается, просит удалить
    }

    // TODO: Реализовать метод для считывания всех данных о запрашиваемой погоде(т.е. какие были запросы, я так поняла)
//    public List<Weather> getSavedWeatherData() {
//        // список объектов погоды, которые были сохранены в БД
//        // 1. Создать connection
//        // 2. Создать statement
//        // 3. statement.executeQuery(select.....)
////
////    }


    public static void main(String[] args) throws SQLException {
        DataBaseRepository dataBaseRepository = new DataBaseRepository();
        dataBaseRepository.saveWeatherData(new Weather("Irkutsk", "22.12.2022", "Sunny", -15));
    }
}
