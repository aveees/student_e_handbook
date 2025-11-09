package com.firstapp.bulsustudente_handbook;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class HistoryActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);

        // Get header views
        ImageView menuIcon = findViewById(R.id.menu_icon);
        TextView line1 = findViewById(R.id.header_line1);
        TextView title = findViewById(R.id.header_title);
        TextView subtitle = findViewById(R.id.header_subtitle);

        // Set header values dynamically
        line1.setText("HISTORY OF");
        title.setText("BULACAN STATE UNIVERSITY");
        subtitle.setText("Bustos Campus");

        // Optional: handle back arrow click
        menuIcon.setOnClickListener(v -> finish());
    }
}
