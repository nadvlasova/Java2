package lesson7.project2_7;

import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

// предварительно зарегистрироваться на Accuweather API для получения ключа для апи запросов
public class AccuweatherModel  implements WeatherModel{
    private static final String  PROTOCOL = "http";
    private static final String API_KEY = "vCxNl4tOT7A8xeqR2yC0U2cSAMkoN5DM";
    private static final String BASE_HOST = "dataservice.accuweather.com";
    private static final String CURRENT_CONDITION_ENDPOINT = "currentconditions";
    private static final String API_V1 = "v1";
    private static final String LOCATIONS_ENDPOINT = "locations";
    private static final String CITIES_ENDPOINT = "cities";
    private static final String AUTOCOMPLETE_ENDPOINT = "autocomplete";

    private static final OkHttpClient okHttpClient = new OkHttpClient();
    private static final ObjectMapper objectMapper = new ObjectMapper();

    public void getWeather(Period period, String selectCity) throws IOException {
        String cityKey = detectCityKey(selectCity);
        if (period == Period.NOW) {
            HttpUrl httpUrl = new HttpUrl.Builder()
                    .scheme(PROTOCOL)
                    .host(BASE_HOST)
                    .addPathSegment(CURRENT_CONDITION_ENDPOINT)
                    .addPathSegment(API_V1)
                    .addPathSegment(cityKey)
                    .addQueryParameter("apikey", API_KEY)
                    .build();

            Request request = new Request.Builder()
                    .addHeader("accept", "application/json")
                    .url(httpUrl)
                    .build();

            Response response = okHttpClient.newCall(request).execute();
            String responseString = response.body().string();
            System.out.println(responseString);


        }
        if (period == Period.FIVE_DAYS) {
            // ПЗ со звездочкой, зайти на accuweather найти api на 5 дней, распарсить для запроса
        }

    }
    public String detectCityKey(String selectCity) throws IOException {
        HttpUrl httpUrl = new HttpUrl.Builder()
                .scheme(PROTOCOL)
                .host(BASE_HOST)
                .addPathSegment(LOCATIONS_ENDPOINT)
                .addPathSegment(API_V1)
                .addPathSegment(CITIES_ENDPOINT)
                .addPathSegment(AUTOCOMPLETE_ENDPOINT)
                .addQueryParameter("apikey", API_KEY)
                .addQueryParameter("q", selectCity)
                .build();


        Request request = new Request.Builder()
                .addHeader("accept", "application/json")
                .url(httpUrl)
                .build();

        Response response = okHttpClient.newCall(request).execute();
        String responseString = response.body().string();

        String cityKey = objectMapper.readTree(responseString).get(0).at("/Key").asText();

//        System.out.println(response.body().string());
        System.out.println(cityKey);
        return cityKey;
        // ПЗ здесь вывести данные в читабельном виде, в идеале создать отдельный класс
        // полученного json объекта cityKey, распарсить и сделать красивый вывод погоды
    }

    // main нужен был для тестирования в момент тестирования методы getWeather detectCityKey делали статическими
//    public static void main(String[] args) throws IOException {
//        getWeather(Period.NOW, "New York");
//    }


}































