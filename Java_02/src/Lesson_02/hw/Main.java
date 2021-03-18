package Lesson_02.hw;

/**
 * Project java_core_android
 *
 * @Author Alexander Grigorev
 * Created 28.01.2021
 * v1.0
 */
public class Main {
    public static void main(String[] args) {
        String[][] arr1 = new String[][]{
                {"4", "8", "14", "8"},
                {"9", "8", "42", "54"},
                {"98", "7", "4", "tr"},
                {"549", "1001", "-47", "-800"}};

        String[][] arr2 = new String[][]{
                {"4", "8", "14", "8", "13"},
                {"9", "8", "42", "54"},
                {"98", "7", "4", "tr", "24"},
                {"549", "1001", "-47", "-800"}};

        String[][] arr3 = new String[][]{
                {"4", "8", "14", "8"},
                {"9", "8", "42", "54"},
                {"98", "7", "4", "5"},
                {"549", "1001", "-47", "-800"}};


        try {
            ArraySummator.sum(arr1);
        } catch (Exception e) {
            e.printStackTrace();
        } catch (Throwable t) {

        }

        try {
            ArraySummator.sum(arr2);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            ArraySummator.sum(arr3);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
