package com.firstapp.bulsustudente_handbook;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.button.MaterialButtonToggleGroup;

public class VisionActivity extends AppCompatActivity {

    private MaterialButtonToggleGroup toggleGroup;
    private MaterialButton btnEnglish, btnTagalog;
    private TextView textContent;

    private final String visionEnglish =
            "The Bulacan State University is a progressive knowledge generating\n" +
                    "institution globally recognized for excellent instruction, pioneering research, and\n" +
                    "responsive community engagements.";

    private final String visionTagalog =
            "Ang Bulacan State University ay isang progresibong institusyong lumilikha ng kaalaman na " +
                    "kinikilala sa daigdig sa pinakamahusay na pagtuturo, nangungunang mga pananaliksik, at maagap na pagtugon sa pangangailangan ng komunidad.";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vision);

        toggleGroup = findViewById(R.id.languageToggle);
        btnEnglish = findViewById(R.id.btnEnglish);
        btnTagalog = findViewById(R.id.btnTagalog);
        textContent = findViewById(R.id.textContent);

        setupToggleBehavior();

        // Header section
        ImageView menuIcon = findViewById(R.id.menu_icon);
        TextView title = findViewById(R.id.header_title);
        title.setText("VISION");
        menuIcon.setOnClickListener(v -> finish());
    }

    private void setupToggleBehavior() {
        toggleGroup.addOnButtonCheckedListener((group, checkedId, isChecked) -> {
            if (!isChecked) return;

            if (checkedId == R.id.btnEnglish) {
                setEnglishSelected();
            } else if (checkedId == R.id.btnTagalog) {
                setTagalogSelected();
            }
        });

        // Default selection
        setEnglishSelected();
    }

    private void setEnglishSelected() {
        // Button colors
        btnEnglish.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.green_selected));
        btnEnglish.setTextColor(ContextCompat.getColor(this, android.R.color.white));

        btnTagalog.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.transparent_unselected));
        btnTagalog.setTextColor(ContextCompat.getColor(this, R.color.darker_gray));

        // Text content
        textContent.setText(visionEnglish);
    }

    private void setTagalogSelected() {
        btnTagalog.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.green_selected));
        btnTagalog.setTextColor(ContextCompat.getColor(this, android.R.color.white));

        btnEnglish.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.transparent_unselected));
        btnEnglish.setTextColor(ContextCompat.getColor(this, R.color.darker_gray));

        textContent.setText(visionTagalog);
    }
}
