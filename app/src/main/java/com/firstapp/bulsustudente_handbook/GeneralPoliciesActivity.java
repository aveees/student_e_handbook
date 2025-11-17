package com.firstapp.bulsustudente_handbook;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

// 1. Make it an Activity
public class GeneralPoliciesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 2. Connect it to the layout file
        setContentView(R.layout.activity_general_policies);

        // 3. Setup the header
        ImageView backBtn = findViewById(R.id.menu_icon);
        TextView headerTitle = findViewById(R.id.header_title);

        if (headerTitle != null) {
            headerTitle.setText("General Policies");
        }

        if (backBtn != null) {
            backBtn.setOnClickListener(v -> onBackPressed()); // Makes the icon a back button
        }
    }
}
