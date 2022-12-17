package lesson2;

public class Throw {
    public static void main(String[] args) {
        try {
            throw new NullPointerException("NPE Test");
        } catch (NullPointerException e) {
            System.out.println("Catch block");
        }
    }
}
