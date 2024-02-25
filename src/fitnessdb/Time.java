package fitnessdb;
/**
 * Enum Class
 * @author Adeola
 */
public enum Time {
    MORNING (9, 30),
    AFTERNOON (14, 0),
    EVENING (18, 30);
    private final int hour;
    private final int minute;


    Time(int hour, int minute) {
        this.hour = hour;
        this.minute = minute;
    }

    public static Time getTime(String name){
        if (name.toUpperCase().equals(MORNING.name())){
            return MORNING;
        }
        else if (name.toUpperCase().equals(AFTERNOON.name())){
            return AFTERNOON;
        }
        else if (name.toUpperCase().equals(EVENING.name())){
            return EVENING;
        }
        else{
            return null;
        }
    }
    public int getHour() {
        return hour;
    }

    public int getMinute() {
        return minute;
    }

    @Override
    public String toString() {
        return String.format("%d:%02d", hour,minute);
    }
}
