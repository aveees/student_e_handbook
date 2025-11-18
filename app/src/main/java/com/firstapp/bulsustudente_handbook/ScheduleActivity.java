package com.firstapp.bulsustudente_handbook;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class ScheduleActivity extends AppCompatActivity {

    private SQLiteDatabase mDatabase;
    private ScheduleAdapter mAdapter;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule);

        // Setup the standard header
        ImageView backBtn = findViewById(R.id.menu_icon);
        TextView headerTitle = findViewById(R.id.header_title);
        headerTitle.setText("Class Schedule");
        backBtn.setOnClickListener(v -> onBackPressed());

        // Get a writable database instance
        ScheduleDbHelper dbHelper = new ScheduleDbHelper(this);
        mDatabase = dbHelper.getWritableDatabase();

        // Setup RecyclerView
        recyclerView = findViewById(R.id.recycler_view_schedule);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Setup FAB to open AddEditScheduleActivity
        FloatingActionButton fab = findViewById(R.id.fab_add_schedule);
        fab.setOnClickListener(view -> {
            Intent intent = new Intent(ScheduleActivity.this, AddEditScheduleActivity.class);
            startActivity(intent);
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        // Reload data every time the activity is shown
        loadScheduleData();
    }

    private void loadScheduleData() {
        // Create adapter and set it to RecyclerView
        mAdapter = new ScheduleAdapter(this, getAllItems());
        recyclerView.setAdapter(mAdapter);

        // Set listeners for edit and delete actions
        mAdapter.setOnItemClickListener(new ScheduleAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(long id) {
                // Open AddEditScheduleActivity for editing
                Intent intent = new Intent(ScheduleActivity.this, AddEditScheduleActivity.class);
                intent.putExtra("SCHEDULE_ID", id);
                startActivity(intent);
            }

            @Override
            public void onItemLongClick(long id, String subject) {

            }

            @Override
            public void onDeleteClick(long id, String subject) {
                // Show delete confirmation dialog
                showDeleteConfirmationDialog(id, subject);
            }
        });
    }

    private void showDeleteConfirmationDialog(long id, String subject) {
        new AlertDialog.Builder(this)
                .setTitle("Delete Schedule")
                .setMessage("Are you sure you want to delete the schedule for '" + subject + "'?")
                .setIcon(android.R.drawable.ic_dialog_alert)
                .setPositiveButton("Delete", (dialog, whichButton) -> {
                    deleteSchedule(id);
                    Toast.makeText(ScheduleActivity.this, "Schedule deleted", Toast.LENGTH_SHORT).show();
                })
                .setNegativeButton("Cancel", null).show();
    }

    private void deleteSchedule(long id) {
        mDatabase.delete(
                ScheduleContract.ScheduleEntry.TABLE_NAME,
                ScheduleContract.ScheduleEntry._ID + "=" + id,
                null
        );
        // Refresh the list
        mAdapter.swapCursor(getAllItems());
    }

    private Cursor getAllItems() {
        // Query the database and return a cursor with all schedule entries
        // ordered by day and then by start time
        return mDatabase.query(
                ScheduleContract.ScheduleEntry.TABLE_NAME,
                null,
                null,
                null,
                null,
                null,
                ScheduleContract.ScheduleEntry.COLUMN_NAME_DAY + " ASC, " + ScheduleContract.ScheduleEntry.COLUMN_NAME_START_TIME + " ASC"
        );
    }

    @Override
    protected void onDestroy() {
        // Close the database connection when the activity is destroyed
        if (mDatabase != null) {
            mDatabase.close();
        }
        super.onDestroy();
    }
}
