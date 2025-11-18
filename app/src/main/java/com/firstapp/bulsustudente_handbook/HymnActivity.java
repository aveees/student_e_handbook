package com.firstapp.bulsustudente_handbook;

import android.content.Intent; // Import the Intent class
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class HymnActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bulsu_hymn_and_march);

        // --- View Initialization ---
        ImageView menuIcon = findViewById(R.id.menu_icon);
        TextView title = findViewById(R.id.header_title);

        // Hymn Dropdown Views
        LinearLayout bulsuHymnHeader = findViewById(R.id.bulsu_hymn_header);
        final LinearLayout bulsuHymnOptionsContainer = findViewById(R.id.bulsu_hymn_options_container);
        final ImageView bulsuHymnArrow = findViewById(R.id.bulsu_hymn_arrow);
        TextView hymnTagalogVersion = findViewById(R.id.bulsu_hymn_tagalog);
        TextView hymnEnglishVersion = findViewById(R.id.bulsu_hymn_english);

        // March Dropdown Views
        LinearLayout bulsuMarchHeader = findViewById(R.id.bulsu_march_header);
        final LinearLayout bulsuMarchOptionsContainer = findViewById(R.id.bulsu_march_options_container);
        final ImageView bulsuMarchArrow = findViewById(R.id.bulsu_march_arrow);
        TextView marchTagalogVersion = findViewById(R.id.bulsu_march_tagalog);
        TextView marchEnglishVersion = findViewById(R.id.bulsu_march_english);


        // --- BulSU Hymn Dropdown Functionality ---
        bulsuHymnHeader.setOnClickListener(v -> {
            boolean isVisible = bulsuHymnOptionsContainer.getVisibility() == View.VISIBLE;
            bulsuHymnOptionsContainer.setVisibility(isVisible ? View.GONE : View.VISIBLE);
            bulsuHymnArrow.setRotation(isVisible ? 0 : 180);
        });

        hymnTagalogVersion.setOnClickListener(v -> {
            Intent intent = new Intent(HymnActivity.this, BulsuHymnTagalogActivity.class);
            startActivity(intent);
        });

        // MODIFICATION: Added navigation to the English Hymn page
        hymnEnglishVersion.setOnClickListener(v -> {
            // Create an Intent to start the BulsuHymnEnglishActivity
            Intent intent = new Intent(HymnActivity.this, BulsuHymnEnglishActivity.class);
            startActivity(intent);
        });


        // --- BulSU March Dropdown Functionality ---
        bulsuMarchHeader.setOnClickListener(v -> {
            boolean isVisible = bulsuMarchOptionsContainer.getVisibility() == View.VISIBLE;
            bulsuMarchOptionsContainer.setVisibility(isVisible ? View.GONE : View.VISIBLE);
            bulsuMarchArrow.setRotation(isVisible ? 0 : 180);
        });

        marchTagalogVersion.setOnClickListener(v -> {
            Intent intent = new Intent(HymnActivity.this, BulsuMarchTagalogActivity.class);
            startActivity(intent);
        });
        marchEnglishVersion.setOnClickListener(v -> {
            Intent intent = new Intent(HymnActivity.this, BulsuMarchEnglishActivity.class);
            startActivity(intent);
        });


        // --- Header Setup ---
        title.setText("Bulsu Hymn & March");
        menuIcon.setOnClickListener(v -> finish());
    }
}
