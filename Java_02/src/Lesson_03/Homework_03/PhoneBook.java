package Lesson_03.Homework_03;

import java.util.Map;
import java.util.TreeMap;


public class PhoneBook {
    private final TreeMap<Integer, String> hm = new TreeMap<>();

    public void add(int number, String name) {
        hm.put(number, name);
    }

    public void get(String name) {
        int i = 0;
        for (Map.Entry<Integer, String> o : hm.entrySet()) {
            if (o.getValue().equals(name)) {
                System.out.println(o.getValue() + ": " + o.getKey());
                i++;
            }
        }

        if (i == 0)
            System.out.println(name + " not found");
    }

    public void print() {
        for (Map.Entry<Integer, String> o : hm.entrySet()) {
            System.out.println(o.getKey() + ": " + o.getValue());
        }
    }
}
