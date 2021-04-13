package Lesson_01.Homework_01;

import java.util.ArrayList;
import java.util.List;

class Box<T extends Fruit> {
    private final List<T> list;

    public List<T> getList() {
        return list;
    }

    public Box() {
        list = new ArrayList<T>();
    }

    void add(T obj) {
        list.add(obj);
    }

    void transfer(Box<T> box) {
        box.getList().addAll(list);
        list.clear();
    }

    int getNumber() {
        return list.size();
    }

    float getWeight() {
        if (list.isEmpty()) {
            return 0;
        } else {
            return list.size() * list.get(0).getWeightFruit();
        }
    }

    boolean compare(Box<? extends Fruit> box) {
        return this.getWeight() == box.getWeight();
    }
}