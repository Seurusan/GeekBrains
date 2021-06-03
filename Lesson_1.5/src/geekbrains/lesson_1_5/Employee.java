package geekbrains.lesson_1_5;

public class Employee {
    private String name;
    private String job;
    private String email;
    private String phone;
    private int payment;
    private int age;

    public Employee(String name, String job, String email,
                    String phone, int payment, int age) {
        this.name = name;
        this.job = job;
        this.email = email;
        this.phone = phone;
        this.payment = payment;
        this.age = age;
    }

    public void getInfo() {
        System.out.printf("Name - %s, position - %s, contacts - %s, %s, salary - %s, age - %s%n",
                name, job, email, phone, payment, age);
    }

    public int checkAge() {
        return age;
    }
}
