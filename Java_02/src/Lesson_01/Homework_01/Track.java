package Lesson_01.Homework_01;

public class Track implements Test {

    private final int length;
    private final int id;
    private static int tempID = 1;

    Track(int value) {
        this.length = value;
        id = tempID;
        tempID++;
    }

    @Override
    public String getType() {
        return "Track";
    }

    @Override
    public int getValue() {
        return length;
    }

    @Override
    public int getID() {
        return id;
    }
}
