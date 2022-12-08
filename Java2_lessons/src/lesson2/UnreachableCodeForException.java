package lesson2;

public class UnreachableCodeForException {
    public static void main(String[] args) {
        try {
            int a =0;
            int b = 42 / a;
        } catch (Exception e) {
            System.out.println("Exception");
        } // catch (ArithmeticException e) {  // ошибка компиляции: недостижимый код ! т.к. исключение перехвачено первым catch
            System.out.println("Этот код недостижимый!");

    }
}
