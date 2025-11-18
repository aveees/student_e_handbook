package com.firstapp.bulsustudente_handbook;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AcademicRegulationsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_academic_regulation);

        // Apply window insets
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // ✅ Header
        ImageView backBtn = findViewById(R.id.menu_icon);
        TextView headerTitle = findViewById(R.id.header_title);

        headerTitle.setText("ACADEMIC REGULATIONS");

        backBtn.setOnClickListener(v -> onBackPressed());

        // ✅ RecyclerView list
        RecyclerView recyclerView = findViewById(R.id.recycler_cards);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        List<String> items = Arrays.asList(
                "A. ADMISSION REQUIREMENT",
                "B. CHANGE OF ACADEMIC LOAD",
                "C. SUBSTITUTION OF SUBJECTS",
                "D. TUTORIAL AND SPECIAL CLASSES",
                "E. DROPPING OF SUBJECTS",
                "F. ATTENDANCE",
                "G. ABSENCES",
                "H. LEAVE OF ABSENCE",
                "I. MAXIMUM RESIDENCY REQUIREMENT",
                "J. EXAMINATIONS",
                "K. GRADING SYSTEM",
                "L. TRANSPARENCY AND CORRECTION OF GRADES",
                "M. ACADEMIC DELINQUENCY",
                "N. GOLD GEAR AWARDS",
                "O. GRADUATION REQUIREMENTS",
                "P. COMMENCEMENT EXERCISES",
                "Q. GRADUATION AWARDS",
                "R. STUDENT RECORDS"
        );


        SectionAdapter adapter = new SectionAdapter(this, items);
        recyclerView.setAdapter(adapter);
    }
}
