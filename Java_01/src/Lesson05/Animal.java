package Lesson05;

import java.util.Random;

public abstract class Animal {

    private int runLength;
    private float jumpHeight;
    private int swimLength;
    private String name;

//    protected Animal(int id, String name) {
//        this.name = name;
//        switch (id) {
//            case 1:
//                this.runLength = 200;
//                this.jumpHeight = 2;
//                break;
//            case 2:
//                this.runLength = 500;
//                this.jumpHeight = 0.5f;
//                this.swimLength = 10;
//                break;
//            case 3:
//                this.runLength = 1500;
//                this.jumpHeight = 3;
//                this.swimLength = 100;
//                break;
//            case 4:
//                this.runLength = 5;
//                this.jumpHeight = 0.2f;
//                break;
//        }
//    }

    // Для выполнения 5 задачи необходимо закомментировать первый конструктор
    // и раскомментировать конструктор ниже

    protected Animal(int id, String name) {
        this.name = name;
        switch (id) {
            case 1:
                this.runLength = random() * 100;
                this.jumpHeight = (float) random();
                break;
            case 2:
            case 3:
                this.runLength = random() * 100;
                this.jumpHeight = (float) random();
                this.swimLength = random() * 10;
                break;
            case 4:
                this.runLength = 5;
                this.jumpHeight = (float) random();
                break;
        }
    }

    protected void run(int distance) {
        if (distance > runLength)
            System.out.println(name + " with limit " + runLength + " didn't run " + distance);
        else System.out.println(name + " with limit " + runLength + " ran " + distance);
    }

    protected void jump(float distance) {
        if (distance > jumpHeight)
            System.out.println(name + " with limit " + jumpHeight + " didn't jump " + distance);
        else System.out.println(name + " with limit " + jumpHeight + " jumped " + distance);
    }

    protected void swim(int distance) {
        if (distance > swimLength)
            System.out.println(name + " with limit " + swimLength + " didn't swim " + distance);
        else System.out.println(name + " with limit " + swimLength + " swam " + distance);
    }

    int random() {
        Random random = new Random();
        return random.nextInt(10);
    }
}
