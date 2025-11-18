package com.firstapp.bulsustudente_handbook;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class CiteViewPagerAdapter extends FragmentStateAdapter {

    public CiteViewPagerAdapter(@NonNull FragmentActivity fragmentActivity) { super(fragmentActivity); }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 0: return new CiteProgramsFragment();
            case 1: return new CiteFacultyFragment();
            case 2: return new CiteCurriculumFragment();
            default: return new CiteProgramsFragment();
        }
    }

    @Override
    public int getItemCount() { return 3; }
}
