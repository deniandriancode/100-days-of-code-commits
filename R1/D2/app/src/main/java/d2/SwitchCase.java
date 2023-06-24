package d2;

public class SwitchCase {
    public static void main(String[] args) {
        Day today = Day.MON;
        if (isWeekDay(today)) {
            System.out.println("Time to work!");
        } else {
            System.out.println("Let's take a rest!");
        }

        switch ("hi") {
            case "helo" -> System.out.println("Helo");
            case "hi" -> System.out.println("Hi");
            default -> System.out.println("Hmmm...");
        }
    }

    public static Boolean isWeekDay(Day day) {
        Boolean result = false;
        switch(day) {
            case MON: 
                result = true;
                break;
            case TUE: 
                result = true;
                break;
            case WED: 
                result = true;
                break;
            case THUR: 
                result = true;
                break;
            case FRI: 
                result = true;
                break;
            case SAT: 
                result = false;
                break;
            case SUN: 
                result = false;
                break;
            default: 
                throw new IllegalArgumentException("Invalid day: " + day.name());
        }
        return result;
    }

    public static Boolean isWeekDayConcise(Day day) {
        Boolean result = false;
        switch (day) {
        case MON, TUE, WED, THUR, FRI:
            result = true;
            break;
        case SAT, SUN:
            result = false;
            break;
        default:
            throw new IllegalArgumentException("Invalid day : " + day.name());
        }
        return result;
    }

    public static Boolean isWeekDayArrow(Day day) {
        Boolean result = false;
        switch (day) {
            case MON, TUE, WED, THUR, FRI -> result = true;
            case SAT, SUN -> result = false;
            default -> throw new IllegalArgumentException("Invalid day : " + day.name());
        }
        return result;
    }

}

enum Day {
    MON, TUE, WED, THUR, FRI, SAT, SUN
}
