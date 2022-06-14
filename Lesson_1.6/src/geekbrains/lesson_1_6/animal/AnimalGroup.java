package geekbrains.lesson_1_6.animal;

public class AnimalGroup {
    private Animal[] animals;
    private AnimalCounter counter;

    public AnimalGroup() {
        animals = new Animal[0];
        counter = new AnimalCounter();
    }

    public Animal[] getAnimals() {
        return animals;
    }

    public AnimalCounter getCount() {
        return counter;
    }

    public void add(Dog... toAddAnimals) {
        Animal[] newAnimals = copyAndExtend(toAddAnimals.length);

        for (int i = animals.length; i < newAnimals.length; i++) {
            newAnimals[i] = toAddAnimals[i - animals.length];
            counter.incDogs();
        }

        animals = newAnimals;
    }

    public void add(Cat... toAddAnimals) {
        Animal[] newAnimals = copyAndExtend(toAddAnimals.length);

        for (int i = animals.length; i < newAnimals.length; i++) {
            newAnimals[i] = toAddAnimals[i - animals.length];
            counter.incCats();
        }

        animals = newAnimals;
    }

    private Animal[] copyAndExtend(int toAddAnimalLength) {
        Animal[] newAnimals = new Animal[animals.length + toAddAnimalLength];
        for (int i = 0; i< animals.length; i++) {
            newAnimals[i] = animals[i];
        }

        return newAnimals;
    }
}


