package com.firstapp.bulsustudente_handbook;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class ScheduleDbHelper extends SQLiteOpenHelper {
    // If you change the database schema, you must increment the database version.
    public static final int DATABASE_VERSION = 2;
    public static final String DATABASE_NAME = "StudentSchedule.db";

    private static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + ScheduleContract.ScheduleEntry.TABLE_NAME + " (" +
                    ScheduleContract.ScheduleEntry._ID + " INTEGER PRIMARY KEY," +
                    ScheduleContract.ScheduleEntry.COLUMN_NAME_SUBJECT + " TEXT," +
                    ScheduleContract.ScheduleEntry.COLUMN_NAME_DAY + " TEXT," +
                    ScheduleContract.ScheduleEntry.COLUMN_NAME_START_TIME + " TEXT," +
                    ScheduleContract.ScheduleEntry.COLUMN_NAME_END_TIME + " TEXT," +
                    ScheduleContract.ScheduleEntry.COLUMN_NAME_ROOM + " TEXT," +
                    ScheduleContract.ScheduleEntry.COLUMN_NAME_PROFESSOR + " TEXT)";

    private static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + ScheduleContract.ScheduleEntry.TABLE_NAME;

    public ScheduleDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_ENTRIES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // This simple policy discards the old table and creates a new one.
        // All existing data will be lost.
        db.execSQL("DROP TABLE IF EXISTS " + ScheduleContract.ScheduleEntry.TABLE_NAME);
        onCreate(db);
    }



    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onUpgrade(db, oldVersion, newVersion);
    }
}
