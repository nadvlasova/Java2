package lesson3;

// Обобщения - это параметризованные типы, которые позволяют объявлять обобщенные классы,
//интерфейсы и методы, где тип данных, которыми они оперируют, указан в виде параметра.
public class GenericBox<T> {
    private T object;
    // static T param; нельзя создавать статические переменные с типом Generic  ЗТО НЕ СОВСЕМ ПОНЯТНО!!!!

    public GenericBox(T object) {
        this.object = object;
    }

    public T getObject() {
        return object;
    }

    public void setObject(T object) {
        // T test = new T();  не можем создавать объект класса типа Generic
        this.object = object;
    }

    public static void main(String[] args) {
        GenericBox<Integer> genericBox1 = new GenericBox<>(10);
        GenericBox<Integer> genericBox2 = new GenericBox<>(20);

        // genericBox1.setObject("String"); // Сразу ошибка

        System.out.println(genericBox1.getClass().getName());
        System.out.println(genericBox1.getObject() + genericBox2.getObject());

    }



}

