package TestPackage;

import java.util.Arrays;
import java.util.Scanner;

public class Test_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        char[] arr = text.toCharArray();
//        int cur = 0;
//        char[] newArr = new char[arr.length];

        //введите код сюда
        for (int i = arr.length - 1; i >= 0; i--) {
//            newArr[cur] = arr[i];
//            cur++;
            System.out.print(arr[i]);
        }
//        System.out.println(Arrays.toString(newArr));

    }
}
