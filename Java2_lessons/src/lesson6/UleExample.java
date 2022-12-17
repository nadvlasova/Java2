package lesson6;

import java.net.MalformedURLException;
import java.net.URL;

public class UleExample {
    public static void main(String[] args) throws MalformedURLException {
                           // protocol/       authority                    /      file
        URL url = new URL("https://smirnov:password@geekbrains.ru:80/courses&type=qa&level=super#1");
                                      // Userinfo       /   host      /port/path
        System.out.println("Протокол: "+ url.getProtocol());
        System.out.println("Host: " + url.getHost());
        System.out.println("Port: " + url.getPort());
        System.out.println("Path: " + url.getPath());

        // Стандартный конструктор
        URL url1 = new URL("https", "geekbrains.ru", 443, "/courses");
    }
}
