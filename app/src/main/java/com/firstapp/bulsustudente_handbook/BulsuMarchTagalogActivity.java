package com.firstapp.bulsustudente_handbook;

import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;
import androidx.appcompat.app.AppCompatActivity;

public class BulsuMarchTagalogActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bulsu_march_tagalog);

        // --- View Initialization ---
        ImageView menuIcon = findViewById(R.id.menu_icon);
        TextView title = findViewById(R.id.header_title);
        VideoView videoView = findViewById(R.id.bulsu_march_video_tagalog);

        // --- Video Player Setup ---
        // Create a new video file for the march (e.g., bulsu_march_video.mp4)
        // and place it in the res/raw folder.
        String videoPath = "android.resource://" + getPackageName() + "/" + R.raw.march_tagalog; // CHANGE to your march video file
        Uri uri = Uri.parse(videoPath);
        videoView.setVideoURI(uri);

        // Create MediaController to add play/pause/seek controls
        MediaController mediaController = new MediaController(this);
        videoView.setMediaController(mediaController);
        mediaController.setAnchorView(videoView);

        // Optional: Start the video automatically
        videoView.start();

        // --- Header Setup ---
        title.setText("BulSU March (Tagalog)");
        menuIcon.setOnClickListener(v -> finish());
    }
}
