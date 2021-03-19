package geekbrains.lesson_1_6.animal;

public abstract class Animal {
    private final String name;
    private final int runMaxMeters;
    private final int swimMaxMeters;

    public Animal(String name, int runMaxMeters, int swimMaxMeters) {
        this.name = name;
        this.runMaxMeters = runMaxMeters;
        this.swimMaxMeters = swimMaxMeters;
    }

    public void run(int distance) {
        boolean checkCase = distance <= runMaxMeters;
        System.out.printf("%s ran %s meters (%s)", name, distance, checkCase);
    }

    public void swim(int distance) {
        boolean checkCase = distance <= runMaxMeters;
        System.out.printf(" and swam %s meters (%s) %n", distance, checkCase);
    }
}
