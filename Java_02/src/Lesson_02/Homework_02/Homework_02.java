package Lesson_02.Homework_02;

public class Homework_02 {

    public static void main(String[] args) throws MyArraySizeException {
        String[][] firstArray = {{"111", "222", "333", "444"}, {"123", "234", "345", "456"}};
        String[][] secondArray = {
                {"111", "222", "333", "444"},
                {"123", "234", "345", "456"},
                {"aaa", "bbb", "ccc", "ddd"},
                {"111", "aaa", "222", "bbb"}};
        String[][] thirdArray = {
                {"111", "222", "333", "444"},
                {"123", "234", "345", "456"},
                {"111", "222", "333", "444"},
                {"123", "234", "345", "456"}};

        try {
            testArray(firstArray);
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.out.println(e.getMessage());
//            e.printStackTrace();
        }

        try {
            testArray(secondArray);
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.out.println(e.getMessage());
//            e.printStackTrace();
        }

        try {
            testArray(thirdArray);
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.out.println(e.getMessage());
//            e.printStackTrace();
        }
    }

    private static void testArray(String[][] array) throws MyArraySizeException, MyArrayDataException {
        int result = 0;

        System.out.println("\nПроверка массива");
        if (array.length != array[0].length || array.length != 4) throw new MyArraySizeException("Массив не 4х4");
        System.out.println("Массив 4х4");

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                try {
                    result += Integer.parseInt(array[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException("В ячейке [" + j + "][" + i + "] не число");
                }
            }
        }
        System.out.println("Сумма = " + result);
    }
}

class MyArraySizeException extends Exception {
    MyArraySizeException(String message) {
        super(message);
    }
}

class MyArrayDataException extends Exception {
    MyArrayDataException(String message) {
        super(message);
    }
}
