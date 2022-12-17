package lesson2;

public class Main {
    public static void main(String[] args) {
        // int a = 51/0; Java exception
        test();
    }
    // Стек вызовов

    public static void test() {
        System.out.println("test");
        test1();

    }

    public static void test1() {
        test2();
        System.out.println("test1");
    }

    public static void test2() {
        test3();
        System.out.println("test2");
    }
    public static void test3() {
        System.out.println("test3");
        // int a = 51/0;
        StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
        for (StackTraceElement stackTraceElement : stackTraceElements) {
            System.out.println(stackTraceElement.getMethodName() + " " + stackTraceElement.getLineNumber());
        }

    }
}
