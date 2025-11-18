package com.firstapp.bulsustudente_handbook;

import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;
import androidx.appcompat.app.AppCompatActivity;

public class BulsuHymnTagalogActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bulsu_hymn_tagalog);

        // --- View Initialization ---
        ImageView menuIcon = findViewById(R.id.menu_icon);
        TextView title = findViewById(R.id.header_title);
        VideoView videoView = findViewById(R.id.bulsu_hymn_video_tagalog);

        // --- Video Player Setup ---
        // Assuming you have a video named "bulsu_hymn_video.mp4" in res/raw
        // If you have a different video for Tagalog, change the filename here.
        String videoPath = "android.resource://" + getPackageName() + "/" + R.raw.hymn_tagalog;
        Uri uri = Uri.parse(videoPath);
        videoView.setVideoURI(uri);

        // Create MediaController to add play/pause/seek controls
        MediaController mediaController = new MediaController(this);
        videoView.setMediaController(mediaController);
        mediaController.setAnchorView(videoView);

        // Optional: Start the video automatically
        videoView.start();

        // --- Header Setup ---
        title.setText("BulSU Hymn (Tagalog)");
        menuIcon.setOnClickListener(v -> finish());
    }
}
