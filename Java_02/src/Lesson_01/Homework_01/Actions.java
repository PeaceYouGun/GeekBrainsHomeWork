package Lesson_01.Homework_01;

public interface Actions {

    int getID();

    int getMaxLength();

    int getMaxHeight();

    String getType();

    default void printInfo() {
        System.out.println("\n" + getType() + " " + getID() + " can run " + getMaxLength() + " and can jump " + getMaxHeight());
    }

    default boolean run(int length, int id) {
        if (length <= getMaxLength()) {
            System.out.println("ran the track " + id + " with length " + length);
            return true;
        } else {
            System.out.println("didn't ran the track " + id + " with length " + length);
            return false;
        }
    }

    default boolean jump(int height, int id) {
        if (height <= getMaxHeight()) {
            System.out.println("jumped over the wall " + id + " with height " + height);
            return true;
        } else {
            System.out.println("didn't jumped over the wall " + id + " with height " + height);
            return false;
        }
    }

    default boolean challenge(Test tests) {
        if (tests.getType().equals("Track"))
            return run(tests.getValue(), tests.getID());
        else return jump(tests.getValue(), tests.getID());

    }
}
