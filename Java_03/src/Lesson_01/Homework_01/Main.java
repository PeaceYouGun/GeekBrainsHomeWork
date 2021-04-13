package Lesson_01.Homework_01;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        // 1. Написать метод, который меняет два элемента массива местами.(массив может быть любого ссылочного типа);
        String[] arr = {"text01", "123", "mix123", "text02", "456"};
        System.out.println("\nЗадача 1:\nВ следующем массиве поменяем 2 и 3 элементы:\n" + Arrays.toString(arr));
        changeArr(arr, 1, 2);
        System.out.println("Результат:\n" + Arrays.toString(arr));

        // 2. Написать метод, который преобразует массив в ArrayList;
        List<String> list = changeArrToList(arr);
        System.out.println("\nЗадача 2:\nТеперь" + list + " это " + list.getClass());

        // 3. Большая задача
        System.out.println("\nЗадача 3:");
        Box<Apple> appleBox1 = new Box();
        Box<Apple> appleBox2 = new Box();
        Box<Orange> orangeBox1 = new Box();
        Box<Orange> orangeBox2 = new Box();

        for (int i = 0; i < 3; i++) {
            appleBox1.add(new Apple());
        }
        for (int i = 0; i < 6; i++) {
            appleBox2.add(new Apple());
        }
        for (int i = 0; i < 2; i++) {
            orangeBox1.add(new Orange());
        }
        for (int i = 0; i < 4; i++) {
            orangeBox2.add(new Orange());
        }

        System.out.println("В 1 коробке количество яблок: " + appleBox1.getNumber() + " и ее вес: " + appleBox1.getWeight());
        System.out.println("Во 2 коробке количество яблок: " + appleBox2.getNumber() + " и ее вес: " + appleBox2.getWeight());
        System.out.println("В 1 коробке количество апельсин: " + orangeBox1.getNumber() + " и ее вес: " + orangeBox1.getWeight());
        System.out.println("Во 2 коробке количество апельсин: " + orangeBox2.getNumber() + " и ее вес: " + orangeBox2.getWeight());

        System.out.println("\nСравниваем вес коробок с яблоками и с апельсинами");
        System.out.println("appleBox1 = orangeBox1: " + appleBox1.compare(orangeBox1));
        System.out.println("appleBox1 = orangeBox2: " + appleBox1.compare(orangeBox2));
        System.out.println("appleBox2 = orangeBox1: " + appleBox2.compare(orangeBox1));
        System.out.println("appleBox2 = orangeBox2: " + appleBox2.compare(orangeBox2));

        System.out.println("\nПересыпаем яблоки и апельсины");
        appleBox1.transfer(appleBox2);
        orangeBox2.transfer(orangeBox1);
        System.out.println("В 1 коробке количество яблок: " + appleBox1.getNumber() + " и ее вес: " + appleBox1.getWeight());
        System.out.println("Во 2 коробке количество яблок: " + appleBox2.getNumber() + " и ее вес: " + appleBox2.getWeight());
        System.out.println("В 1 коробке количество апельсин: " + orangeBox1.getNumber() + " и ее вес: " + orangeBox1.getWeight());
        System.out.println("Во 2 коробке количество апельсин: " + orangeBox2.getNumber() + " и ее вес: " + orangeBox2.getWeight());

    }

    private static <T> void changeArr(T[] array, int firstElement, int secondElement) {
        T t = array[firstElement];
        array[firstElement] = array[secondElement];
        array[secondElement] = t;
    }

    private static <T> List<T> changeArrToList(T[] array) {
        return Arrays.asList(array);
    }
}
