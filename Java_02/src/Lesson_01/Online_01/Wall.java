package Lesson_01.Online_01;

/**
 * Project java_core_android
 *
 * @Author Alexander Grigorev
 * Created 28.01.2021
 * v1.0
 */
public class Wall implements Obtacle {
    private final int height;

    public Wall(int height) {
        this.height = height;
    }

    @Override
    public int getLength() {
        return 0;
    }

    @Override
    public int getHeight() {
        return height;
    }
}
