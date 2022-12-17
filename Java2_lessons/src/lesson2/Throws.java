package lesson2;

import java.io.IOException;
import java.io.PrintWriter;

public class Throws {
    public static void main(String[] args) {
        try {
            createReport();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void createReport() throws IOException {
        PrintWriter pw = new PrintWriter("report.txt");
        pw.close();
    }
}
