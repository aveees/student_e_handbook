package com.firstapp.bulsustudente_handbook;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ChangeAcademicLoadActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_change_academic_load);

        // Apply window insets
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // ----------------------------------------
        // ✅ HEADER SETUP (same style as AbsencesActivity)
        // ----------------------------------------
        View header = findViewById(R.id.header_section);

        ImageView backBtn = header.findViewById(R.id.menu_icon);
        TextView headerTitle = header.findViewById(R.id.header_title);
        TextView breadcrumbs = header.findViewById(R.id.breadcrumbs);

        // Set header title
        headerTitle.setText("CHANGE OF ACADEMIC LOAD");

        // Set breadcrumb
        breadcrumbs.setText("ACADEMIC REGULATIONS");

        // Back button functionality
        backBtn.setOnClickListener(v -> onBackPressed());
    }
}
