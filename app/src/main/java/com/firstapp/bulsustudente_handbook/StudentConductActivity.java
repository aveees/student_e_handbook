package com.firstapp.bulsustudente_handbook;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Arrays;
import java.util.List;

public class StudentConductActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_conduct);

        // ✅ Header Setup
        ImageView backBtn = findViewById(R.id.menu_icon); // Assuming your header has an icon with this ID
        TextView headerTitle = findViewById(R.id.header_title);

        // Set the header title
        if (headerTitle != null) {
            headerTitle.setText("Student Conduct and Discipline");
        }

        // Make the back button functional
        if (backBtn != null) {
            backBtn.setOnClickListener(v -> onBackPressed());
        }

        // ✅ RecyclerView Setup
        RecyclerView recyclerView = findViewById(R.id.recycler_cards);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Create the list of section titles
        List<String> sections = Arrays.asList(
                "General Policies",
                "Students' Conduct and Responsibilities",
                "Disciplinary Sanctions & Penalties",
                "Grounds for Disciplinary Sanctions",
                "Administrative Bodies Governing Student Disciplinary Proceedings, Their Compositions, Functions and Jurisdiction",
                "Rules of Procedure",
                "Students’ Grievance Procedure"
        );

        // Create and set the adapter
        SectionAdapter adapter = new SectionAdapter(this, sections); // Using SectionAdapter
        recyclerView.setAdapter(adapter);
    }
}
