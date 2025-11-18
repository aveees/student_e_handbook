package com.firstapp.bulsustudente_handbook;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.button.MaterialButtonToggleGroup;

public class MissionActivity extends AppCompatActivity {

    private MaterialButtonToggleGroup toggleGroup;
    private MaterialButton btnEnglish, btnTagalog;
    private TextView textContent;

    private final String missionEnglish =
            "The Bulacan State University exists to produce highly competent, ethical and service-oriented professionals that contribute to the sustainable socio-economic growth and development of the nation.";

    private final String missionTagalog =
            "Ang Bulacan State University ay may hangaring humubog ng mga propesyonal na mahuhusay, " +
                    "etikal, at handang maglingkod, na nakapag-aambag sa patuloy na pag-unlad ng bayan.";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mission);

        toggleGroup = findViewById(R.id.languageToggle);
        btnEnglish = findViewById(R.id.btnEnglish);
        btnTagalog = findViewById(R.id.btnTagalog);
        textContent = findViewById(R.id.textContent);

        setupToggleBehavior();

        // Header
        ImageView menuIcon = findViewById(R.id.menu_icon);
        TextView title = findViewById(R.id.header_title);
        title.setText("MISSION");
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
        btnEnglish.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.green_selected));
        btnEnglish.setTextColor(ContextCompat.getColor(this, android.R.color.white));

        btnTagalog.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.transparent_unselected));
        btnTagalog.setTextColor(ContextCompat.getColor(this, R.color.darker_gray));

        textContent.setText(missionEnglish);
    }

    private void setTagalogSelected() {
        btnTagalog.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.green_selected));
        btnTagalog.setTextColor(ContextCompat.getColor(this, android.R.color.white));

        btnEnglish.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.transparent_unselected));
        btnEnglish.setTextColor(ContextCompat.getColor(this, R.color.darker_gray));

        textContent.setText(missionTagalog);
    }
}
