package practice;

public class Encapsulate {
    private String geekName = "Test";
    private int geekRoll = 120;
    private int geekAge = 35;

    public String getGeekName() {
        return geekName;
    }

    public int getGeekRoll() {
        return geekRoll;
    }

    public int getGeekAge() {
        return geekAge;
    }

    public void setGeekName(String newName) {
        geekName = newName;
    }

    public void setGeekRoll(int newRoll) {
        geekRoll = newRoll;
    }

    public void setGeekAge(int newAge) {
        geekAge = newAge;
    }

    public void StudentInformation() {
        System.out.println("My Name is: " + geekName);
        System.out.println("My roll is: " + geekRoll);
        System.out.println("My age is: " + geekAge);
    }
 }

