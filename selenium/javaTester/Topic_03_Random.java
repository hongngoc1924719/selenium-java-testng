package javaTester;

import java.util.Random;

public class Topic_03_Random {
    public static void main(String[] args) {
        Random rand = new Random();
        System.out.println("donaldtrump" + rand.nextBoolean() + "@gmail.net");
        System.out.println("donaldtrump" + rand.nextDouble() + "@gmail.net");
        System.out.println("donaldtrump" + rand.nextFloat() + "@gmail.net");
        System.out.println("donaldtrump" + rand.nextInt() + "@gmail.net");
        System.out.println("donaldtrump" + rand.nextLong() + "@gmail.net");
        System.out.println("donaldtrump" + new Random().nextInt(9999) + "@gmail.net");

    }
}
