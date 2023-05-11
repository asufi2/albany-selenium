package practice;

// ENUM is fixed/unchangeable variables
enum Day {
    SATURDAY,
    SUNDAY,
    MONDAY,
    TUESDAY,
    WEDNESDAY,
    THURSDAY,
    FRIDAY;
}

public class LearnEnum {
    Day day;

    public LearnEnum(Day day) {
        this.day = day;
    }

    public void dayIsLike() {
        switch (day) {
            case MONDAY:
                System.out.println("Mondays are bad");
                break;
            case SATURDAY:
            case SUNDAY:
                System.out.println("Weekends are the best");
                break;
            default:
                System.out.println("Any other day are so so");
        }
    }

}
