package Lesson_05.Homework_05;

import java.util.Arrays;

public class Homework_05 {
    public static void main(String[] args) {
//        firstMethod();
//        secondMethod();
        System.out.println(firstMethod().equals(secondMethod()));
    }

    private static String firstMethod() {
        final int SIZE = 10000000;
        final int H = SIZE / 2;
        float[] arr = new float[SIZE];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
        }
//        System.out.println("Before:");
//        System.out.println(Arrays.toString(arr));

        long a = System.currentTimeMillis();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (float) (arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        System.out.println("Время выполнения первого метода: " + (System.currentTimeMillis() - a));

//        System.out.println("After:");
//        System.out.println(Arrays.toString(arr));

        return Arrays.toString(arr);
    }

    private static String secondMethod() {
        final int SIZE = 10000000;
        final int H = SIZE / 2;
        float[] arr = new float[SIZE];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
        }
        float[] arr1 = new float[H];
        float[] arr2 = new float[H];

//        System.out.println("Before:");
//        System.out.println(Arrays.toString(arr));

        long a = System.currentTimeMillis();

        System.arraycopy(arr, 0, arr1, 0, H);
        System.arraycopy(arr, H, arr2, 0, H);

        Thread th1 = new Thread(
                () -> {
                    for (int i = 0; i < arr1.length; i++) {
                        arr1[i] = (float) (arr1[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
                    }
                }
        );
        th1.start();

        Thread th2 = new Thread(
                () -> {
                    for (int i = 0; i < arr2.length; i++) {
                        arr2[i] = (float) (arr2[i] * Math.sin(0.2f + (i + H) / 5) * Math.cos(0.2f + (i + H) / 5) * Math.cos(0.4f + (i + H) / 2));
                    }
                }
        );
        th2.start();

        try {
            th1.join();
            th2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.arraycopy(arr1, 0, arr, 0, H);
        System.arraycopy(arr2, 0, arr, H, H);

        System.out.println("Время выполнения второго метода: " + (System.currentTimeMillis() - a));

//        System.out.println("After:");
//        System.out.println(Arrays.toString(arr));

        return Arrays.toString(arr);
    }
}
