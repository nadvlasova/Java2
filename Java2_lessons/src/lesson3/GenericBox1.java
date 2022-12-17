package lesson3;

// Код из методички....Не совсем понятен
public class GenericBox1 <T> {
    private T obj;

    public GenericBox1(T obj) {
        this.obj = obj;
    }

    public T getObj() {
        return obj;
    }

    public void showType() {
        System.out.println("Тип Т: " + obj.getClass().getName());
    }
}

//    public class GenericsDemoApp {
//        public static void main(String[] args) {
//            GenericBox<String> genStr = new GenericBox<>("Hello!");
//            genStr.showType();
//            System.out.println("genStr.getObject() : " + genStr.getObject());
//            GenericBox<Integer> genInt = new GenericBox<>(140);
//            genInt.showType();
//            System.out.println("genInt.getObject() : " + genInt.getObject());
//            int valueFromGenInt = genInt.getObject();
//            String valueFromGenString = genStr.getObject();
//        }
//    }
