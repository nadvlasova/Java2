package lesson5;

import java.io.File;
import java.io.IOException;

public class FileExamples {
    public static void main(String[] args) throws IOException {
        // File file = new File("51.txt");  // параметр имя
        File file = new File("/home/nadezhda/IdeaProjects/Java2/51.txt");  // параметр абсолютный путь(ПКМ по файлу и copy Path)
        System.out.println(file.exists());  // проверка существует ли?
        System.out.println(file.isAbsolute());  // проверка путь точно абсолютный?
        System.out.println(file.length()); // длина в байтах cat-3 байта, кот-6 байт почему - очередность алфавитов в списке кодировки

        File file1 = new File("52.txt");
        file1.createNewFile();  // тут сначала была ошибка, мы её "выбросили из метода" ??? не try catch в вариантах
        // file1.delete(); // удалит сразу
        // file1.deleteOnExit(); // удалит файл после завершения работы программы

        System.out.println("----------------------------------------------");

        File fileDir = new File("dir52");
        System.out.println(fileDir.exists());
        System.out.println(fileDir.isDirectory());

        System.out.println("Размер содержимого папки до её создания: " + fileDir.length()); // сказал это выдает некорректное значение

        System.out.println("Размер содержимого папки 1 после её создания: " + fileDir.length());
        // System.out.println("Размер содержимого папки 2 после её создания: " + fileDir.length());
        for (File fileTemp : fileDir.listFiles()) {
            System.out.println(fileTemp.getName() + " имеет размер " + fileTemp.length());
        }

        File fileDir2 = new File("dir51");
        fileDir2.mkdir();

        File fileDirSome = new File("dir53/1/2/3");
        fileDirSome.mkdirs(); // создаст папку 53 с вложенными в неё папками 1, 2, 3


    }
}



















