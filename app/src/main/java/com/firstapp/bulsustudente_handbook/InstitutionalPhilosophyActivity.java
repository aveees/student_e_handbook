package com.firstapp.bulsustudente_handbook;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class InstitutionalPhilosophyActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_institutional_philo); // link your XML

        // --- HEADER SETUP ---
        ImageView backArrow = findViewById(R.id.menu_icon);
        TextView headerTitle = findViewById(R.id.header_title);
        TextView headerLine1 = findViewById(R.id.header_line1);
        TextView headerSubtitle = findViewById(R.id.header_subtitle);
        TextView breadcrumbs = findViewById(R.id.breadcrumbs); // from layout_section_header.xml

        // Set header text

        headerTitle.setText("INSTITUTIONAL PHILOSOPHY");

        breadcrumbs.setText("General Provisions");

        // Back arrow closes the current activity
        backArrow.setOnClickListener(v -> finish());
    }
}
