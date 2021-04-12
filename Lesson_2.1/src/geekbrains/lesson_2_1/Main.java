package geekbrains.lesson_2_1;

import Activity.Action;
import Contestants.Cat;
import Contestants.Human;
import Contestants.Robot;
import Equipment.Training_machines;
import Equipment.Treadmill;
import Equipment.Wall;

import java.util.Objects;

public class Main {

    /** 1. Создайте три класса Человек, Кот, Робот, которые НЕ наследуются от одного класса.
     *  Эти классы должны уметь бегать и прыгать (методы просто выводят информацию о действии в консоль).
     *  2. Создайте два класса: беговая дорожка и стена, при прохождении через которые,
     *  участники должны выполнять соответствующие действия (бежать или прыгать),
     *  результат выполнения печатаем в консоль (успешно пробежал, не смог пробежать и т.д.).
     *  3. Создайте два массива: с участниками и препятствиями, и заставьте всех участников пройти этот набор препятствий.
     *  4. У препятствий есть длина (для дорожки) или высота (для стены),
     *  а участников ограничения на бег и прыжки. Если участник не смог пройти одно из препятствий,
     *  то дальше по списку он препятствий не идет.
     */

    public static void main(String[] args) {
	    Human human = new Human("Dan", 3000, 1.5);
	    Cat cat = new Cat ("Bob", 5000, 1);
        Robot robot = new Robot("C3PO", 10000, 0);

        Wall wall1 = new Wall(1);
        Treadmill treadmill1 = new Treadmill((2000));
        Wall wall2 = new Wall(1.2);
        Treadmill treadmill2 = new Treadmill((4000));


        Action[] actions = {
                human,
                cat,
                robot
        };

        Training_machines[] course = {
                wall1,
                treadmill1,
                wall2,
                treadmill2,
        };

        for (Training_machines t: course) {
            if (t instanceof Wall) {
                for (Action a: actions) {
                    a.jump(t);
                }
            }
            if (t instanceof Treadmill) {
                for (Action a : actions) {
                    a.run(t);
                }
            }
        }
    }
}
