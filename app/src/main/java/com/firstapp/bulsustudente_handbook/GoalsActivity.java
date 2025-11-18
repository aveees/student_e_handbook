package com.firstapp.bulsustudente_handbook;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class GoalsActivity extends AppCompatActivity {

    private Button btnEnglish, btnTagalog;
    private TextView textContent;

    private final String goalsEnglish = "In the pursuit of its mission, the University gears its initiatives and efforts\n" +
            "towards attainment of the following goals:\n" +
            "1. Provide Relevant Quality and Accessible Education;\n" +
            "2. Provide Innovative and Responsive Research and Extension Programs;\n" +
            "3. BulSU in Regional Development;\n" +
            "4. Sound Financial Management and Resource Generation; and\n" +
            "5. Good Governance.";
    private final String goalsTagalog = "Sa pagtupad ng misyon nito, isinusulong ng Unibersidad ang mga programang nakatuon\n" +
            "sa pagkamit ng mga sumusunod na layunin:\n" +
            "1. Pagbibigay ng Makabuluhan, Mataas na Kalidad, at Likas na Makatarungang Edukasyon;\n" +
            "2. Pagsasagawa ng Makabago, Masinop, at Tumutugong mga Programa sa Pananaliksik at Paglilingkod sa Komunidad;\n" +
            "3. Mas Pinatibay na Papel ng BulSU sa Kaunlarang Panrehiyon;\n" +
            "4. Matatag at Responsableng Pamamahala sa Pananalapi at Epektibong Paglikha ng mga Kinakailangang Yaman; at\n" +
            "5. Pagtatatag ng Tapat, Mahusay, at Makabayang Pamamahala.";

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

        title.setText("GOALS");
        // Optional: handle back arrow click
        menuIcon.setOnClickListener(v -> finish());

    }

    private void setLanguage(boolean isEnglish) {
        if (isEnglish) {
            btnEnglish.setBackgroundResource(R.drawable.btn_selected);
            btnEnglish.setTextColor(getResources().getColor(android.R.color.white));
            btnTagalog.setBackgroundResource(R.drawable.btn_unselected);
            btnTagalog.setTextColor(getResources().getColor(android.R.color.darker_gray));
            textContent.setText(goalsEnglish);
        } else {
            btnTagalog.setBackgroundResource(R.drawable.btn_selected);
            btnTagalog.setTextColor(getResources().getColor(android.R.color.white));
            btnEnglish.setBackgroundResource(R.drawable.btn_unselected);
            btnEnglish.setTextColor(getResources().getColor(android.R.color.darker_gray));
            textContent.setText(goalsTagalog);
        }
    }
}
