package lesson1;

public class Cat extends Animal implements CanSwim, CanRun{
//    private String name;
//    private int age;
//    private String color;
    private boolean isWild;

    public Cat() {
    }

    public Cat(String name, int age, String color) {
        super(name, age, color);
        this.isWild = false;
    }

    public boolean isWild() {
        return isWild;
    }

    public void setWild(boolean wild) {
        isWild = wild;
    }

    @Override
    public void voice(){
        System.out.println("Cat meow");
    }

    public void jump() {
        System.out.println("Cat jumping.");
    }

    @Override
    public void swim() {
        System.out.println("Cat swimming!");
    }

    @Override
    public void run() {
        System.out.println("Cat running!");
    }
}
