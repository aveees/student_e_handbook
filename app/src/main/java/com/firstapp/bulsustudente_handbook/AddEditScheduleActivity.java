package com.firstapp.bulsustudente_handbook;

import android.app.TimePickerDialog;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class AddEditScheduleActivity extends AppCompatActivity {

    // CHANGE: EditTexts for time are now TextViews
    private EditText etSubject, etDay, etRoom, etProfessor;
    private TextView tvStartTime, tvEndTime;
    private Button btnSave;
    private SQLiteDatabase mDatabase;

    private long mScheduleId = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_edit_schedule);

        ScheduleDbHelper dbHelper = new ScheduleDbHelper(this);
        mDatabase = dbHelper.getWritableDatabase();

        // Initialize UI components
        etSubject = findViewById(R.id.et_subject);
        etDay = findViewById(R.id.et_day);
        // CHANGE: Find TextViews instead of EditTexts for time
        tvStartTime = findViewById(R.id.tv_start_time);
        tvEndTime = findViewById(R.id.tv_end_time);
        etRoom = findViewById(R.id.et_room);
        etProfessor = findViewById(R.id.et_professor);
        btnSave = findViewById(R.id.btn_save_schedule);

        // --- Set OnClick Listeners for the Time TextViews ---
        tvStartTime.setOnClickListener(v -> showTimePickerDialog(tvStartTime));
        tvEndTime.setOnClickListener(v -> showTimePickerDialog(tvEndTime));

        if (getIntent().hasExtra("SCHEDULE_ID")) {
            mScheduleId = getIntent().getLongExtra("SCHEDULE_ID", -1);
        }

        ImageView backBtn = findViewById(R.id.menu_icon);
        TextView headerTitle = findViewById(R.id.header_title);
        backBtn.setOnClickListener(v -> onBackPressed());

        if (mScheduleId != -1) {
            headerTitle.setText("Edit Schedule");
            btnSave.setText("Update Schedule");
            loadScheduleData();
        } else {
            headerTitle.setText("Add Schedule");
            btnSave.setText("Save Class");
        }

        btnSave.setOnClickListener(v -> saveSchedule());
    }

    private void showTimePickerDialog(final TextView timeTextView) {
        // Get current time
        final Calendar calendar = Calendar.getInstance();
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        int minute = calendar.get(Calendar.MINUTE);

        // Create a new instance of TimePickerDialog
        TimePickerDialog timePickerDialog = new TimePickerDialog(this,
                (view, hourOfDay, minuteOfHour) -> {
                    // Format the time to a 12-hour format with AM/PM
                    calendar.set(Calendar.HOUR_OF_DAY, hourOfDay);
                    calendar.set(Calendar.MINUTE, minuteOfHour);
                    SimpleDateFormat sdf = new SimpleDateFormat("hh:mm a", Locale.US);
                    String selectedTime = sdf.format(calendar.getTime());
                    timeTextView.setText(selectedTime);
                }, hour, minute, false); // false for 12-hour format with AM/PM selector

        timePickerDialog.show();
    }

    private void loadScheduleData() {
        if (mScheduleId == -1) return;

        Cursor cursor = mDatabase.query(
                ScheduleContract.ScheduleEntry.TABLE_NAME,
                null,
                ScheduleContract.ScheduleEntry._ID + " = ?",
                new String[]{String.valueOf(mScheduleId)},
                null, null, null);

        if (cursor != null && cursor.moveToFirst()) {
            String subject = cursor.getString(cursor.getColumnIndexOrThrow(ScheduleContract.ScheduleEntry.COLUMN_NAME_SUBJECT));
            String day = cursor.getString(cursor.getColumnIndexOrThrow(ScheduleContract.ScheduleEntry.COLUMN_NAME_DAY));
            // CHANGE: Get time strings
            String startTime = cursor.getString(cursor.getColumnIndexOrThrow(ScheduleContract.ScheduleEntry.COLUMN_NAME_START_TIME));
            String endTime = cursor.getString(cursor.getColumnIndexOrThrow(ScheduleContract.ScheduleEntry.COLUMN_NAME_END_TIME));
            String room = cursor.getString(cursor.getColumnIndexOrThrow(ScheduleContract.ScheduleEntry.COLUMN_NAME_ROOM));
            String professor = cursor.getString(cursor.getColumnIndexOrThrow(ScheduleContract.ScheduleEntry.COLUMN_NAME_PROFESSOR));

            etSubject.setText(subject);
            etDay.setText(day);
            // CHANGE: Set text on TextViews
            tvStartTime.setText(startTime);
            tvEndTime.setText(endTime);
            etRoom.setText(room);
            etProfessor.setText(professor);

            cursor.close();
        }
    }

    private void saveSchedule() {
        String subject = etSubject.getText().toString().trim();
        String day = etDay.getText().toString().trim();
        // CHANGE: Get text from TextViews
        String startTime = tvStartTime.getText().toString().trim();
        String endTime = tvEndTime.getText().toString().trim();
        String room = etRoom.getText().toString().trim();
        String professor = etProfessor.getText().toString().trim();

        // Updated validation to check TextViews
        if (subject.isEmpty() || day.isEmpty() || startTime.isEmpty() || endTime.isEmpty() || startTime.contentEquals("Select Start Time") || endTime.contentEquals("Select End Time")) {
            Toast.makeText(this, "Please fill out all required fields, including time", Toast.LENGTH_SHORT).show();
            return;
        }

        ContentValues values = new ContentValues();
        values.put(ScheduleContract.ScheduleEntry.COLUMN_NAME_SUBJECT, subject);
        values.put(ScheduleContract.ScheduleEntry.COLUMN_NAME_DAY, day);
        // CHANGE: Put the selected time strings
        values.put(ScheduleContract.ScheduleEntry.COLUMN_NAME_START_TIME, startTime);
        values.put(ScheduleContract.ScheduleEntry.COLUMN_NAME_END_TIME, endTime);
        values.put(ScheduleContract.ScheduleEntry.COLUMN_NAME_ROOM, room);
        values.put(ScheduleContract.ScheduleEntry.COLUMN_NAME_PROFESSOR, professor);

        if (mScheduleId == -1) {
            long newRowId = mDatabase.insert(ScheduleContract.ScheduleEntry.TABLE_NAME, null, values);
            if (newRowId == -1) {
                Toast.makeText(this, "Error saving schedule", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Schedule saved successfully", Toast.LENGTH_SHORT).show();
                finish();
            }
        } else {
            int rowsAffected = mDatabase.update(
                    ScheduleContract.ScheduleEntry.TABLE_NAME,
                    values,
                    ScheduleContract.ScheduleEntry._ID + " = ?",
                    new String[]{String.valueOf(mScheduleId)}
            );
            if (rowsAffected > 0) {
                Toast.makeText(this, "Schedule updated successfully", Toast.LENGTH_SHORT).show();
                finish();
            } else {
                Toast.makeText(this, "Error updating schedule", Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    protected void onDestroy() {
        if (mDatabase != null) {
            mDatabase.close();
        }
        super.onDestroy();
    }
}
