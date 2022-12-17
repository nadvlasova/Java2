package lesson6.socketexample;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;

public class UrlConnectionExample {
    public static void main(String[] args) throws IOException {
        URL url = new URL("https", "geekbrains.ru", "/");
//        InputStream in = url.openStream();
//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(in, "UTF-8"));
//        String line;
//        while ((line = bufferedReader.readLine()) != null) {
//            System.out.println(line);
//        }
//        bufferedReader.close();

        URLConnection urlConnection = url.openConnection();
        InputStream inputStream = urlConnection.getInputStream();
        BufferedReader bufferedReader1 = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
        PrintWriter printWriter = new PrintWriter("geek.html");
        String currentString;
        while ((currentString = bufferedReader1.readLine()) != null) {
            printWriter.println(currentString);
        }
        printWriter.close();
        bufferedReader1.close();

        // методы URLConnection
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        System.out.println("Код ответа: " + httpURLConnection.getResponseCode());
        System.out.println("Метод запроса: " + httpURLConnection.getRequestMethod());

        Map<String, List<String>> headers = httpURLConnection.getHeaderFields();
        for (String key: headers.keySet()) {
            System.out.println("Ключ:" + key + " Значение:" + headers.get(key));
        }


    }
}










