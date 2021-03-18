package Lesson05;

import Lesson05.Animals.Bird;
import Lesson05.Animals.Cat;
import Lesson05.Animals.Dog;
import Lesson05.Animals.Horse;

import java.util.Random;

public class Main {
    static Random random = new Random();
    public static void main(String[] args) {

        Cat[] cats = {
                new Cat("Murka"),
                new Cat("Gav"),
                new Cat("Tom")
        };

        Dog[] dogs = {
                new Dog("Bobik"),
                new Dog("Bim"),
                new Dog("Pluto")
        };

        Horse[] horses = {
                new Horse("Plotva"),
                new Horse("Trojan"),
                new Horse("Pegas")
        };

        Bird[] birds = {
                new Bird("Chizhik"),
                new Bird("Donald"),
                new Bird("Pingvin")
        };

        startMethods(cats);
        startMethods(dogs);
        startMethods(horses);
        startMethods(birds);
    }

    private static void startMethods (Animal[] animals) {
        for (int i = 0; i < animals.length; i++) {
            animals[i].run(random.nextInt(10)*100);
            animals[i].jump((float)random.nextInt(10));
            animals[i].swim(random.nextInt(10)*10);
            System.out.println();
        }
    }
}
   
