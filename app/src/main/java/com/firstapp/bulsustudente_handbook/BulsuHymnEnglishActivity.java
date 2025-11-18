package com.firstapp.bulsustudente_handbook;

import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.MediaController; // Import MediaController
import android.widget.TextView;
import android.widget.VideoView; // Import VideoView
import androidx.appcompat.app.AppCompatActivity;

public class BulsuHymnEnglishActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bulsu_hymn_english);

        // --- View Initialization ---
        ImageView menuIcon = findViewById(R.id.menu_icon);
        TextView title = findViewById(R.id.header_title);

        // --- NEW: Video Player Setup ---
        VideoView videoView = findViewById(R.id.bulsu_hymn_video);

        // 1. Specify the path to your video file in the raw folder
        String videoPath = "android.resource://" + getPackageName() + "/" + R.raw.bulacan_state_university_hymn; // Make sure your file is named 'bulsu_hymn_video.mp4'
        Uri uri = Uri.parse(videoPath);
        videoView.setVideoURI(uri);

        // 2. Create MediaController to add play/pause/seek controls
        MediaController mediaController = new MediaController(this);
        videoView.setMediaController(mediaController);
        mediaController.setAnchorView(videoView);

        // 3. Optional: Start the video automatically
        videoView.start();

        // --- Header Setup ---
        title.setText("BulSU Hymn (English)");
        menuIcon.setOnClickListener(v -> finish());
    }
}
