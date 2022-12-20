package lesson7.project2_7;

import java.io.IOException;
import java.util.Scanner;

public class UserInterfaceView {
    Controller controller = new Controller();

    // вызывая этот метод запускаем user интерфейс
    public void runInterface() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Введите название города: ");
            String city = scanner.nextLine();

            System.out.println("Выбор: 1 - погода на текущий день, 2 - погода на 5 дней, и выход для завершения: ");
            String command = scanner.nextLine();

            try {
                controller.getWeather(command, city);
            } catch (IOException e) {
                    e.printStackTrace();
                    continue;
                }
            }

        }

        public void checkUserInput(String userInput) {
        // обработать пользовательский ввод выбросить исключение и прервать работу программы
        }

}
