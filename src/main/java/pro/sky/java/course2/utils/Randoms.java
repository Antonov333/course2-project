package pro.sky.java.course2.utils;

import java.util.Random;

public class Randoms {

    public static Random random() {
        return new Random();
    }

    public static int randomInt(int a, int b) {
        return random().nextInt(a, b);
    }

}
