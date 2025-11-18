package com.firstapp.bulsustudente_handbook;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class CitViewPagerAdapter extends FragmentStateAdapter {

    public CitViewPagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 0: return new CitProgramsFragment();
            case 1: return new CitFacultyFragment();
            case 2: return new CitCurriculumFragment();
            default: return new CitProgramsFragment();
        }
    }

    @Override
    public int getItemCount() { return 3; }
}
