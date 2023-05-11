package practice;

import java.security.PublicKey;

public class LearnExceptions {
    public void testExceptions() {
        try {
            int[] num = {1, 2, 3, 4};
            // Since 6 is out of bound for the above it should throw an error so we need an exception to continue
            System.out.println(num[6]);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void  addArrayNumbers() {
        try {
        int[] numbers = {1, 2, 3};
        int sum = numbers[0] + numbers[4];
        System.out.println(sum);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void subtractArrayNumbers() {
        // this is the only exception which should print a value of two because the math is correct,
        // when the math is off it throws an java.lang.ArrayIndexOutOfBoundsException: message
        try {
            int[] numbers = {1, 2, 3};
            int result = numbers[2] - numbers[0];
            System.out.println(result);
            } catch (Exception e) {
            System.out.println(e);
        }
        }

            public void multiplyArrayNumbers () {
        try {
                int[] numbers = {1, 2, 3};
                int result = numbers[4] + numbers[0];
                System.out.println(result);
            } catch(Exception e) {
            System.out.println(e);
        }
        }

    public void  addArrayNumbers1() {
        try {
            int a = 1;
            int b = 2;
            int result = a + b;
            System.out.println("Summations: " + result);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    }