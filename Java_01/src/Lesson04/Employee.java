package Lesson04;

public class Employee {
    private String name;
    private String position;
    private int phone;
    private int salary;
    private int age;
    private int id;
    private static int idClass = 1;

    Employee(String name, String position, int phone, int salary, int age) {
        this.name = name;
        this.position = position;
        this.phone = phone;
        this.salary = salary;
        this.age = age;
        id = idClass;
        idClass++;
    }

    public String getName() {
        return name;
    }

    public String getPosition() {
        return position;
    }

    public int getPhone() {
        return phone;
    }

    public int getSalary() {
        return salary;
    }

    public int getAge() {
        return age;
    }

    public void setSalary(int changeSalary) {
        salary += changeSalary;
    }

    public String getAllInfo() {
        return "ID: " + id + ", ФИО: " + name + ", Должность: " + position + ", Телефон: " + phone + ", Зарплата: " + salary + ", Возраст: " + age;
    }
}
