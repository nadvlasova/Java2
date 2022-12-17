package lesson4;

import java.util.*;

public class Cat {
    private String name;
    private int age;

    public Cat(String name, int age) {
        this.name = name;
        this.age = age;
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

    // метод для проверки уникальности, из двух одинаковых котов добавил одного
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cat cat = (Cat) o;
        return age == cat.age && Objects.equals(name, cat.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public static void main(String[] args) {
        Cat cat1 = new Cat("Tom", 1);
        Cat cat2 = new Cat("Tom", 1);

        System.out.println(cat1.hashCode());
        System.out.println(cat2.hashCode());
        System.out.println(cat1.equals(cat2));

        HashSet<Cat> hashSet = new HashSet<>(List.of(cat1, cat2));
        System.out.println(hashSet);

        // проверяем, что можно положить в HashSet, а что нет
        HashSet<Integer> unicElements = new HashSet<>(Arrays.asList(1, 0, 2, 3, 5, 66, 0, 2, 77, 5, 99));
        System.out.println("HashSet: " + unicElements); // только уникальные и не по порядку

        LinkedHashSet<Integer> linkedHashSet = new LinkedHashSet<>(Arrays.asList(1, 0, 2, 3, 5, 66, 0, 2, 77, 5, 99));
        System.out.println("LinkedHashSet: " + linkedHashSet); // уникальные и по порядку т.е. в том порядке как их положили в коллекцию

        // теперь TreeSet он ещё и сортирует по возрастанию
        TreeSet<Integer> treeSet = new TreeSet<>(Arrays.asList(1, 0, 2, 3, 5, 66, 0, 2, 77, 5, 99));
        System.out.println("TreeSet: " + treeSet);

        // Теперь TreeSet с котами
//        TreeSet<Cat> catTreeSet = new TreeSet<>(Arrays.asList(new Cat("Tom", 51), new Cat("Bob", 2)));
//        System.out.println(catTreeSet); // без Comparator Exception

        TreeSet<Cat> catTreeSetByAge = new TreeSet<>(new CatComparatorByAge());
        catTreeSetByAge.add(new Cat("Tom", 9));
        catTreeSetByAge.add(new Cat("Samuil", 2));
        catTreeSetByAge.add(new Cat("Lili", 5));
        System.out.println("Отсортированные по возрасту коты: " + catTreeSetByAge);

        TreeSet<Cat> catTreeSetNameLength = new TreeSet<>(new CatComparatorByNameLength());
        catTreeSetNameLength.add(new Cat("Tom", 9));
        catTreeSetNameLength.add(new Cat("Samuil", 2));
        catTreeSetNameLength.add(new Cat("Lili", 5));
        System.out.println("Отсортированные по длине имени коты: " + catTreeSetNameLength);


    }
}
