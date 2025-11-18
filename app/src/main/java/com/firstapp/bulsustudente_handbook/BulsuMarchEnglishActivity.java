package com.firstapp.bulsustudente_handbook;

import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;
import androidx.appcompat.app.AppCompatActivity;

public class BulsuMarchEnglishActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bulsu_march_english);

        // --- View Initialization ---
        ImageView menuIcon = findViewById(R.id.menu_icon);
        TextView title = findViewById(R.id.header_title);
        VideoView videoView = findViewById(R.id.bulsu_march_video_english);

        // --- Video Player Setup ---
        // Make sure you have a video file named "bulsu_march_video.mp4" in res/raw
        String videoPath = "android.resource://" + getPackageName() + "/" + R.raw.bulacan_state_university_march;
        Uri uri = Uri.parse(videoPath);
        videoView.setVideoURI(uri);

        // Create MediaController to add play/pause/seek controls
        MediaController mediaController = new MediaController(this);
        videoView.setMediaController(mediaController);
        mediaController.setAnchorView(videoView);

        // Optional: Start the video automatically
        videoView.start();

        // --- Header Setup ---
        title.setText("BulSU March (English)");
        menuIcon.setOnClickListener(v -> finish());
    }
}
