package practice;

public class MountainBike extends Bicycle {
    int seatHeight;

    public MountainBike(int gear, int speed, int seatHeight) {
        super(gear, speed);
        this.seatHeight = seatHeight;
    }

    public void setSeatHeight(int newHeight) {
        seatHeight = newHeight;
    }

    public void showNewInformation() {
        showData();
        System.out.println("Seat height information: " + seatHeight);
    }
}
