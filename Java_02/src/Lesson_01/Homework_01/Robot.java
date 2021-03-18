package Lesson_01.Homework_01;

public class Robot implements Actions {

    private final int maxLength;
    private final int maxHeight;
    private final int id;
    private static int idTemp = 1;

    public Robot(int maxLength, int maxHeight) {
        this.maxLength = maxLength;
        this.maxHeight = maxHeight;
        id = idTemp;
        idTemp++;
    }

    @Override
    public int getID() {
        return id;
    }

    @Override
    public int getMaxLength() {
        return maxLength;
    }

    @Override
    public int getMaxHeight() {
        return maxHeight;
    }

    @Override
    public String getType() {
        return "Robot";
    }

}
