package geekbrains.lesson_1_5;

/**1. Создать класс "Сотрудник" с полями: ФИО, должность, email, телефон, зарплата, возраст.
   2. Конструктор класса должен заполнять эти поля при создании объекта.
   3. Внутри класса «Сотрудник» написать метод, который выводит информацию об объекте в консоль.
   4. Создать массив из 5 сотрудников.
   Пример:
   Person[] persArray = new Person[5]; // Вначале объявляем массив объектов
   persArray[0] = new Person("Ivanov Ivan", "Engineer", "ivivan@mailbox.com", "892312312", 30000, 30); // потом для каждой ячейки массива задаем объект
   persArray[1] = new Person(...);
   ...
   persArray[4] = new Person(...);

   5. С помощью цикла вывести информацию только о сотрудниках старше 40 лет.
 *

 */

public class Main {

    public static void main(String[] args) {
        Employee[] employees = {
                new Employee("Ivan", "Software Engineer", "ivarius@gmail.com", "+79295674534", 180000, 28),
                new Employee("Igor", "Team Leader", "itlink@gmail.com", "+79065677889", 250000, 41),
                new Employee("Nickolay", "Junior Programmer", "nicktargh@gmail.com", "+79156102938", 100000, 23),
                new Employee("Stanislav", "Data Analyst", "mrstan248@gmail.com", "+79056758493", 150000, 26),
                new Employee("Sergey", "Security Guard", "serovish@mail.ru", "+79164773890", 40000, 49),
        };

        for (int i=0; i< employees.length; i++) {
            if (employees[i].checkAge()>=40){
                employees[i].getInfo();
            }
        }
    }
}
