package lesson1;

public class Main {
    public static void main(String[] args) {
        Cat cat1;
        cat1 = new Cat();
//        System.out.println("Name cat: " + cat1.name);
//        System.out.println("Age cat: " + cat1.age);
//        Cat cat2 = cat1;
//        cat2.name = "Tom";
//        System.out.println("Name cat1: " + cat1.name);
//        cat1.setAge(-4);
//        System.out.println("Age cat1: " + cat1.getAge());

//        cat1.setName("Garfild");
//        cat1.setAge(9);
//        cat1.setColor("Orange");
//        System.out.println("Name cat: " + cat1.getName());
//        System.out.println("Age cat: " + cat1.getAge());
//        System.out.println("Color cat: " + cat1.getColor());
//        System.out.println("--------------");
//
//        Cat cat2 = new Cat("Tom", 7, "Black");
//        System.out.println("Name cat: " + cat2.getName());
//        System.out.println("Age cat: " + cat2.getAge());
//        System.out.println("Color cat: " + cat2.getColor());
//        System.out.println("--------------");
//
//        Cat cat3 = new Cat();
//        cat3.setName("Queen").setAge(3).setColor("White");
//        System.out.println("Name cat: " + cat3.getName());
//        System.out.println("Age cat: " + cat3.getAge());
//        System.out.println("Color cat: " + cat3.getColor());


        cat1.setName("Garfild");
        cat1.setAge(9);
        cat1.setColor("Orange");
        System.out.println("Name cat: " + cat1.getName());
        System.out.println("Age cat: " + cat1.getAge());
        System.out.println("Color cat: " + cat1.getColor());
        System.out.println(cat1.getName() + " is home animal - " + cat1.isWild());
        cat1.voice();
        System.out.println("--------------");

        Wolf wolf = new Wolf();
        wolf.setAge(4);

        Util.makeAnimalOlder(cat1);
        System.out.println("Name : " + cat1.getName());
        System.out.println("Age : " + cat1.getAge());
        System.out.println("Color : " + cat1.getColor());
        System.out.println("--------------");
        Util.makeAnimalOlder(wolf);
        System.out.println("Name : " + wolf.getName());
        System.out.println("Age : " + wolf.getAge());
        System.out.println("Color : " + wolf.getColor());
        wolf.voice();
        System.out.println("--------------");



    }
}
