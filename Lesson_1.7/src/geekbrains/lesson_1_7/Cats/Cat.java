package geekbrains.lesson_1_7.Cats;

public class Cat {
    private final String name;
    private int appetite;
    private boolean isFedUp;

    public Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
    }

    public void eat(Plate plate) {
        isFedUp = plate.decreaseFood(appetite);
    }

    public boolean isFedUp() {
        return isFedUp;
    }

    public String getName() {
        return name;
    }
}
