package lesson2;

import java.util.LinkedList;
import java.util.List;
import java.util.function.Consumer;

/**
 * Project java_core_l2
 *
 * @Author Alexander Grigorev
 * Created 19.02.2021
 * v1.0
 */
public class Anonymous {
    static SomeInterface i;

    public static void main(String[] args) {
        int a = 0;
        i = (s, c) -> System.out.println("Hello anonymous! " + s);

        i.doSomething("!!!!", 10);

        System.out.println(i.getClass().getName());
        SomeInterface si = new SomeInterface() {
            @Override
            public void doSomething(String s, int c) {
                System.out.println();
            }
        };

        System.out.println(si.getClass().getName());

        List<String> s = new LinkedList<>();
        s.forEach(System.out::println);
    }


    @FunctionalInterface
    interface SomeInterface {
        void doSomething(String s, int c);
//        void doSomethingElse();
    }
}
