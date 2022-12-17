package lesson2;

public class OutException {
    public static void main(String[] args) {
        System.out.println("Начало!");
        try {
            int a = 0;
            int b = 42 / a;
        } catch (ArithmeticException e) {
            e.printStackTrace();
        }
        System.out.println("Конец!");
    }

}
