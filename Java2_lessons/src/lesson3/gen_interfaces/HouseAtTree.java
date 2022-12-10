package lesson3.gen_interfaces;

// <T extends Animal & Flyable> ограничиваем класс объектами класса Animal умеющими летать Flyable,
// можно ограничивать одним класом и несколькими интерфейсами
public class HouseAtTree <T extends Animal & Flyable>{
    public T owner;

    public static void main(String[] args) {
        Cat cat = new Cat();
        Eagle eagle = new Eagle();
        // Создаем домик кота, но после добавления в ограничения класса интерфеса Flyable, котик в пролете, а вот орел ОК
//        HouseAtTree<Cat> catHouseAtTree = new HouseAtTree<>();
//        catHouseAtTree.owner = cat;
        HouseAtTree<Eagle> eagleHouseAtTree = new HouseAtTree<>();
        eagleHouseAtTree.owner = eagle;
    }
}
