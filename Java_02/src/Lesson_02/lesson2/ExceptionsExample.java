package lesson2;

import java.util.Scanner;

/**
 * Project java_core_l2
 *
 * @Author Alexander Grigorev
 * Created 19.02.2021
 * v1.0
 */
public class ExceptionsExample {

    public static void main(String[] args) {

        try (Scanner sc = new Scanner(System.in)) {
//            vfkpdnbpdfpbnp
        }

//        try {
//            System.out.println("lkdfnv");
//        }

//        try (String s = new String("ljdfnkljdf")){
//
//        }

        try {
            throwException();
        } catch (MyCustomException e) {
//            System.out.println(e.getMessage());
        }
//some code....
    }

    private static void simpleTryExample() {
        //code....

//        divByZero();
        try {
            System.out.println("Before div");
//            throw new StackOverflowError();
            divByZero();
            System.out.println("After div");
        } catch (ArithmeticException | NullPointerException e) {
            System.out.println("Catch it!!!");
            return;
        } finally {
            System.out.println("finally");
        }

//        System.out.println("After exception");
        //code..
    }

    static void divByZero() {
        //some code...

        int a = 10 / 0;
        System.out.println(a);

        //some code...
    }

    static void throwException() throws MyCustomException {
       // MyCustomException ex = new MyCustomException("JFOJEBOJFB");
        //do something...
        if (2 < 4) throw new MyCustomException("jlsnljsfjlkdfbnkjdfnv");
    }

    static class MyCustomException extends Exception {
        MyCustomException(String message) {
            super(message);
        }

        MyCustomException() {
            super();
        }

        MyCustomException(String s, Throwable t) {
            super(s, t);
        }
    }
}
