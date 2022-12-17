package lesson6.socketexample;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerApp {
    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(1234)) {
            System.out.println("Сервер запущен, ожидаем подключения!");
            Socket socket = serverSocket.accept(); // здесь программа будет блокироваться и ожидать новых подключений
            // в терминале набрать команду lsof -i tcp:1234 для посмотра подключений
            System.out.println("Клиент подключился!");
            DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream()); // Считывать исходящий поток
            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream()); // Считываем входящий поток

            // чтобы программа не завершила работу после первого сообщения берем цикл, получать и отвечать на сообщения
            while (true) {
                String clientRequest = dataInputStream.readUTF();
                if (clientRequest.equals("end")) break;
                System.out.println("Получили от клиента запрос: " + clientRequest);
                dataOutputStream.writeUTF("Ответ на запрос клиента: " + clientRequest);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
