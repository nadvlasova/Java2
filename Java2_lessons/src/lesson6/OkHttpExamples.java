package lesson6;

import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class OkHttpExamples {
    public static void main(String[] args) throws IOException {


        OkHttpClient okHttpClient = new OkHttpClient()
                // параметры запроса клиента
                .newBuilder()
                .readTimeout(10, TimeUnit.SECONDS)
                .build();

        // Для запроса можно использовать конструктор, это более гибктй и предпочтительный метод
//        HttpUrl url = new HttpUrl.Builder()
//                .scheme("https")
//                .host("geekbrains")
//                .addPathSegment("/courses")
//                .build();

        // Запрос можно сразу прописать
        Request request = new Request.Builder()
                .url("https://geekbrains.ru")
                .build();

        // Ответ
        Response response = okHttpClient.newCall(request).execute(); // без конструктора
        // Response response = okHttpClient.newCall(url).execute(); // не сработало, видимо в конструкторе нужно сохранять в переменную


        System.out.println(response.code());
        System.out.println(response.code());
        System.out.println(response.headers());
        // System.out.println(response.body().string()); // метод string закрывает поток после прочтения,
        // поэтому полученный данные лучше сохранять в переменную, второй раз их прочитать из потока не получится
        String responseBody = response.body().string();


    }

}
