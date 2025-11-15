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

import java.util.Arrays;
import java.util.List;

public class StudentWelfareActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_student_welfare);

        // INSETS
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // ----------------------------------------
        // HEADER
        // ----------------------------------------
        ImageView backBtn = findViewById(R.id.menu_icon);
        TextView headerTitle = findViewById(R.id.header_title);
        TextView breadcrumbs = findViewById(R.id.breadcrumbs);

        headerTitle.setText("STUDENT WELFARE");
        breadcrumbs.setText("STUDENT AFFAIRS");

        backBtn.setOnClickListener(v -> onBackPressed());

        // ----------------------------------------
        // RECYCLER VIEW ITEMS
        // ----------------------------------------
        RecyclerView recyclerView = findViewById(R.id.recycler_cards);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        List<String> sections = Arrays.asList(
                "A. GUIDANCE AND COUNSELLING SERVICES",
                "B. CAREER DEVELOPMENT AND STUDENT INTERNSHIP SERVICES",
                "C. PLACEMENT AND PUBLIC EMPLOYMENT SERVICES",
                "D. THE COMMISSION ON STUDENT ELECTIONS",
                "E. STUDENT GRIEVANCE",
                "F. STUDENT INSURANCE CLAIM"
        );

        SectionAdapter adapter = new SectionAdapter(this, sections);
        recyclerView.setAdapter(adapter);
    }
}
