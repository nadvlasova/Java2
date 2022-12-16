package lesson4;

import java.util.Arrays;
import java.util.Random;

// Создаем массив паспортов работников с рандомными номерами.
public class Passports {
    public static void main(String[] args) {
        Integer[] passports = new Integer[50];
        Random random = new Random();

        for (int i = 0; i < passports.length; i++) {
            passports[i] = random.nextInt(999999) + 100000;

            // Упс пришел новый сотрудник добавить его пасспорт в массив мы не можем(Массив-Неизменяем),
            // поэтому создаем новый массив с его пасспортом и копируем в него предыдущий массив.
            Integer[] passportsNew = new Integer[51];
            System.arraycopy(passports, 0, passportsNew, 0, passports.length);
            passportsNew[50] = 111222;
            passports = passportsNew;
            System.out.println(Arrays.toString(passportsNew));

        }
    }
}
