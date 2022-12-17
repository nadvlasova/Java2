package lesson3;

import lesson3.gen_interfaces.Animal;

public class banUsage {
    public static void main(String[] args) {
        Object[] array = new java.lang.String[]{"abc", "123"};
        array[0] = "def";
        // array[51] = 123;  // ArrayStoreException

        // GenericBox<Sting>[] genericBoxes = new GenericBox<String>[]{new GenericBox<>("a"), new GenericBox<>("b")};
        // Нельзя создавать массив Дженериков, как я поняла, потому что в Дженерик могут положить объекты разных типов
        // без приведения к одному типу
//        Object[] array1 = new GenericBox<String>[10];
//        array1[51] = new GenericBox<String>("nnn");
//        array1[0] = new GenericBox<Integer>(51);

        // 2 новых понятия : ковариантность(работает наследование) и инвариантность(не работает наследование)
        // Ковариантность
        Cat cat1 = new Cat("Sam", 7);
        Animal animal = cat1; // можем в ссылку родительского типа положить ссылку объекта класса потомка
        // Инвариантность у Дженериков
        GenericBox<Integer> genericBox = new GenericBox<>(1);
        // GenericBox<Number> genericBox1 = genericBox; // не можем в ссылку родительского типа положить ссылку объекта класса потомка

    }
}
