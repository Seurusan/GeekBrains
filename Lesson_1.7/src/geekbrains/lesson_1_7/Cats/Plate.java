package geekbrains.lesson_1_7.Cats;

public class Plate {
    private int capacity = 10;
    private int food = capacity;

    public Plate(int food) {
        this.food = food;
    }

    public boolean decreaseFood(int request) {
        if (request <= food) {
            food -= request;
            return true;
        }
        return false;
    }

    public void info() {
        System.out.println("There are " + food + " food points left on the plate out of max " + capacity);
    }

    //   6. Добавить в тарелку метод, с помощью которого можно
    //   было бы добавлять еду в тарелку.

    public void add(int addPortion) {
        int tempSum = addPortion + food;
        if (tempSum > capacity) {
            food = capacity;
        }
        else {
            food += addPortion;
        }
    }
}
