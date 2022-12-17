package lesson2;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class CheckedException {
    public static void main(String[] args) {
        File file = new File("Hello!");
        InputStream inputStream;

        try {
            inputStream = new FileInputStream(file);
        } catch (FileNotFoundException exception) {
            System.out.println("Здесь можно описать тело исключения!");;
        }

        System.out.println("All is good!");

    }



}
