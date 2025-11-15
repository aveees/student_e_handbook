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

public class StudentServicesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_student_services);

        // INSETS
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // HEADER
        ImageView backBtn = findViewById(R.id.menu_icon);
        TextView headerTitle = findViewById(R.id.header_title);
        TextView breadcrumbs = findViewById(R.id.breadcrumbs);

        headerTitle.setText("STUDENT SERVICES");
        breadcrumbs.setText("STUDENT AFFAIRS and SERVICES");

        backBtn.setOnClickListener(v -> onBackPressed());

        // ----------------------------------------
        // ✅ RECYCLER VIEW FOR STUDENT SERVICES
        // ----------------------------------------
        RecyclerView recyclerView = findViewById(R.id.recycler_cards);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        List<String> sections = Arrays.asList(
                "A. ADMISSIONS AND ORIENTATION",
                "B. SCHOLARSHIPS AND FINANCIAL ASSISTANCE",
                "C. STUDENT SOCIO-ECONOMIC INVOLVEMENT",
                "D. STUDENTS WITH SPECIAL NEEDS AND PERSONS WITH DISABILITIES"
        );


        SectionAdapter adapter = new SectionAdapter(this, sections);
        recyclerView.setAdapter(adapter);
    }
}
