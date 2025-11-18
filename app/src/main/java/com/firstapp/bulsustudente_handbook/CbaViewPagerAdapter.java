package com.firstapp.bulsustudente_handbook;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class CbaViewPagerAdapter extends FragmentStateAdapter {

    public CbaViewPagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        // Return the Fragment for the given position
        switch (position) {
            case 0:
                return new CbaProgramsFragment();
            case 1:
                return new CbaFacultyFragment();
            case 2:
                return new CbaCurriculumFragment();
            default:
                // Return a default fragment if something goes wrong
                return new CbaProgramsFragment();
        }
    }

    @Override
    public int getItemCount() {
        // We have 3 tabs
        return 3;
    }
}
