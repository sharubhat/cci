package javacodegeeeks.c05_enums_and_annotations;

/**
 * Created by sharath on 8/3/15.
 */
public enum DaysOfTheWeekInterfaces implements DayOfWeek {
    MONDAY() {
        @Override
        public boolean isWeekend() {
            return false;
        }
    },
    TUESDAY() {
        @Override
        public boolean isWeekend() {
            return false;
        }
    },
    WEDNESDAY() {
        @Override
        public boolean isWeekend() {
            return false;
        }
    },
    THURSDAY() {
        @Override
        public boolean isWeekend() {
            return false;
        }
    },
    FRIDAY() {
        @Override
        public boolean isWeekend() {
            return false;
        }
    },
    SATURDAY() {
        @Override
        public boolean isWeekend() {
            return true;
        }
    },
    SUNDAY() {
        @Override
        public boolean isWeekend() {
            return true;
        }
    }
}
