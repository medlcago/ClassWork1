package clinic;

import java.util.Random;

public class RandomUtils {
    private static final Random random = new Random();

    public static int getRandomNumberInRange(int min, int max) {
        return random.nextInt(max - min + 1) + min;
    }
}