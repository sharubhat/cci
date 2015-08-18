package javacodegeeeks.c05_enums_and_annotations;

/**
 * Created by sharath on 8/3/15.
 */
public enum DaysOfTheWeekFields implements DayOfWeek {
    MONDAY(false),
    TUESDAY(false),
    WEDNESDAY(false),
    THURSDAY(false),
    FRIDAY(false),
    SATURDAY(true),
    SUNDAY(true);

    private final boolean isWeekend;

    DaysOfTheWeekFields(final boolean isWeekend) {
        this.isWeekend = isWeekend;
    }

    @Override
    public boolean isWeekend() {
        return isWeekend;
    }
}
