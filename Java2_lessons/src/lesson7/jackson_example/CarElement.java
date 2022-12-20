package lesson7.jackson_example;

public class CarElement {
    private String value;

    public CarElement(String value) {
        this.value = value;
    }

    public CarElement() {
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
