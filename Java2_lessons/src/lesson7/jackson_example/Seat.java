package lesson7.jackson_example;

public class Seat extends CarElement {
    private int paramsCount;

    public int getParamsCount() {
        return paramsCount;
    }

    public void setParamsCount(int paramsCount) {
        this.paramsCount = paramsCount;
    }

    public Seat(int paramsCount) {
        super("10");
        this.paramsCount = paramsCount;
    }

    public Seat() {
        super("10");
    }
}
