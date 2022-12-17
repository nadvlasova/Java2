package lesson1.game1;

public class Car implements CanRun, CanSwim {
    private String name;
    private int maxSpeed;
    private int swimSpeed;

    @Override
    public double run(int length, int height) {
        return maxSpeed * length;
    }

    public Car(String name, int maxSpeed, int swimSpeed) {
        this.name = name;
        this.maxSpeed = maxSpeed;
        this.swimSpeed = swimSpeed;
    }

    @Override
    public double swim(int length) {
        return swimSpeed * length;
    }
}
