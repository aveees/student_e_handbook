package com.firstapp.bulsustudente_handbook;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class CiteActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cite);

        // Header Setup
        ImageView backBtn = findViewById(R.id.menu_icon);
        TextView headerTitle = findViewById(R.id.header_title);
        headerTitle.setText("College of IT and Engineering");
        backBtn.setOnClickListener(v -> onBackPressed());

        // Initialize Tabs and ViewPager
        TabLayout tabLayout = findViewById(R.id.tab_layout);
        ViewPager2 viewPager = findViewById(R.id.view_pager);

        // Set adapter
        CiteViewPagerAdapter adapter = new CiteViewPagerAdapter(this);
        viewPager.setAdapter(adapter);

        // Link Tabs and ViewPager
        new TabLayoutMediator(tabLayout, viewPager, (tab, position) -> {
            switch (position) {
                case 0: tab.setText("Programs"); break;
                case 1: tab.setText("Faculty"); break;
                case 2: tab.setText("Curriculum"); break;
            }
        }).attach();
    }
}
