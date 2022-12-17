package lesson4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class IteratorExample {
    public static void main(String[] args) {
        ArrayList<Integer> integerArrayList = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));
        for (Integer element : integerArrayList) {
            System.out.println(element);
//            if (element == 4) {
//                integerArrayList.remove(element); // без итератора Exception
//            }
        }

        Iterator<Integer> integerIterator = integerArrayList.iterator();
        while (integerIterator.hasNext()) {
            Integer element = integerIterator.next();
            if (element == 4) {
                integerIterator.remove();
            }
        }
        System.out.println(integerArrayList);

    }

}
