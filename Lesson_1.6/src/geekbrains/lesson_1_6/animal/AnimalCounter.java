package geekbrains.lesson_1_6.animal;

public class AnimalCounter {
    private int counter;
    private int cats;
    private int dogs;

    public int getCats() {
        return cats;
    }

    public int getDogs () {
        return dogs;
    }

    public int getCounter() {
        return counter;
    }

    public void incCats() {
        cats++;
        counter++;
    }

    public void incDogs() {
        dogs++;
        counter++;
    }
}
