package Lesson04;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Employee[] employee = new Employee[5];
        employee[0] = new Employee("Петров Петр Петрович", "Дворник", 2223344, 20000, 40);
        employee[1] = new Employee("Иванов Иван Иваныч", "Управдом", 2221212, 35000, 45);
        employee[2] = new Employee("Алексеев Алексей Алексеевич", "Сантехник", 2223030, 30000, 25);
        employee[3] = new Employee("Борисов Борис Борисович", "Пенсионер", 2224321, 10000, 60);
        employee[4] = new Employee("Екатеринина Екатерина Екатериновна", "Бухгалтер", 2225555, 25000, 35);
        System.out.println("ФИО: " + employee[0].getName() + ", Должность: " + employee[0].getPosition());
        System.out.println("ФИО: " + employee[1].getName() + ", Должность: " + employee[1].getPosition());
        System.out.println("ФИО: " + employee[2].getName() + ", Должность: " + employee[2].getPosition());
        System.out.println();
        overFourty(employee);
        System.out.println();
        changeSalary(employee);
    }


    public static void overFourty(Employee[] employees) {
        int j = 0;
        System.out.println("Сотрудники старше 40 лет:");
        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getAge() > 40) {
                System.out.println(employees[i].getAllInfo());
                j++;
            }
        }
        if (j == 0)
            System.out.println("Сотрудников старше 40 лет нет");
    }

    public static void changeSalary(Employee[] employees) {
        int j = 0;
        System.out.println("Сотрудники старше 35 лет, которым была увеличена зарплата на 10 000:");
        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getAge() > 35) {
                employees[i].setSalary(10000);
                System.out.println(employees[i].getAllInfo());
                j++;
            }
        }
        if (j == 0)
            System.out.println("Сотрудников старше 35 лет нет");
    }
}
