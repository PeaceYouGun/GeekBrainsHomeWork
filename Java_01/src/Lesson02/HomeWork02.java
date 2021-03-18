package Lesson02;

import java.util.Random;
import java.util.Arrays;

public class HomeWork02 {
    public static void main(String[] args) {

        //  Задача 1
        int[] inputZeroOne = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        System.out.print("Task 1:\n" + "Input:\t");
        //System.out.println(Arrays.toString(inputZeroOne)); //замена моему методу вывода массива на экран
        printOneArray(inputZeroOne);
        System.out.print("Output:\t");
        printOneArray(changeZeroOne(inputZeroOne));

        //  Задача 2
        int[] inputPlusThree = new int[8];
        System.out.print("\nTask 2:\n" + "Result: ");
        printOneArray(plusThree(inputPlusThree));

        //  Задача 3
        int[] inputLessSix = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        System.out.print("\nTask 3:\n" + "Input:\t");
        printOneArray(inputLessSix);
        System.out.print("Output:\t");
        printOneArray(lessSix(inputLessSix));

        //  Задача 4
        //  По принципу атомарности кода создам два метода для вычисления минамального и максимального элемента массива
        int[] inputMinMax = {0, -7, 3, -9, 12, 4, 7, 2, -4, 8, 9, -1};
        System.out.print("\nTask 4:\n" + "Input:\t");
        printOneArray(inputMinMax);
        System.out.println("Min = " + minElement(inputMinMax) + " Max = " + maxElement(inputMinMax));

        //  Задача 5
        System.out.print("\nTask 5:\n" + "Input:\n");
        int[][] intMatrix = createArray(10, -9, 9);  // создание 2мерного массива и заполнение его рандомайзом
        printMatrix(intMatrix);
        System.out.println("Output:");
        printMatrix(oneToDiagonal(intMatrix));



    }

    //  Метод выводящий в консоль одномерный массив переданный в качестве аргумента
    public static void printOneArray(int[] arrayOne) {
        for (int i = 0; i < arrayOne.length; i++) {
            System.out.print(arrayOne[i] + "\t");
        }
        System.out.println();
    }

    //  Печатаем 2мерный массив с помощью предыдущего метода
    public static void printMatrix(int[][] arrayMatrix) {
        for (int i = 0; i < arrayMatrix.length; i++) {
            printOneArray(arrayMatrix[i]);
        }
    }

    //  Метод меняющий 1 на 0 и 0 на 1
    public static int[] changeZeroOne(int[] arrayZeroOne) {
        for (int i = 0; i < arrayZeroOne.length; i++) {
            arrayZeroOne[i] = (arrayZeroOne[i] == 0) ? 1 : 0;
        }
        return arrayZeroOne;
    }

    //  Метод +=3 к предыдущему значению
    public static int[] plusThree(int[] arrayPlusThree) {
        int j = 1;
        for (int i = 0; i < arrayPlusThree.length; i++) {
            arrayPlusThree[i] = j;
            j += 3;
        }
        return arrayPlusThree;
    }

    //  Меньше 6 -> умножаем на 2
    public static int[] lessSix(int[] arrayLessSix) {
        for (int i = 0; i < arrayLessSix.length; i++) {
            if (arrayLessSix[i] < 6)
                arrayLessSix[i] *= 2;
        }
        return arrayLessSix;
    }

    //  Поиск минимального элемента
    public static int minElement(int[] arrayMinElement) {
        int min = arrayMinElement[0];
        for (int i = 0; i < arrayMinElement.length; i++) {
            if (arrayMinElement[i] < min)
                min = arrayMinElement[i];
        }
        return min;
    }

    //  Поиск максимального элемента
    public static int maxElement(int[] arrayMaxElement) {
        int max = arrayMaxElement[0];
        for (int i = 0; i < arrayMaxElement.length; i++) {
            if (arrayMaxElement[i] > max)
                max = arrayMaxElement[i];
        }
        return max;
    }

    //  Автозаполнение квадратного целочисленного массива с помощью рандомайза
    //  n - размерность, min и max диапазон значений в матрице
    public static int[][] createArray(int n, int min, int max) {
        int[][] arrayCreate = new int[n][n];
        for (int y = 0; y < arrayCreate.length; y++) {
            for (int x = 0; x < arrayCreate[y].length; x++) {
                arrayCreate[y][x] = randElement(min, max);
            }
        }
        return arrayCreate;
    }

    //  Рандомайзер
    public static int randElement(int min, int max) {
        int diff = max - min;
        Random random = new Random();
        int i = random.nextInt(diff + 1);
        return i += min;
    }

    // Меняем значения элементов в диагоналях на 1
    public static int[][] oneToDiagonal(int[][] arrayDiagonal) {
        for (int y = 0; y < arrayDiagonal.length; y++) {
            for (int x = 0; x < arrayDiagonal[y].length; x++) {
                if (x == y || x + y == arrayDiagonal.length - 1)
                    arrayDiagonal[y][x] = 1;
            }
        }
        return arrayDiagonal;
    }
}
