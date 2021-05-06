package Contestants;

import Activity.Action;
import Equipment.Treadmill;
import Equipment.Wall;

public class Cat implements Action {
    boolean isGoing;
    String name;
    double runability;
    double jumpability;

    public Cat(String name, double runability, double jumpability) {
        this.name = name;
        this.runability = runability;
        this.jumpability = jumpability;
        this.isGoing = true;
    }

    public void catJumps() {
        System.out.println("Cat " + name + " jumped");
    }

    public void catRuns() {
        System.out.println("Cat " + name + " ran");
    }

    public boolean isGoing() {
        return isGoing;
    }

    public void setGoing(boolean going) {
        isGoing = going;
    }

    @Override
    public void run(Object o) {
        Treadmill another = (Treadmill) o;
        if ((isGoing==true)&&(this.runability == another.getLength() || this.runability > another.getLength())) {
            System.out.println(this.name + " did it!");
        }
        if ((isGoing==false)) {
            System.out.println(this.name + " might has done it but...");
        }
        if ((isGoing==true)&&(this.runability < another.getLength())) {
            System.out.println(this.name + " failed to run the distance...");
            setGoing(false);
        }
    }

    @Override
    public void jump(Object o) {
        Wall another = (Wall) o;
        if ((isGoing==true) && (this.jumpability == another.getHeight() || this.jumpability > another.getHeight())) {
            System.out.println(this.name + " did it!");
        }
        if ((isGoing==false)) {
            System.out.println(this.name + " might has done it but...");
        }
        if ((isGoing==true) && (this.jumpability < another.getHeight())) {
            System.out.println(this.name + " failed to jump over...");
            setGoing(false);
        }
    }
}