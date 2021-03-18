package Lesson05.Animals;

import Lesson05.Animal;

public class Cat extends Animal {
    public Cat(String name) {
        super(1, name);
    }

    @Override
    public void swim(int distance) {
        System.out.println("Cats can't swim");
    }
}
