package lesson2;

public class ManyException {
    public static void main(String[] args) {
        try {
            int a = 10;
            // a -= 9  // Так сработает исключение Ошибка индексации массива
            a -= 10;  // А так сработает исключение Деление на ноль
            int b = 42 / a;
            int[] c = {1, 2, 3};
            c[42] = 99;
        } catch (ArithmeticException  | ArrayIndexOutOfBoundsException e) { // Многократный перехват исключений
            System.out.println("Деление на ноль : " + e);
//        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Ошибка индексации массива : " + e);
        }
        System.out.println("После блока операторов try/catch");
    }
}
