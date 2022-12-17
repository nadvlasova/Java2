package lesson5;

import java.io.*;
import java.nio.charset.Charset;
import java.util.Arrays;

public class StreamsExamples {
    public static void main(String[] args) {
        String tempString = "cat";
        byte[] byteArray = tempString.getBytes();
        System.out.println("cat в байтах " + Arrays.toString(byteArray));

        // 1 байт = 8 бит 10101010 от мин до макс все вариации 0и 1 в диапазоне 00000000-11111111 т.е. 256 вариантов
        // т.е. от 0 до 256, но в Java этот диапазон от 127 до -128 128==-127, 129==-126, 255==-1
        // Byte.MAX_VALUE // 127
        // Byte.MIN_VALUE // -128
        String tempString1 = "кот";
        byte[] byteArray1 = tempString1.getBytes();
        System.out.println("кот в байтах " + Arrays.toString(byteArray1));

        // System.out.println("Кодировка по умолчанию: " + Charset.defaultCharset());

        // System.out.println("Все доступные кодировки: " + Charset.availableCharsets());
        System.out.println("---------------------------------------------");

        File file = new File("our_example.txt");
        OutputStream outputStream = null;
        try {
            outputStream = new FileOutputStream(file);
            outputStream.write("кот".getBytes());
        } catch (FileNotFoundException exception) {
            exception.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                outputStream.close();
            }catch (IOException e) {
                e.printStackTrace();
            }

        }

        // это try with resources т.е. этот блок catch clause он сам закроет все открытые в скобках у try потоки
        try (OutputStream outputStream1 = new FileOutputStream("new_file.txt")) {
            outputStream1.write(1); // записать в файл 1 байт
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // а сейчас попробуем записать в файл 5 МБ, т.е. берем один байт какой-то и умножаем его 5 раз 1024*1024
//        long time = System.currentTimeMillis(); // в переменную записали текущее время в милисекундах
//        try (OutputStream outputStream2 = new FileOutputStream("fivembs.txt")) {
//            for (int i = 0; i < 5 * 1024 *1024; i++){
//                outputStream2.write(65);
//            }
//        } catch (FileNotFoundException e) {
//            throw new RuntimeException(e);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//        System.out.println("Время записывания в файл 5 МБ - " + (System.currentTimeMillis() - time));
//
//        // такая же запись 5 МБ только с буферизацией
//        long timeBuffered = System.currentTimeMillis();
//        try (OutputStream outputStream3 = new BufferedOutputStream(new FileOutputStream("fivembsbuf.txt"))) {
//            for (int i = 0; i < 5 * 1024 * 1024; i++) {
//                outputStream3.write(65);
//            }
//        } catch (FileNotFoundException e) {
//            throw new RuntimeException(e);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//        System.out.println("Время записывания в файл 5 МБ с буферизацией - " + (System.currentTimeMillis() - timeBuffered));

        try (InputStream inputStream = new BufferedInputStream(new FileInputStream("51.txt"))) {
            System.out.println((char) inputStream.read());
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}
