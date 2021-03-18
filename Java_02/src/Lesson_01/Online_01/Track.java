package Lesson_01.Online_01;

/**
 * Project java_core_android
 *
 * @Author Alexander Grigorev
 * Created 28.01.2021
 * v1.0
 */
public class Track implements Obtacle {
    private final int length;

    public Track(int length) {
        this.length = length;
    }

    @Override
    public int getLength() {
        return length;
    }

    @Override
    public int getHeight() {
        return 0;
    }
}
