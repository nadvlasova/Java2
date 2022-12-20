package lesson7.jackson_example;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        Car car = new Car("Red", "Volvo");
        System.out.println(objectMapper.writeValueAsString(car)); // в консоль
        objectMapper.writeValue(new File("car.json"), car); // в файл

        Car carFromFile = objectMapper.readValue(new File("car.json"), Car.class);
        System.out.println(carFromFile);

        List<Car> carList1 = new ArrayList<>(Arrays.asList(new Car("Black", "BMV"),
                new Car("White", "JVT"), new Car("Red", "Subaru")));
        System.out.println("Список машин: " + carList1);
        // Серриализуем этот список машин и запишем в переменную  про сериализацию не совсем понятно, она в стр 27 или в стр 30???
        String carList = objectMapper.writeValueAsString(carList1);
        System.out.println(carList);

        List<Car> cars = objectMapper.readValue(carList, new TypeReference<List<Car>>() { });
        System.out.println("Список машин из строки: " + cars);

        // в JSON добавили ещё одно поле, год выпуска машины
        String jsonWithYear = "{\"color\":\"Red\",\"type\":\"Volvo\",\"year\":\"2000\"}";
        // Десериализуем
        // objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false); // это чтобы не выскакивала
        // ошибка из-за того, что добавили поле year, но лучше с помощью аннотации @JsonIgnoreProperties на уровне класса Car
        Car car1 = objectMapper.readValue(jsonWithYear, Car.class);
        System.out.println(car1);

        Car car2 = new Car("Green", "Lada");
        System.out.println("Машина с игнорируемым is_active " + car2);
        System.out.println("Машина с игнорируемым is_active в json " + objectMapper.writeValueAsString(car2));

        Car carWithNull = new Car(null, "BMW");
        System.out.println("Машина со скрытым полем color: " + objectMapper.writeValueAsString(carWithNull)); // т.к. поле color==null

        // После замены названия поля type на model
        String jsonWithChangeFieldName = "{\"color\":\"Green\",\"model\":\"Lada\",\"active\":false}";
        Car carWithChangeFieldName = objectMapper.readValue(jsonWithChangeFieldName, Car.class);
        System.out.println("Машина с измененным именем поля model: " + carWithChangeFieldName);

        // Обернуть объект в название класса, переопределить корневой элемент т.е. так  car: {"active":false,"model":"BMW"}
        objectMapper.enable(SerializationFeature.WRAP_ROOT_VALUE);
        System.out.println("Машина обернутая в родительский класс: " + objectMapper.writeValueAsString(carWithNull));


        Car carWithSeat = new Car("Rose", "Ferrari");
        carWithSeat.setSeat(new Seat(10));
        System.out.println("Машина с сиденьями: " + objectMapper.writeValueAsString(carWithSeat));

        // Person person = new Person("Garry", 14);
        // System.out.println(objectMapper.writeValueAsString(person)); // Exception потому, что нет геттеров и сеттеров

        String personString = "{\"name\":\"Garry\",\"age\":10}";
        Person person = objectMapper.readValue(personString, Person.class);
        System.out.println(person);




    }
}
