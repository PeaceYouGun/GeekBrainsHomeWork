package Lesson_01.Homework_01;

public class Wall implements Test {

    private final int height;
    private final int id;
    private static int tempID = 1;

    Wall(int value) {
        this.height = value;
        id = tempID;
        tempID++;
    }

    @Override
    public String getType() {
        return "Wall";
    }

    @Override
    public int getValue() {
        return height;
    }

    @Override
    public int getID() {
        return id;
    }
}
