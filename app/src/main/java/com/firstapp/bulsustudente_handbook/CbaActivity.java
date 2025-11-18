package com.firstapp.bulsustudente_handbook;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class CbaActivity extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager2 viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cba);

        // Standard Header Setup
        ImageView backBtn = findViewById(R.id.menu_icon);
        TextView headerTitle = findViewById(R.id.header_title);
        if (headerTitle != null) {
            headerTitle.setText("College of Business Administration");
        }
        if (backBtn != null) {
            backBtn.setOnClickListener(v -> onBackPressed());
        }

        // Initialize Tabs and ViewPager
        tabLayout = findViewById(R.id.tab_layout);
        viewPager = findViewById(R.id.view_pager);

        // Create and set the adapter
        CbaViewPagerAdapter adapter = new CbaViewPagerAdapter(this);
        viewPager.setAdapter(adapter);

        // Link the TabLayout with the ViewPager
        new TabLayoutMediator(tabLayout, viewPager, (tab, position) -> {
            switch (position) {
                case 0:
                    tab.setText("Programs");
                    break;
                case 1:
                    tab.setText("Faculty");
                    break;
                case 2:
                    tab.setText("Curriculum");
                    break;
            }
        }).attach();
    }
}
