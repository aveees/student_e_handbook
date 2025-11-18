package com.firstapp.bulsustudente_handbook;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class CoedViewPagerAdapter extends FragmentStateAdapter {

    public CoedViewPagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 0:
                return new CoedProgramsFragment();
            case 1:
                return new CoedFacultyFragment();
            case 2:
                return new CoedCurriculumFragment();
            default:
                return new CoedProgramsFragment();
        }
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}
