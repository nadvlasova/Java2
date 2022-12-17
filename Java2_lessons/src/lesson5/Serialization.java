package lesson5;

import java.io.*;

public class Serialization {
    public static void main(String[] args) {
        File file = new File("student");
        Student student = new Student("Garry", "Potter", "15");

        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(file))) {
            objectOutputStream.writeObject(student);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(file))) {
            Student readedStudent = (Student) objectInputStream.readObject();
            System.out.println(readedStudent);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

}
