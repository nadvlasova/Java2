package lesson3;

public class BoxWithNumbers <T extends Number>{
    private T[] numbs;

    // public BoxWithNumbers(T[] numbs) {
    public BoxWithNumbers(T... numbs) { // T...-Синтаксический сахар, позволяющий передавать в метод переменное количество значений.
        this.numbs = numbs;
    }

    public T[] getNumbs() {
        return numbs;
    }

    public void setNumbs(T[] numbs) {
        this.numbs = numbs;
    }

    public double avg() {
        double sum = 0.0;
//        for(T numb : numbs) {
//            sum += numb.doubleValue();
//        }
        for (int i = 0; i < numbs.length; i++) {
            sum += numbs[i].doubleValue();
        }
        return sum / numbs.length;
    }

    // public static void test(int a, int...b) {
 //   }
    // Этот метод проверяет различаются ли средние значения массивов у коробок intBox int Box1, они обе Integer,
    //поэтому в <T> будет Integer , Math.abs для если число отрицательное не можем сравнить с коробкой doubleBox
//    public boolean isSameAvg(BoxWithNumbers<T> box) {
//        return Math.abs(this.avg() - box.avg()) < 0.0001;
//    }

    // А теперь сможем сравнить коробки разных типов , но одного класса Number благодаря <?> Wildcards
    // варианты <? extends Integer>, <? extends Number> - (это Number и все кто от него унаследовался),
    // <? super Number> - Это Number и его предок, а предок его Object
    public boolean isSameAvg(BoxWithNumbers<?> box) {
        return Math.abs(this.avg() - box.avg()) < 0.0001;
    }

    // Пишем метод, который будет возвращать первый элемент коробки.
    public static <U extends Number> U getFirstElement(BoxWithNumbers<U> boxWithNumbers) {
        return boxWithNumbers.numbs[0];
    }
    public static void main(String[] args) {
        // test(1, 2, 3, 4 );
        BoxWithNumbers<Integer> intBox = new BoxWithNumbers<Integer>(1, 4, 5);
        System.out.println("Среднее значение intBox равно: " + intBox.avg());
        BoxWithNumbers<Integer> intBox1 = new BoxWithNumbers<Integer>(1, 4, 5);
        System.out.println("Среднее значение intBox1 равно: " + intBox1.avg());
        System.out.println(intBox.isSameAvg(intBox1)); // смотрим равны ли у них средние значения
        BoxWithNumbers<Double> doubleBox = new BoxWithNumbers<Double>(1.0, 4.0, 5.0);
        System.out.println("Среднее значение doubleBox равно: " + doubleBox.avg());
        System.out.println(intBox.isSameAvg(doubleBox));  // (T = Integer) != (T = Double) в методе isSameAvg

        System.out.println(BoxWithNumbers.getFirstElement(intBox));

        // А вот это не скомпилируется т.к. String не является подклассом Number
        // BoxWithNumbers<String> strBox = new BoxWithNumbers<String>("1", "2", "3");
    }
}
