package lesson7.project2_7.entity;

// Классы описывающие структуру БД называют entity, поэтому создала папку и положила туда Weather
public class Weather {
    // create table weather (id integer primary key autoincrement, city text, localdate text, weather_text text, temperature real)
    private String city;
    private String localdate;
    private String weatherText;
    private double temperature;

    public Weather(String city, String localdate, String weatherText, double temperature) {
        this.city = city;
        this.localdate = localdate;
        this.weatherText = weatherText;
        this.temperature = temperature;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getLocaldate() {
        return localdate;
    }

    public void setLocaldate(String localdate) {
        this.localdate = localdate;
    }

    public String getWeatherText() {
        return weatherText;
    }

    public void setWeatherText(String weatherText) {
        this.weatherText = weatherText;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }
}
