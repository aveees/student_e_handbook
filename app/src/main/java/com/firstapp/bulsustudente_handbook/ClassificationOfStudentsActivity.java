package com.firstapp.bulsustudente_handbook;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ClassificationOfStudentsActivity extends AppCompatActivity { @Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_class_of_students);

    // Get header views
    ImageView menuIcon = findViewById(R.id.menu_icon);

    TextView title = findViewById(R.id.header_title);
    TextView breadcrumbs = findViewById(R.id.breadcrumbs); // from layout_section_header.xml

    // Set header values dynamically

    title.setText("CLASSIFICATION OF STUDENTS");
    breadcrumbs.setText("General Provisions");


    // Optional: handle back arrow click
    menuIcon.setOnClickListener(v -> finish());
}

}
