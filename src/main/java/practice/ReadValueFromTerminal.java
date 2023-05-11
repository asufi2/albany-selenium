package practice;

import java.util.Scanner;

public class ReadValueFromTerminal {
    public void getUserInput() {
        Scanner in = new Scanner(System.in);

        System.out.println("Enter your name: ");
        String s = in.nextLine();
        System.out.println("Your entered string: " + s);

        System.out.println("Enter your age: ");
        int a = in.nextInt();
        System.out.println("Your entered age is: " + a);

    }
}
