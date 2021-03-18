package Lesson_01.Online_01;

/**
 * Project java_core_android
 *
 * @Author Alexander Grigorev
 * Created 28.01.2021
 * v1.0
 */
public class Robot implements Runner {
    private final String name;
    private final String type;
    private final int maxRun;
    private final int maxJump;

    public Robot(String name, int maxRun, int maxJump) {
        this.name = name;
        this.type = "Robot";
        this.maxRun = maxRun;
        this.maxJump = maxJump;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getType() {
        return type;
    }

    @Override
    public int getMaxRun() {
        return maxRun;
    }

    @Override
    public int getMaxJump() {
        return maxJump;
    }
}
