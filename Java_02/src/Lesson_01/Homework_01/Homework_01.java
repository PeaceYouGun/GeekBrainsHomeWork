package Lesson_01.Homework_01;

public class Homework_01 {
    public static void main(String[] args) {
        Actions[] creators = {
                new Human(500, 3),
                new Human(700, 4),
                new Cat(1000, 2),
                new Cat(500, 1),
                new Robot(100, 1),
                new Robot(600, 5)
        };

        Test[] tests = {
                new Track(600),
                new Wall(3),
                new Track(400),
                new Wall(2)
        };

        for (int i = 0; i < creators.length; i++) {
            creators[i].printInfo();
            for (int j = 0; j < tests.length; j++) {
                if (!creators[i].challenge(tests[j]))
                    break;
            }
        }

    }
}
