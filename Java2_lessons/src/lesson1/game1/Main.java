package lesson1.game1;

public class Main {
    public static void main(String[] args) {
        Cat cat = new Cat("Tom", 80, 10);
        Dog dog = new Dog("Sharik", 100, 10);
        Car car = new Car("Mazda", 120, 1);

        Road[] roads = {new Road(1000, 10), new Road(800, 120)};
        Pool[] pools = {new Pool(1000), new Pool(400)};

        double dogTime = 0;
        double catTime = 0;
        double carTime = 0;

        for (Road road : roads) {
            dogTime = dogTime + road.getTimeToOvercomeRoad(dog);
            catTime += road.getTimeToOvercomeRoad(cat);
            carTime += road.getTimeToOvercomeRoad(car);
        }

        for (Pool pool : pools) {
            dogTime = dogTime + pool.getTimeToOvercomePool(dog);
            catTime += pool.getTimeToOvercomePool(cat);
            catTime += pool.getTimeToOvercomePool(car);

        }

        System.out.println("Time dog " + dogTime);
        System.out.println("Time cat " + catTime);
        System.out.println("Time car " + carTime);
    }
}
