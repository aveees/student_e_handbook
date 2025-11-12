package com.firstapp.bulsustudente_handbook;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MissionActivity extends AppCompatActivity {

    private Button btnEnglish, btnTagalog;
    private TextView textContent;

    private final String missionEnglish = "The Bulacan State University exists to produce highly competent, ethical and service-oriented professionals that contribute to the sustainable socio-economic growth and development of the nation.";
    private final String missionTagalog = "Ang Bulacan State University ay may hangaring humubog ng mga propesyonal na mahuhusay, etikal, at handang maglingkod, na nakapag-aambag sa patuloy na pag-unlad ng bayan.";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mission);

        btnEnglish = findViewById(R.id.btnEnglish);
        btnTagalog = findViewById(R.id.btnTagalog);
        textContent = findViewById(R.id.textContent);

        btnEnglish.setOnClickListener(v -> setLanguage(true));
        btnTagalog.setOnClickListener(v -> setLanguage(false));

        // Get header views
        ImageView menuIcon = findViewById(R.id.menu_icon);

        TextView title = findViewById(R.id.header_title);
        TextView breadcrumbs = findViewById(R.id.breadcrumbs); // from layout_section_header.xml

        // Set header values dynamically

        title.setText("MISSION");
        // Optional: handle back arrow click
        menuIcon.setOnClickListener(v -> finish());

    }

    private void setLanguage(boolean isEnglish) {
        if (isEnglish) {
            btnEnglish.setBackgroundResource(R.drawable.btn_selected);
            btnEnglish.setTextColor(getResources().getColor(android.R.color.white));
            btnTagalog.setBackgroundResource(R.drawable.btn_unselected);
            btnTagalog.setTextColor(getResources().getColor(android.R.color.darker_gray));
            textContent.setText(missionEnglish);
        } else {
            btnTagalog.setBackgroundResource(R.drawable.btn_selected);
            btnTagalog.setTextColor(getResources().getColor(android.R.color.white));
            btnEnglish.setBackgroundResource(R.drawable.btn_unselected);
            btnEnglish.setTextColor(getResources().getColor(android.R.color.darker_gray));
            textContent.setText(missionTagalog);
        }
    }
}
