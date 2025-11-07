package com.firstapp.bulsustudente_handbook;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class GetStartedActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_started);

        Button btnGetStarted = findViewById(R.id.btn_get_started);
        TextView aboutText = findViewById(R.id.about_text);

        btnGetStarted.setOnClickListener(v ->
                startActivity(new Intent(GetStartedActivity.this, DashboardActivity.class))
        );

        aboutText.setOnClickListener(v ->
                startActivity(new Intent(GetStartedActivity.this, AboutActivity.class))
        );
    }
}
