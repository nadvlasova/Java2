package lesson6;

import okhttp3.*;

import java.io.IOException;

public class BookerExample {
    public static void main(String[] args) throws IOException {
        OkHttpClient okHttpClient = new OkHttpClient();

        MediaType JSON = MediaType.parse("JSON");

        String authBodyString = "{" +
                "\"username\" : \"admin\",\n" +
                "\"password\" : \"password123\"" +
                "}";

        System.out.println(authBodyString);

        RequestBody requestBody = RequestBody.create(authBodyString, JSON);

        Request requestAuth = new Request.Builder()
                .url("https://restful-booker.herokuapp.com/auth")
                .addHeader("Content-Type", "application/json")
                .post(requestBody)
                .build();


        Response response = okHttpClient.newCall(requestAuth).execute();
        String body = response.body().string();
        System.out.println(response.code());
        System.out.println(response.headers());
        System.out.println(body); // {"token":"723e0b09b1c751f"}

        // Нам нужен будет токет, точнее его значение, а не так, как он сейчас в body в JSON приходит, распарсим его
        String token = body.split(":")[1];
        System.out.println(token); // "723e0b09b1c751f"}
        token = token.replaceAll("[\"}]", "");
        System.out.println(token); // a887c3121f66450 получили чистый точен без разных символов


        String requestBookingBody = "{" +
                "\"firstname\" : \"James\",\n" +
                "\"lastname\" : \"Brown\",\n" +
                "\"totalprice\" : 111,\n" +
                "\"depositpaid\" : true,\n" +
                "\"bookingdates\" : {\n" +
                "\"checkin\" : \"2018-01-01\",\n" +
                "\"checkout\" : \"2019-01-01\"\n" +
                "},\n" +
                "\"additionalneeds\" : \"Breakfast\"" +
                "}";

        RequestBody requestBodyBooking = RequestBody.create(requestBookingBody, JSON);

        Request requestBooking = new Request.Builder()
                .url("https://restful-booker.herokuapp.com/booking")
                .addHeader("Content-Type", "application/json")
                .addHeader("accept", "application/json")
                .addHeader("Cookie", String.format("token=%s", token))
                .post(requestBodyBooking)
                .build();

        Response responseBooking = okHttpClient.newCall(requestBooking).execute();
        System.out.println(responseBooking.code());
        System.out.println(responseBooking.headers());
        System.out.println(responseBooking.body().string());

    }
}
