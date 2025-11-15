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

public class StudentAffairsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_student_affairs_and_services);

        // Apply window insets
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // ✅ Header
        ImageView backBtn = findViewById(R.id.menu_icon);
        TextView headerTitle = findViewById(R.id.header_title);

        headerTitle.setText("STUDENT AFFAIRS AND SERVICES");

        backBtn.setOnClickListener(v -> onBackPressed());

        // ✅ RecyclerView list
        RecyclerView recyclerView = findViewById(R.id.recycler_cards);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        List<String> sections = Arrays.asList(
                "THE OFFICE OF THE DEAN\nFOR STUDENT AFFAIRS AND SERVICES",
                "STUDENT SERVICES",
                "STUDENT WELFARE",
                "STUDENT DEVELOPMENT",
                "STUDENT GOVERNMENT",
                "STUDENT REWARDS AND INCENTIVES"
        );


        SectionAdapter adapter = new SectionAdapter(this, sections);
        recyclerView.setAdapter(adapter);
    }
}
