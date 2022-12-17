package lesson4;

import java.util.HashMap;

public class HashMapExample {
    public static void main(String[] args) {
        HashMap<String, Integer> passportDate = new HashMap<>();
        passportDate.put("Garry", 1234);
        passportDate.put("Ron", 2345);
        passportDate.put("Germiona", 3456);

        System.out.println(passportDate);

        passportDate.put("Garry", 7777);
        System.out.println(passportDate);

        System.out.println("Номер паспорта Garry: " + passportDate.get("Garry"));

        for(String key : passportDate.keySet()){
            System.out.println(passportDate.get(key));
        }

        HashMap<Integer, String> newHashmap = new HashMap<>();
        newHashmap.put(1, "a");
        newHashmap.put(2, "2");
        newHashmap.put(3, "Abc123");
        System.out.println(newHashmap);
    }


}
