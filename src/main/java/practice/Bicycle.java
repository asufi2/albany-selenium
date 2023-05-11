package practice;

public class Bicycle {
    int gear;
    int speed;

    public Bicycle(int gear, int speed) {
        this.gear = gear;
        this.speed = speed;
    }

    public void applyBrake(int decrement) {
        speed -= decrement; // speed = speed - decrement
    }

    public void speedUp(int increment) {
        speed += increment; // speed = speed + increment
    }

    public void showData() {
        System.out.println("Number of gears are: " + gear);
        System.out.println("Speed of bicycle is: " + speed);
    }
}
