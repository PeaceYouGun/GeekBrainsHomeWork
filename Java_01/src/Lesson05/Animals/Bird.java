package Lesson05.Animals;

import Lesson05.Animal;

public class Bird extends Animal {
    public Bird(String name) {
        super(4, name);
    }

    @Override
    public void swim(int distance) {
        System.out.println("Birds can't swim");
    }
}
