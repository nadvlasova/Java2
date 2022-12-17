package lesson1.game1;

public class Cat extends Animal implements CanRun, CanSwim {

    public Cat(String name, int maxSpeed, int swimSpeed) {
        super(name, maxSpeed, swimSpeed, 1);
    }

    @Override
    public double run(int length, int height) {
        if(height > 100) {
            super.setHeightCoefficient(0.9);
        } else {
            super.setHeightCoefficient(1);
        }
        return (super.getMaxSpeed() * super.getHeightCoefficient() * length);
    }

    @Override
    public double swim(int length) {
        return super.getSwimSpeed() * length;
    }
}
