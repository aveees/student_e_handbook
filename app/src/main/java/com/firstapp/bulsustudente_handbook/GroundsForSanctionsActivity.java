package com.firstapp.bulsustudente_handbook;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class GroundsForSanctionsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // This correctly loads your detailed table-based layout file.
        setContentView(R.layout.activity_grounds_for_sanctions);

        // Setup the standard header
        ImageView backBtn = findViewById(R.id.menu_icon);
        TextView headerTitle = findViewById(R.id.header_title);

        if (headerTitle != null) {
            // Set the title for this screen
            headerTitle.setText("Grounds for Disciplinary Sanctions");
        }

        if (backBtn != null) {
            // Make the icon function as a back button
            backBtn.setOnClickListener(v -> onBackPressed());
        }

        // No more code is needed here. All the content and styling
        // for the tables are handled directly in your XML layout file.
    }
}
