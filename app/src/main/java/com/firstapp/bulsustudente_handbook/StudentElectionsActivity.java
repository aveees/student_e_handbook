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

public class StudentElectionsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_student_elections);

        // Apply window insets
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // ----------------------------------------
        // ✅ HEADER SETUP
        // ----------------------------------------
        View header = findViewById(R.id.header_section);

        ImageView backBtn = header.findViewById(R.id.menu_icon);
        TextView headerTitle = header.findViewById(R.id.header_title);
        TextView breadcrumbs = header.findViewById(R.id.breadcrumbs);

        headerTitle.setText("STUDENT ELECTIONS");
        breadcrumbs.setText("STUDENT WELFARE");

        backBtn.setOnClickListener(v -> onBackPressed());
    }
}
