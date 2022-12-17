package lesson3;

import lesson3.gen_interfaces.Animal;

import java.util.Arrays;

public class Cat extends Animal implements Comparable<Cat> {
    private String name;
    private int age;

    public Cat(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public static void main(String[] args) {
        Cat[] cats = new Cat[]{new Cat("Tom", 1), new Cat("Bob", 2), new Cat("Queen", 3)};

        // Захотелось нам этих котов отсоритровать, а они не сортируемые, нужно в класс имплементировать метод Compare
        Arrays.sort(cats);
        System.out.println(Arrays.toString(cats)); // вывод объектов класса, придется создать метод toString для класса
    }

    @Override
    public int compareTo(Cat cat) {
        //return cat.age - this.age;// какой-то интересный, странный метод сортировки, в результате сортировка по убыванию
        return this.age - cat.age; // а так сортировка по возрастанию
    }

}
