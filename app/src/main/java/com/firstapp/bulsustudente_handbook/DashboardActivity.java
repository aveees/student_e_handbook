package com.firstapp.bulsustudente_handbook;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.List;

public class DashboardActivity extends AppCompatActivity {

    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private ImageView iconMenu;

    private RecyclerView recyclerCards;
    private CardAdapter cardAdapter;
    private List<CardItem> cardList;

    private EditText searchField;
    private TextView footerText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        // --- Drawer + Menu ---
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.navigation_view);
        iconMenu = findViewById(R.id.menu_icon);

        iconMenu.setOnClickListener(v -> drawerLayout.openDrawer(navigationView));

        // --- Search Bar ---
        searchField = findViewById(R.id.search_field);
        searchField.setSingleLine(true);
        searchField.setImeOptions(EditorInfo.IME_ACTION_SEARCH);
        searchField.setOnEditorActionListener((v, actionId, event) -> {
            if (actionId == EditorInfo.IME_ACTION_SEARCH ||
                    (event != null && event.getKeyCode() == KeyEvent.KEYCODE_ENTER)) {
                performSearch(searchField.getText().toString());
                return true;
            }
            return false;
        });

        // --- RecyclerView ---
        recyclerCards = findViewById(R.id.recycler_cards);
        recyclerCards.setLayoutManager(new LinearLayoutManager(this));

        loadCardData();

        cardAdapter = new CardAdapter(cardList);
        recyclerCards.setAdapter(cardAdapter);

        // --- Footer ---
        footerText = findViewById(R.id.footer_text);
        footerText.setText("Bulacan State University - Bustos Campus\nStudent Handbook © 2023. All rights reserved.");
    }

    private void loadCardData() {
        cardList = new ArrayList<>();
        cardList.add(new CardItem(R.drawable.ic_history, "History of BulSU",
                "Learn about the founding, milestones, and evolution of Bulacan State University over the years."));
        cardList.add(new CardItem(R.drawable.ic_drum, "BulSU Hymn and March",
                "Discover the history, significance, and lyrics of the BulSU Hymn and March."));
        cardList.add(new CardItem(R.drawable.ic_ar, "Academic Regulations",
                "Explore BulSU’s academic rules and guidelines to ensure a smooth educational journey."));
        cardList.add(new CardItem(R.drawable.ic_gp, "General Provisions",
                "Understand the foundational rules and general provisions governing BulSU operations."));
        cardList.add(new CardItem(R.drawable.ic_scr, "Student Conduct and Discipline",
                "Learn about BulSU’s code of conduct, student responsibilities, and disciplinary procedures."));
        cardList.add(new CardItem(R.drawable.ic_sas, "Student Affairs and Services",
                "Explore the services, programs, and support systems available to students at BulSU."));
        cardList.add(new CardItem(R.drawable.ic_pfc, "Program, Faculty, and Curriculum",
                "Get detailed information on the academic programs, faculty, and curricula offered at BulSU."));
        cardList.add(new CardItem(R.drawable.ic_acnts, "Administrative Council and Non-Teaching Staff",
                "Meet the administrative council and non-teaching staff who support BulSU’s academic mission."));
        cardList.add(new CardItem(R.drawable.ic_org, "Student Organizations",
                "Discover various student organizations and clubs that enrich campus life at BulSU."));
        cardList.add(new CardItem(R.drawable.ic_lsc, "Local Student Council",
                "Learn about the roles and activities of the Local Student Council in representing students."));
        cardList.add(new CardItem(R.drawable.ic_dis, "Directory & Institutional Services of BulSU-BC",
                "Access important contacts, offices, and institutional services across the BulSU-BC campus."));
    }

    private void performSearch(String query) {
        // TODO: Implement actual search logic
        Toast.makeText(this, "Search: " + query, Toast.LENGTH_SHORT).show();
    }
}
