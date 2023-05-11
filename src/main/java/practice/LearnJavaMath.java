package practice;

import java.util.Random;

public class LearnJavaMath {
    public void learnRandomize() {
        Random rand = new Random();

        // Generates random numbers in range from 0 to 999
        int rand_num1 = rand.nextInt(1000);
        int rand_num2 = rand.nextInt(1000);

        System.out.println("Random numbers: " + rand_num1);
        System.out.println("Random numbers: " + rand_num2);

        double rand_dub1 = rand.nextDouble();
        double rand_dub2 = rand.nextDouble();

        System.out.println("Random numbers: " + rand_dub1);
        System.out.println("Random numbers: " + rand_dub2);
    }

    public void learnRounding() {
        double num1 = 74.67;
        double num2 = 33.14;
        System.out.println(Math.round(num1));
        System.out.println(Math.round(num2));
    }

    public void learnMax() {
        System.out.println(Math.max(12, 15));
        System.out.println(Math.min(12.3456, 18.7623));
    }
}
