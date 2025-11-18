package com.firstapp.bulsustudente_handbook;

import android.provider.BaseColumns;

public final class ScheduleContract {

    // To prevent someone from accidentally instantiating the contract class,
    // make the constructor private.
    private ScheduleContract() {}

    /* Inner class that defines the table contents */
    public static class ScheduleEntry implements BaseColumns {
        public static final String TABLE_NAME = "schedule";
        public static final String COLUMN_NAME_SUBJECT = "subject";
        public static final String COLUMN_NAME_DAY = "day"; // e.g., "Monday", "Tuesday"
        public static final String COLUMN_NAME_START_TIME = "start_time"; // e.g., "09:00 AM"
        public static final String COLUMN_NAME_END_TIME = "end_time";   // e.g., "10:30 AM"
        public static final String COLUMN_NAME_ROOM = "room";
        public static final String COLUMN_NAME_PROFESSOR = "professor";
    }
}
