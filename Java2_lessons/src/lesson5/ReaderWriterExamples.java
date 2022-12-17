package lesson5;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class ReaderWriterExamples {
    public static void main(String[] args) {
        try (OutputStream out = new FileOutputStream("53.txt")) {
            out.write("Привет мир!".getBytes());
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // тут можно указать кодировку UTF_8
        try (InputStreamReader in = new InputStreamReader(new FileInputStream("53.txt"), StandardCharsets.UTF_8)) {
            int x;
            while ((x = in.read()) != -1) {
                System.out.print((char) x);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // можно считывать файл построчно readLine только в классе BufferedReader
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("53.txt"))) {
            System.out.println(bufferedReader.readLine());
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        ArrayList<Student> studentArrayList = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("students.txt"))) {
            String tempString; // сюда мы будем считывать строку
            while ((tempString = bufferedReader.readLine()) != null) {
                // tempString = bufferedReader.readLine(); // Это считывание одного студента, без цикла
                // создаем конструктор студента, куда будем ложить отдельно его имя, фамилию, возраст
                String[] values = tempString.split(" "); //делим строку по пробелу, чтобы отделить значения : имя, фамилия, возраст
                studentArrayList.add(new Student(values[0], values[1], values[2]));
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // Класс с помощью которого можно записывать значения в файл
        try (PrintWriter out = new PrintWriter("students_new.txt")) {
            for (Student student : studentArrayList) {
                out.println(student);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        System.out.println(studentArrayList);
    }
}
