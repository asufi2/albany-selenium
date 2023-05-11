package practice;

public class LearnRecursion {
    public int sum(int k) { //k =2 (2+1+0=3)
        if (k > 0) { //true; k=2
            return k + sum(k - 1); //2 + sum(2-1)
        } else {
            return 0;
        }
    }

    //Print 1 to 100 without the loop
    public void printNumbers ( int number) {
        if (number <= 100) {
            System.out.println(number);
            printNumbers(number + 1);
        }

    }
}

