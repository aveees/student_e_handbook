package com.firstapp.bulsustudente_handbook;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ScholarshipsFinancialAidActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_scholarships_financial_aid);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // ----------------------------------------
        // ✅ HEADER SETUP
        // ----------------------------------------
        ImageView backBtn = findViewById(R.id.menu_icon);
        TextView headerTitle = findViewById(R.id.header_title);
        TextView breadcrumbs = findViewById(R.id.breadcrumbs);

        headerTitle.setText("SCHOLARSHIPS & FINANCIAL AID");
        breadcrumbs.setText("STUDENT SERVICES");

        backBtn.setOnClickListener(v -> onBackPressed());
    }
}
