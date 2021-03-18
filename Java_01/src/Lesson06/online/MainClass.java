package Lesson06.online;

//import lesson5.online.Archer;
//import lesson5.online.Mage;
//import lesson5.online.Paladin;
//import lesson5.online.Titan;
//import lesson5.online.models.HeroKingdom;

import java.io.*;
import java.util.Scanner;

/**
 * Created by Aleksandr Gladkov [Anticisco]
 * Date: 03.02.2021
 */

public class MainClass {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

//        HeroKingdom archer = new Archer("Archer", 100, 200, 50);
//        HeroKingdom paladin = new Paladin("Paladin", 500, 100, 150);
//        HeroKingdom mage = new Mage("Mage", 50, 1000, 200);
//        HeroKingdom titan = new Titan("Titan", 1000, 1000, 1000, 500);
//
//        HeroKingdom[] army = new HeroKingdom[4];
//        army[0] = paladin;
//        army[1] = titan;
//        army[2] = archer;
//        army[3] = mage;
//
//        for (int i = 0; i < army.length; i++) {
//            army[i].attack();
//            if (army[i] instanceof Titan) {
//                ((Titan) army[i]).bigAttack();
//            }
//        }
//
//        int myInt = 10;
//        String myString = "HELLO!!!";
//
//
//        Object[] arrayObject = new Object[3];
//        arrayObject[0] = myInt;
//        arrayObject[1] = myString;
//        arrayObject[2] = archer;
//
//        for (int i = 0; i < arrayObject.length; i++) {
//            if (arrayObject[i] instanceof String) {
//                System.out.println(((String)arrayObject[i]).toLowerCase());
//            }
//        }
//        String s0 = "Hello_world";
//        String s1 = "Hello";
//        s1 += "_world";
//        String s2 = scanner.nextLine();//Hello_world
//        String s3 = "Hello_world";

//        System.out.println(s0 == s1);
//        System.out.println(s0 == s2);
//        System.out.println(s0 == s3);

//        System.out.println(s0.equals(s1));
//        System.out.println(s0.equals(s2));
//        System.out.println(s0.equals(s3));

//        long startTime = System.nanoTime();
//        String example = "Example"; //String example = new String("Example");
//
//        for (int i = 0; i < 50000; i++) {
//            example += i;
//        }
//
//        float deltaTime = System.nanoTime() - startTime;
//        System.out.println(example);
//        System.out.println("Work time: " + deltaTime * 0.000001f + " millisec");
//
//        StringBuilder example1 = new StringBuilder("Example");
//
//        startTime = System.nanoTime();
//
//        for (int i = 0; i < 50000; i++) {
//            example1.append(i);
//        }
//
//        deltaTime = System.nanoTime() - startTime;
//        System.out.println(example1.toString());
//        System.out.println("Work time StringBuilder: " + deltaTime * 0.000001f + " millisec");
//        System.out.println(example.equals(example1.toString()));
        System.out.println("Start");
//
//        int a = 10;
//
//        int b = doS(scanner);
//
//        if (b != 0) {
//            System.out.println(a/b);
//        }
//        try {
//            System.out.println(10/0);
//        } catch (ArithmeticException exception) {
//            System.out.println("Division by Zero! Error! Pls enter correct data! Cause: " + exception.getMessage());
//        }

//        doSomething();
//
//        InputStream io;
//        OutputStream os;
//
//        FileInputStream fis; //read;
//        FileOutputStream fos; //write;
////
//        try {
//            FileOutputStream fileOutputStreamMain = new FileOutputStream("text.txt", true);
//            PrintStream printStreamMain = new PrintStream(fileOutputStreamMain);
//
//            FileOutputStream fileOutputStreamSecond = new FileOutputStream("text.txt", true);
//            PrintStream printStreamSecond = new PrintStream(fileOutputStreamSecond);
//
////            byte[] myString = "Hello_world! Java!".getBytes();
//
//            printStreamMain.println("This is main thread");
//            printStreamSecond.println("This is second thread");
//
////            fileOutputStream.write(myString);
//
////            fileOutputStream.flush();
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//
        try {
            FileInputStream fileInputStream = new FileInputStream("text.txt");
            int output;
            while ((output = fileInputStream.read()) != -1) {
                System.out.print((char) output);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

//
//        System.out.println("End");
//
//        Scanner scanner = new Scanner(System.in);
//        scanner.close();
    }

//    public static int doS(Scanner scanner) {
//        String tmp = scanner.nextLine();
//        int outputValue;
//        ///....
//        outputValue = Integer.parseInt(tmp);
//        return outputValue;
//    }

//    public static void doSomething() throws ArrayIndexOutOfBoundsException {
//        ///....
//        try {
//            throw new ArrayIndexOutOfBoundsException("Лови исключение!");
//        } catch (Exception exception){
//
//        }catch (NullPointerException nullPointerException) {
//
//        }
//    }
}

/*
1.	Создать 2 текстовых файла, примерно по 50-100 символов в каждом (особого значения не имеет);
2.	Написать программу, «склеивающую» эти файлы, то есть вначале идет текст из первого файла, потом текст из второго.
3.	* Написать программу, которая проверяет присутствует ли указанное пользователем слово в файле.
4.  ** Написать метод, проверяющий, есть ли указанное слово в папке
*/
