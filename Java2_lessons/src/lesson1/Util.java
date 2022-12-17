package lesson1;
// Новый класс утилитарный т.е. общий для всех классов пакета,
// в нем будем изменять возраст всех, прибавлять к возрасту 1 год

public class Util {
    public static void makeAnimalOlder(Animal animal) {
        animal.setAge(animal.getAge() + 1);
    }
}
