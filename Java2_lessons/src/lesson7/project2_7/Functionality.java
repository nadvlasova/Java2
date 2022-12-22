package lesson7.project2_7;

public enum Functionality {
    GET_CURRENT_WEATHER("1"),
    GET_WEATHER_IN_NEXT_FIVE_DAYS("2"),
    GET_SAVED_WEATHER_DATA("3");


    public String numberInUserInterface;

    // конструктор для добавления простого значения(1, 2) отображения комманд для пользовательского отображения
    Functionality(String i) {
        numberInUserInterface = i;
    }

    public static Functionality fromValue(String value) {
        for (Functionality functionality : values()) {
            if (functionality.numberInUserInterface.equalsIgnoreCase(value)) {
                return functionality;
            }
        }
        return null;
    }
}
