package lesson7.jackson_example;
// Гнттеры, Сеттеры  и конструктор по умолчанию обязательны!!!

import com.fasterxml.jackson.annotation.*;

@JsonIgnoreProperties(ignoreUnknown = true) // Этим мы игнорируем неизвестные поля.
@JsonInclude(JsonInclude.Include.NON_NULL) // это скроет поля со значением null
@JsonRootName("car") // Это чтобы при оборачивании объекта json в родительский класс, имя класса было с маленькой буквы
public class Car {
    private Seat seat;
    private String color;
    @JsonProperty("model") // аннотацией переопределяем имя поля
    private String type;
    //@JsonIgnore // не хотим куда либо передавать это значение
    private boolean active;

    public Car() {
    }

    public Seat getSeat() {
        return seat;
    }

    public void setSeat(Seat seat) {
        this.seat = seat;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }


    public Car(String color, String type) {
        this.color = color;
        this.type = type;

    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Car{" +
                "color='" + color + '\'' +
                ", type='" + type + '\'' +
                ", is_active=" + active +
                '}';
    }
}
