package com.firstapp.bulsustudente_handbook;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.button.MaterialButtonToggleGroup;

public class GoalsActivity extends AppCompatActivity {

    private MaterialButtonToggleGroup toggleGroup;
    private MaterialButton btnEnglish, btnTagalog;
    private TextView textContent;

    private final String goalsEnglish =
            "In the pursuit of its mission, the University gears its initiatives and efforts "
                    + "towards attainment of the following goals:\n"
                    + "1. Provide Relevant Quality and Accessible Education;\n"
                    + "2. Provide Innovative and Responsive Research and Extension Programs;\n"
                    + "3. BulSU in Regional Development;\n"
                    + "4. Sound Financial Management and Resource Generation; and\n"
                    + "5. Good Governance.";

    private final String goalsTagalog =
            "Sa pagtupad ng misyon nito, isinusulong ng Unibersidad ang mga programang nakatuon "
                    + "sa pagkamit ng mga sumusunod na layunin:\n"
                    + "1. Pagbibigay ng Makabuluhan, Mataas na Kalidad, at Makatarungang Edukasyon;\n"
                    + "2. Mga Programang Makabago at Tumutugon sa Pananaliksik at Paglilingkod;\n"
                    + "3. Mas Pinatibay na Papel ng BulSU sa Kaunlarang Panrehiyon;\n"
                    + "4. Matatag at Responsableng Pamamahala sa Pananalapi; at\n"
                    + "5. Tapat at Mahusay na Pamamahala.";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goals);

        toggleGroup = findViewById(R.id.languageToggle);
        btnEnglish = findViewById(R.id.btnEnglish);
        btnTagalog = findViewById(R.id.btnTagalog);
        textContent = findViewById(R.id.textContent);

        setupToggleBehavior();

        // HEADER SETUP
        ImageView menuIcon = findViewById(R.id.menu_icon);
        TextView title = findViewById(R.id.header_title);

        title.setText("GOALS");
        menuIcon.setOnClickListener(v -> finish());
    }

    private void setupToggleBehavior() {
        toggleGroup.addOnButtonCheckedListener((g, checkedId, isChecked) -> {
            if (!isChecked) return;

            if (checkedId == R.id.btnEnglish) {
                setEnglish();
            } else {
                setTagalog();
            }
        });

        setEnglish(); // Default
    }

    private void setEnglish() {
        btnEnglish.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.green_selected));
        btnEnglish.setTextColor(ContextCompat.getColor(this, android.R.color.white));

        btnTagalog.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.transparent_unselected));
        btnTagalog.setTextColor(ContextCompat.getColor(this, R.color.darker_gray));

        textContent.setText(goalsEnglish);
    }

    private void setTagalog() {
        btnTagalog.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.green_selected));
        btnTagalog.setTextColor(ContextCompat.getColor(this, android.R.color.white));

        btnEnglish.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.transparent_unselected));
        btnEnglish.setTextColor(ContextCompat.getColor(this, R.color.darker_gray));

        textContent.setText(goalsTagalog);
    }
}
