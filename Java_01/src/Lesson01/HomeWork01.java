package Lesson01;

public class HomeWork01 {
    public static void main(String[] args) {
        System.out.println("Task1\n" + "Result = " + task1(7, 3, 6, 4));
        System.out.println("\nTask2\n" + "Result = " + task2(9, 6));
        System.out.println("\nTask3");
        System.out.println("Number is positive? " + task3(1));
        System.out.println("\nTask4\n" + task4("Вася"));
        System.out.println("\nTask5");
        System.out.println("Год високосный? " + task5(2100));
    }

    public static float task1(int a, int b, int c, int d) {
        return a * (b + ((float) c / d));
    }

    public static boolean task2(int a, int b) {
        return ((a + b) >= 10 && (a + b) <= 20);
    }

    public static boolean task3(int a) {
        return a >= 0;
    }

    public static String task4(String a) {
        return "Привет, " + a + '!';
    }

    public static boolean task5(int a) {
        return (a % 4 == 0 && a % 100 != 0 || a % 400 == 0);
    }
}