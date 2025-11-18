package com.firstapp.bulsustudente_handbook;

import android.Manifest;
import android.app.AlertDialog;
import android.app.DownloadManager;
import android.content.Context;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.webkit.MimeTypeMap;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class FormsActivity extends AppCompatActivity implements FormsAdapter.OnDownloadClickListener {

    private static final int PERMISSION_REQUEST_CODE = 100;
    private FormItem pendingDownloadItem = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forms);

        // --- Header Setup ---
        ImageView menuIcon = findViewById(R.id.menu_icon);
        TextView title = findViewById(R.id.header_title);
        title.setText("FORMS");
        menuIcon.setOnClickListener(v -> finish());
        // --------------------

        // --- RecyclerView Setup ---
        RecyclerView formsRecyclerView = findViewById(R.id.forms_recycler_view);
        formsRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Create mock data
        List<FormItem> formsList = createMockFormsList();

        // Create and set the adapter
        FormsAdapter adapter = new FormsAdapter(formsList, this);
        formsRecyclerView.setAdapter(adapter);
    }

    /**
     * Creates a list of sample downloadable forms.
     * NOTE: Replace the URLs with your actual file links!
     */
    private List<FormItem> createMockFormsList() {
        List<FormItem> list = new ArrayList<>();
        list.add(new FormItem("Changing Form (PDF)", "https://drive.google.com/uc?export=download&id=12n-5xs9GWm5PwAZNvyiEgVUrLkPD679U"));
        list.add(new FormItem("Dropping Form (PDF)", "https://drive.google.com/uc?export=download&id=1qO-wdEQuTYdowtYIItEepvOD2z_jA4Q6"));
        list.add(new FormItem("Incomplete Form (PDF)", "https://drive.google.com/uc?export=download&id=1jTuDJObJmgEpX-Wd16nc7W3WFiIaiL0X"));
        list.add(new FormItem("Request for Petition Form (PDF)", "https://drive.google.com/uc?export=download&id=1qotmKfrBRmhl8th5PfSymIlB75UrUN7Y"));
        list.add(new FormItem("Student Completion Form (PDF)", "https://drive.google.com/uc?export=download&id=14b_aZLfVyyhaKKHHNF2Q38gcvAs4XLcJ"));
        list.add(new FormItem("Student's Clearance (PDF)", "https://drive.google.com/uc?export=download&id=1sGT7gkfTHXZqw82Zofs5-uuLHbmvquvY"));
        return list;
    }

    /**
     * Handles the click from the FormsAdapter.
     * Displays a confirmation dialog before proceeding to download.
     * @param item The FormItem clicked.
     */
    @Override
    public void onDownloadClick(FormItem item) {
        showDownloadConfirmation(item);
    }

    /**
     * Shows a custom confirmation dialog.
     */
    private void showDownloadConfirmation(FormItem item) {
        new AlertDialog.Builder(this)// Use a system theme for dialog for simplicity
                .setTitle("Confirm Download")
                .setMessage("Are you sure you want to download '" + item.getTitle() + "'?")
                .setPositiveButton("Download", (dialog, which) -> {
                    // Check permissions before starting download
                    pendingDownloadItem = item;
                    checkDownloadPermissions();
                })
                .setNegativeButton("Cancel", (dialog, which) -> dialog.dismiss())
                .show();
    }

    /**
     * Checks if the app has necessary permissions and starts the download.
     */
    private void checkDownloadPermissions() {
        // For Android 10 (API 29) and newer, WRITE_EXTERNAL_STORAGE is often not needed
        // when downloading to the public Downloads folder.
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.Q &&
                ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE)
                        != PackageManager.PERMISSION_GRANTED) {

            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},
                    PERMISSION_REQUEST_CODE);
        } else {
            // Permissions are granted or not needed (Android Q+)
            startDownload(pendingDownloadItem);
        }
    }

    /**
     * Starts the actual file download using the system's DownloadManager.
     */
    private void startDownload(FormItem item) {
        if (item == null) return;

        try {
            Uri uri = Uri.parse(item.getDownloadUrl());
            DownloadManager dm = (DownloadManager) getSystemService(Context.DOWNLOAD_SERVICE);

            if (dm == null) {
                Toast.makeText(this, "Download service unavailable.", Toast.LENGTH_LONG).show();
                return;
            }

            // Force all files as PDF
            String fileName = item.getTitle().replaceAll("[^a-zA-Z0-9.-]", "_") + ".pdf";

            DownloadManager.Request request = new DownloadManager.Request(uri)
                    .setTitle(item.getTitle())
                    .setDescription("Downloading " + item.getTitle())
                    .setMimeType("application/pdf")
                    .setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED)
                    .setAllowedOverMetered(true)
                    .setAllowedOverRoaming(true)
                    .setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, fileName);

            dm.enqueue(request);

            Toast.makeText(this, "Downloading PDF: " + item.getTitle(), Toast.LENGTH_SHORT).show();

        } catch (Exception e) {
            Log.e("FormsActivity", "Download error: " + e.getMessage());
            Toast.makeText(this, "Failed to download file.", Toast.LENGTH_LONG).show();
        }

        pendingDownloadItem = null;
    }



    /**
     * Handles the result of the permission request.
     */
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if (requestCode == PERMISSION_REQUEST_CODE) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                // Permission granted, proceed with download
                startDownload(pendingDownloadItem);
            } else {
                // Permission denied
                Toast.makeText(this, "Permission denied. Cannot download file.", Toast.LENGTH_LONG).show();
                pendingDownloadItem = null;
            }
        }
    }
}