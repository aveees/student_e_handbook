package com.firstapp.bulsustudente_handbook;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Arrays;
import java.util.List;

public class GeneralProvisionsActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_general_provisions);

        // Get header views
        ImageView menuIcon = findViewById(R.id.menu_icon);

        TextView title = findViewById(R.id.header_title);
        RecyclerView recyclerView = findViewById(R.id.recycler_cards);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        List<String> sections = Arrays.asList(
                "INSTITUTIONAL PHILOSOPHY",
                "POLICY STATEMENTS",
                "CLASSIFICATION OF STUDENTS",
                "STUDENT'S RIGHTS, OBLIGATIONS, AND RESPONSIBILITIES",
                "OBEDIENCE TO THE LAWS OF THE LAND",
                "STUDENTS' ORIENTATION"
        );

        SectionAdapter adapter = new SectionAdapter(this, sections);
        recyclerView.setAdapter(adapter);

        // Set header values dynamically

        title.setText("GENERAL PROVISIONS");


        // Optional: handle back arrow click
        menuIcon.setOnClickListener(v -> finish());
    }
}
