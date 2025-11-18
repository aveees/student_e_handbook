package com.firstapp.bulsustudente_handbook;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class ProgramFacultyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_program_faculty);

        // Setup the standard header
        ImageView backBtn = findViewById(R.id.menu_icon);
        TextView headerTitle = findViewById(R.id.header_title);

        if (headerTitle != null) {
            headerTitle.setText("Program and Faculty");
        }
        if (backBtn != null) {
            backBtn.setOnClickListener(v -> onBackPressed());
        }

        // --- Find each card layout by its ID ---
        RelativeLayout cardCba = findViewById(R.id.card_cba);
        RelativeLayout cardCoed = findViewById(R.id.card_coed);
        RelativeLayout cardCit = findViewById(R.id.card_cit);
        RelativeLayout cardCite = findViewById(R.id.card_cite);

        // --- Set OnClick Listeners for each card ---

        // 1. College of Business Administration Card
        cardCba.setOnClickListener(v -> {
            // Create an Intent to navigate to CbaActivity
            Intent intent = new Intent(ProgramFacultyActivity.this, CbaActivity.class);
            startActivity(intent);
        });

        // 2. College of Education Card
        cardCoed.setOnClickListener(v -> {
            // Create an Intent to navigate to CoedActivity
            Intent intent = new Intent(ProgramFacultyActivity.this, CoedActivity.class);
            startActivity(intent);
        });

        // 3. College of Industrial Technology Card
        cardCit.setOnClickListener(v -> {
            // Create an Intent to navigate to CitActivity
            Intent intent = new Intent(ProgramFacultyActivity.this, CitActivity.class);
            startActivity(intent);
        });

        // 4. College of Information Technology and Engineering Card
        cardCite.setOnClickListener(v -> {
            // Create an Intent to navigate to CiteActivity
            Intent intent = new Intent(ProgramFacultyActivity.this, CiteActivity.class);
            startActivity(intent);
        });
    }
}
