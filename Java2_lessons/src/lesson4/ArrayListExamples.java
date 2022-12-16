package lesson4;

import java.util.ArrayList;
import java.util.Arrays;

public class ArrayListExamples {
    public static void main(String[] args) {
        ArrayList<Integer> integers = new ArrayList<>();
        System.out.println(integers.size());
        System.out.println(integers.isEmpty());
        integers.add(1);
        integers.add(2);
        System.out.println(integers);
        System.out.println(integers.size());
        ArrayList<Integer> integers1 = new ArrayList<>(Arrays.asList(1,2,3,4,5));
        System.out.println(integers1);
        integers1.set(2,99);
        integers1.add(2, 3);
        System.out.println(integers1);
        integers1.add(77);
        System.out.println(integers1);
        integers1.addAll(integers);
        System.out.println(integers1);
        System.out.println(integers.contains(3));
        System.out.println(integers1.containsAll(integers));
        integers1.remove(3);
        integers1.remove(new Integer(77));
        integers1.removeAll(integers); // удалил 1, 2 из первой коллекции и свои 1, 2 тоже удалил почему???
        System.out.println(integers1);


    }
}
